package com.inchel.Sep141.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.inchel.db.manager.InchelDBManager;

public class AppleDB {
	
	private static final AppleDB APPLEDB = new AppleDB();

	private AppleDB() {
		// TODO Auto-generated constructor stub
	}
	
	public static AppleDB getAppledb() {
		return APPLEDB;
	}
	
	private int pageNumber = 1;
	private int dataCount = 0;

	public void getPageCount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		dataCount = 0;
		
		int pageCount = 1;
		
		try {
			con = InchelDBManager.connect("inchelPool");
			String sql = "SELECT * FROM sep14_apple ORDER BY a_price";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dataCount++;
			}
			
			pageCount = dataCount % 5 == 0 ? dataCount / 5 : (dataCount / 5) + 1;
			//System.out.println("pageCount : " + pageCount);
			request.setAttribute("pagecount", pageCount);
			
		} catch(Exception e) {
			
		}
		
		InchelDBManager.close(con, pstmt, rs);
		
	}
	
	public void getAppleDB(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			if(request.getParameter("pagenumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
				//System.out.println("현재 페이지 : " + pageNumber);
			} else {
				pageNumber = 1;
				//System.out.println(request.getParameter("pagenumber"));
			}
			
			con = InchelDBManager.connect("inchelPool");
			
//			String sql = "SELECT ROWNUM, a_location, a_color, a_taste, a_price, a_introduce "
//					+ "FROM(SELECT a_location, a_color, a_taste, a_price, a_introduce, ROWNUM AS rn " 
//					 	+  "FROM(SELECT * FROM sep14_apple ORDER BY a_price)) "
//					 	 +  "WHERE rn BETWEEN " + ((pageNumber-1)*5 + 1) + " AND " + pageNumber*5;
			
			String sql = "SELECT a_location, a_color, a_taste, a_price, a_introduce, \"A_PAGENUM\" "
					   + "FROM(SELECT a_location, a_color, a_taste, a_price, a_introduce, "
					   + "dense_rank() over(order by a_price) \"A_PAGENUM\" FROM sep14_apple) "
					   + "WHERE \"A_PAGENUM\" BETWEEN " + ((pageNumber-1)*5 + 1) + " AND " + pageNumber*5;
			
			int startIdx = ((pageNumber-1)*5 + 1);
			int endIdx = pageNumber*5;
			
			System.out.println("startIdx : " + startIdx);
			System.out.println("endIdx : " + endIdx);
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<AppleDTO> aList = new ArrayList<AppleDTO>();
			AppleDTO a = null;
			
			while(rs.next()) {
				a = new AppleDTO();
				a.setLocation(rs.getString("a_location"));
				a.setColor(rs.getString("a_color"));
				a.setTaste(rs.getString("a_taste"));
				a.setPrice(rs.getInt("a_price"));
				a.setIntroduce(rs.getString("a_introduce"));
				aList.add(a);
			}
			
			request.setAttribute("alist", aList);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
//		while(rs.next()) {
//			
//			r.setno(rs.getInt("r_no"));
//			r.setName(rs.getString("r_name"));
//			r.setWhen(rs.getDate("r_time"));
//			r.setPhone(rs.getString("r_phonenum"));
//			r.setLocation(rs.getString("r_location"));
//			rsvs.add(r);
//		}
		try {
			InchelDBManager.close(con, pstmt, rs);
		} catch(Exception e) {
			
		}
	}
	
	public void createAppleDB(HttpServletRequest request) {
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		try {
		con = InchelDBManager.connect("inchelPool");
		
		String sql = "INSERT INTO sep14_apple VALUES(?, ?, ?, ?, ?)";
		
		pstmt = con.prepareStatement(sql);
		
		//지역 색 맛 가격 소개
		request.setCharacterEncoding("UTF-8"); // POST방식이라면 이거 써야됨. 넘어온 데이터 UTF-8로 변환
		pstmt.setString(1, request.getParameter("inputlocation"));
		pstmt.setString(2, request.getParameter("inputcolor"));
		pstmt.setString(3, request.getParameter("inputtaste"));
		pstmt.setInt(4, Integer.parseInt(request.getParameter("inputprice")));
		//소개의 경우, 줄내림이 있을 수 있어 replace를 통해서 버튼 상의 줄내림 값을 html 줄내림<br>로 변환해서 세팅
		pstmt.setString(5,request.getParameter("inputintroduce").replace("\r\n", "<br>"));
		
		if(pstmt.executeUpdate() == 1) {
			System.out.println("DB 추가 성공");
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//상세정보 가져오기(Primary key로 가져오기)
	//제대로 가져왔다면 : true 반환
	//못가져왔다면 : false 반환
	//제대로 가져오면 상세정보 화면으로 이동시키고, 아니라면 임의의 다른 곳으로 이동시키자.
	
	public boolean getAppleInfo(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try{
			con = InchelDBManager.connect("inchelPool");
			
			String getLocation = request.getParameter("getinfolocation");
			request.setAttribute("deletelocation", request.getParameter("getinfolocation"));
				
			String sql = "SELECT * FROM sep14_apple WHERE a_location = '" + getLocation +"'";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			AppleDTO a = null;
				
			while(rs.next()) {
				a = new AppleDTO();
				a.setLocation(rs.getString("a_location"));
				a.setColor(rs.getString("a_color"));
				a.setTaste(rs.getString("a_taste"));
				a.setPrice(rs.getInt("a_price"));
				a.setIntroduce(rs.getString("a_introduce"));
				request.setAttribute("info", a);
				return true;
			}
			return false; // 여기 false는, db에 해당 데이터가 없을 경우.
				
			} catch(Exception e){
				e.printStackTrace();
				return false; // 여기 false는, db 연결에서부터 뻑났을 때.
			}
			  finally {
			InchelDBManager.close(con, pstmt, rs);
			 }
	}
	
	public boolean updateAppleDB(HttpServletRequest request) {
		
	Connection con = null;
	PreparedStatement pstmt = null;
		
		try {
		con = InchelDBManager.connect("inchelPool");
			
		request.setCharacterEncoding("UTF-8"); // POST방식이라면 이거 써야됨. 넘어온 데이터 UTF-8로 변환
		String sql = "update sep14_apple set "
	               + "a_color=?, a_taste=?, a_price=?, a_introduce=? "
	                    + "where a_location =?";

		System.out.println(sql);
		
		pstmt = con.prepareStatement(sql);
		
		//지역 색 맛 가격 소개
		pstmt.setString(1, request.getParameter("updatecolor"));
		System.out.println(request.getParameter("updatecolor"));
		pstmt.setString(2, request.getParameter("updatetaste"));
		System.out.println(request.getParameter("updatetaste"));
		pstmt.setInt(3, Integer.parseInt(request.getParameter("updateprice")));
		System.out.println(request.getParameter("updateprice"));
		//소개의 경우, 줄내림이 있을 수 있어 replace를 통해서 버튼 상의 줄내림 값을 html 줄내림<br>로 변환해서 세팅
		pstmt.setString(4,request.getParameter("updateintroduce"));
		System.out.println(request.getParameter("updateintroduce"));
		pstmt.setString(5,request.getParameter("updatelocation"));
		System.out.println(request.getParameter("updatelocation"));
			
		if(pstmt.executeUpdate() == 1) {
			System.out.println("DB 변경 성공");
			return true;
		} else {
			System.out.println("DB 수정 실패");
			return false;
		}
		
	} catch(Exception e) {
		e.printStackTrace();
		return false;
	} finally {
		InchelDBManager.close(con, pstmt, null);
	}
		
	
	}//updateappleinfo end
	
	public void deleteAppleDB(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = InchelDBManager.connect("inchelPool");
			
			String location = request.getParameter("");
			String sql = "delete from sep14_apple where a_location=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if(pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제성공");
			} else {
				request.setAttribute("r", "삭제실패");
			}
			
		} catch(Exception e) {
			
		}
		
	}
	
}
