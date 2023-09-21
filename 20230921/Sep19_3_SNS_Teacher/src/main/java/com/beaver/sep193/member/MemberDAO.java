package com.beaver.sep193.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.db.manager.BeaverDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
	public static void signUp(HttpServletRequest req) {
		// 일단 파일업로드 시도
		String path = null;
		MultipartRequest mr = null;
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());
		} catch (Exception e) { // 파일 업로드 실패의 경우
			e.printStackTrace();
			req.setAttribute("r", "회원가입 실패(사진파일 용량)");
			return;	// 업로드에 실패하면 뒤에 남을 DB작업 하지 말자 (강제 종료)
		}
		
		// 파일 업로드 성공시에 계속 진행
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			String y = mr.getParameter("m_y");
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String birthday = String.format("%s%02d%02d", y, m, d);
			String photo = mr.getFilesystemName("m_photo");
			photo = URLEncoder.encode(photo, "UTF-8").replace("+", " ");
			
			String sql = "insert into sns_member values( "
					+ "?, ?, ?, ?, to_date(?, 'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birthday);
			pstmt.setString(6, photo);
			
			if (pstmt.executeUpdate() == 1) {
				req.setAttribute("r", "회원가입 성공!");
			}
		} catch (Exception e) { // DB서버 연결 상태 :p
			e.printStackTrace();
			// DB쪽 문제로 가입은 실패지만, 사진파일이 업로드는 되어있는 상태
			// 사진 파일 지워줘야
			File f = new File(path + "/" + mr.getFilesystemName("m_photo"));
			f.delete();
			req.setAttribute("r", "회원가입 실패(DB서버)");
		}
		BeaverDBManager.close(con, pstmt, null);
	}
	
	public static void login(HttpServletRequest req, HttpServletResponse res) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			req.setCharacterEncoding("UTF-8");
			String id = req.getParameter("m_id");
			String pw = req.getParameter("m_pw");
			
	// String sql = "select * from sns_member"; // 회원이 1000명이면 그거 다 ??
	// String sql = "select * from sns_member where m_id = ? and m_pw = ?";
	// String sql = "select * from sns_member where m_id='1' or '1'='1';drop table sns_member...";
		// 해킹 기법 - SQL Injection
		// 	보안상 취약점을 이용해서 데이터베이스가 비정상적인 동작을 하게 하는 기법
			String sql = "select * from sns_member where m_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 데이터가 있는지 + 그 데이터를 가리키게
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(rs.getString("m_id"), dbPw, rs.getString("m_name"),
							rs.getString("m_phone"), rs.getDate("m_birthday"),
							URLDecoder.decode(rs.getString("m_photo"), "UTF-8"));
					req.getSession().setAttribute("loginMember", m);
					req.getSession().setMaxInactiveInterval(600);
					
					Cookie c = new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					res.addCookie(c);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else { // 데이터가 없는 경우
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(DB서버)");
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	
	public static boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		//세션에 저장시켜둔, 로그인 객체(DTO 객체)를 받아와본다.
		if (m != null) {
			// 로그인이 되어 있어서, 세션에 DTO 객체가 있는 걸로 확인된다면
			// 로그인 페이지를 로그인 상태 페이지로 세션에 등록해준다.
			req.setAttribute("lp", "member/welcome.jsp");
			// boolean형을 true로 리턴
			return true;
		}
		// 로그인이 되어있지 않거나 실패해서, 세션에 DTO 객체가 없다면
		req.setAttribute("lp", "member/login.jsp");
		return false;
	}
	
	// 로그아웃
	public static void logout(HttpServletRequest req) {
		// 세션 끊기 : 다른 세션도 들어가있기 때문에 비추 !
		// req.getSession().setMaxInactiveInterval(-1);
		
		// Member에 대한 session만 null로 바꿔주면...
		req.getSession().setAttribute("loginMember", null);
		req.setAttribute("r", "로그아웃 성공");
	}
	
	public static void update(HttpServletRequest req) {
		//사용된 사이트에서는, 기존 정보를 담고있는 input 항목에서 입력된 정보(새것이든, 기존것이든)를 전해받아
		//DB에 새 정보로 업데이트 시켜줄 계획이다.
		
		//먼저 파일 처리부터.
		//파일 업로드부터 시도해서 실패한다면(대체로 용량 초과), DB 갈거 없이 여기서 바로 커트.
		//정보 수정해서 사진 파일 항목과 관련된 상황은 2가지가 있을 것이다.
		//1. 사진 파일을 새로 넣은 경우 : 새 파일로 적용해줘야 한다.
		//2. 사진 파일을 그대로 쓰는 경우 : 기존 것을 그대로 사용한다. 
		String path = null;
		MultipartRequest mr = null;
		//세션에 있는 DTO 객체 받아오기
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		//새로 적용할 파일명, 기존 파일명 2개로 나눠서 사용
		//예전 파일명은 DTO 객체 받아온것의 사진파일 이름을 받아온다
		String old_m_photo = m.getM_photo();
		String new_m_photo = null;
		
		try {
			path = req.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "UTF-8",
					new DefaultFileRenamePolicy());
			
			//수정 페이지의 input에서 받아온 파일명 값을 새 파일명에 적용
			new_m_photo = mr.getFilesystemName("m_photo");
			//그리고 새 파일명을 정상적으로 가져왔다면(새로 적용할 파일을 수정 페이지에서 선택하고 수정을 눌렀다면)
			if(new_m_photo != null) {
				//웹페이지에서 doPost로 전달된 파일명을, URL을 건너서왔으므로 JAVA에서 UTF-8로 변환
				//URL 상에서 띄어쓰기는 +로 변환되었으므로, 자바에서 다시 " "(스페이스)로 변환해준다.
				new_m_photo = URLEncoder.encode(new_m_photo, "UTF-8").replace("+", " ");
			} else { // 새 파일명이 존재하지 않는다면(수정 페이지에서 새로 적용할 파일을 집어넣지 않고 수정을 눌렀다면)
				//새 파일명에 그냥 기존 파일명을 집어넣어 사용한다.
				new_m_photo = old_m_photo;
			}
			
		} catch (Exception e) {
			//여기 try-catch에서는 파일 용량과 관련한 예외가 넘어올 것이다.
			System.out.println("첨부한 파일 용량이 규격을 넘어섭니다.");
			return; // 파일 관련 처리에서 예외나면 이후 코드 그냥 실행하지 않겠다.
		}
		
		//--------------------------------
		//위 파일 처리에서 별 일 없었다면(정한 용량 30MB 이하로, 기존 혹은 새 파일이 잘 업로드 되었다면), 다음으로 이동
		//파일을 수정해서 새 사진을 넣었다면, 사진이 바뀌어야 하므로 DB에 새 파일명이 들어가야 한다. => 새 파일명 확보 필요.
		//기존에 업로드 되어있던 기존 파일은 삭제해야 한다. => 원래 프사의 파일명 확보 필요.
		
		//파일을 수정하지 않아 기존 사진을 사용한다면 => 기존 프사 파일명을 그대로 DB에 넣을 것이다. => 원래 프사 파일명 확보.
		
		//DB 접근 시작
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			con = BeaverDBManager.connect("beaverPool");
			//수정 페이지에서 받아온 데이터 변수로 빼기.
			//데이터 추가 때와 같은 양식으로, 각각 ID 비번 이름 전번 생년월일.
			String m_id = mr.getParameter("m_id");
			String m_pw = mr.getParameter("m_pw");
			String m_name = mr.getParameter("m_name");
			String m_phone = mr.getParameter("m_phone");
			String m_y = mr.getParameter("m_y");
			int m_m = Integer.parseInt(mr.getParameter("m_m"));
			int m_d = Integer.parseInt(mr.getParameter("m_d"));
			String m_birthday = String.format("%s%02d%02d", m_y, m_m, m_d);
			
			//SQL문 작성. 특정 ID 하나의 비번, 이름, 전번, 생년월일, 사진파일명을 UPDATE로 수정
			String sql = "update sns_member set m_pw=?, m_name=?, m_phone=?, "
					   + "m_birthday=to_date(?, 'YYYYMMDD'), m_photo=? where m_id=?";
			
			//sql문에서 DATE 타입을 집어넣을 때에는, String을 to_date형식으로 짜서 넣는다. 위 SQL문 참조.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_pw);
			pstmt.setString(2, m_name);
			pstmt.setString(3, m_phone);
			pstmt.setString(4, m_birthday);
			pstmt.setString(5, new_m_photo);
			pstmt.setString(6, m_id);
			
			if(pstmt.executeUpdate() == 1) { // 위 SQL문이 잘 먹혔다면
				req.setAttribute("r", "정보수정 성공");
				//SQL문이 잘 먹혔을 때, 새 파일 명과 기존 파일 명이 다르다면?
				if(!new_m_photo.equals(old_m_photo)) { 
				// 이거 왜 쓰느냐? 사진파일을 변경했으면 이전 업로드된 사진 파일을 삭제하기 위해서.
				// 기존 파일 명은 웹페이지에서 받아온 값일 것이므로, java에서 사용하기 전에 decode 해준다.
					new File(path + "/" + URLDecoder.decode(old_m_photo, "UTF-8")).delete();
				}
				
				//로그인한 상태에서 정보 수정을 마쳐도, 로그인은 유지되게끔 할 예정이다.
				//그러므로, 현재 변경된 정보를 가진 상태에서 변경된 정보를 로그인한 DTO 객체로 쏴준다.
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				m = new Member(m_id, m_pw, m_name, m_phone, sdf.parse(m_birthday),
						URLDecoder.decode(new_m_photo, "UTF-8"));
				req.getSession().setAttribute("loginMember", m);
				
			} else { // 정보 수정에 실패했다면, 파일 업로드는 진행되었을 것이므로 올린 파일을 삭제한다.
				req.setAttribute("r", "정보 수정 실패");
				if(!new_m_photo.equals(old_m_photo)) {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "UTF-8")).delete();
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "정보 수정 실패(DB연결 실패)");
			if(!new_m_photo.equals(old_m_photo)) {
				try {
					new File(path + "/" + URLDecoder.decode(new_m_photo, "UTF-8")).delete();
				} catch(UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		BeaverDBManager.close(con, pstmt, null);
	}
	
	public static void delete(HttpServletRequest req) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			//DB연결 준비
			con = BeaverDBManager.connect("beaverPool");
			//프라이머리 키인 ID를 기준으로 SQL문을 작성하기 위해 세션에 저장되어 있는 로그인DTO 객체 받아오기.
			Member m = (Member)req.getSession().getAttribute("loginMember");
			//세션값 받아온 객체를 통해 ID 받아오기
			String m_id = m.getM_id();
			//로그인 상태인 ID를 가진 레코드를 삭제하라는 SQL문 작성
			String sql = "delete from sns_member where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m_id);
			
			if(pstmt.executeUpdate() == 1) { // 위 SQL문이 잘 작동했다면
				//위 sql문으로 DB데이터는 잘 삭제되었겠지만, img 내 업로드된 파일도 따로 삭제해주어야 한다.
				req.setAttribute("r", "탈퇴 성공");
				//객체에서 받아온 파일명은 인코딩된 상태이다(어디서 됐는지는 아직 모르겠음.).
				String m_photo = m.getM_photo();
				//그러므로 디코딩해줘야 java에서 쓸 수 있다.
				m_photo = URLDecoder.decode(m_photo, "UTF-8");
				String path = req.getServletContext().getRealPath("img");
				File f = new File(path + "/" + m_photo);
				f.delete();
				//탈퇴처리한 후, 로그아웃 메소드를 서블릿에 쓰면 로그아웃 성공이 떠버리므로
				//로그아웃 메소드는 쓰지 않고, 세션에 연결된 로그인 객체만 끊어주면
				//위의 "탈퇴 성공" 메시지가 페이지에 노출될 것이다.
				req.getSession().setAttribute("loginMember", null);
			} else { //SQL문을 통한 DB 레코드 삭제가 정상적으로 진행되지 않았을 경우
				req.setAttribute("r", "이미 탈퇴처리된 계정입니다.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴 실패(DB서버 접속 실패)");
		}
		
		BeaverDBManager.close(con, pstmt, null);
	}
}

