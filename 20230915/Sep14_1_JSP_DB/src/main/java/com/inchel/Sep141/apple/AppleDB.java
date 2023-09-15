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

	public void getPageCount(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int pageCount = 1;
		
		try {
			con = InchelDBManager.connect("inchelPool");
			String sql = "SELECT * FROM sep14_apple ORDER BY a_price";
			int datas = 0;
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				datas++;
			}
			
			pageCount = datas % 5 == 0 ? datas / 5 : (datas / 5) + 1;
			request.setAttribute("pagecount", pageCount);
			
		} catch(Exception e) {
			
		}
		
	}
	
	public void getAppleDB(HttpServletRequest request) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			if(request.getParameter("pagenumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pagenumber"));
			}
			
			System.out.println("pageNumber : " + pageNumber);
			
			con = InchelDBManager.connect("inchelPool");
			
//			String sql = "SELECT ROWNUM, a_location, a_color, a_taste, a_price, a_introduce "
//					+ "FROM(SELECT a_location, a_color, a_taste, a_price, a_introduce, ROWNUM AS rn " 
//					 	+  "FROM(SELECT * FROM sep14_apple ORDER BY a_price)) "
//					 	 +  "WHERE rn BETWEEN " + ((pageNumber-1)*5 + 1) + " AND " + pageNumber*5;
			
			String sql = "SELECT a_location, a_color, a_taste, a_price, a_introduce, \"A_PAGENUM\" "
					   + "FROM(SELECT a_location, a_color, a_taste, a_price, a_introduce, "
					   + "dense_rank() over(order by a_price) \"A_PAGENUM\" FROM sep14_apple) "
					   + "WHERE \"A_PAGENUM\" BETWEEN " + ((pageNumber-1)*5 + 1) + " AND " + pageNumber*5;
			
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			ArrayList<AppleDTO> aList = new ArrayList<AppleDTO>();
			AppleDTO a = null;
			
			while(rs.next()) {
				System.out.println("쿼리 진입");
				a = new AppleDTO();
				a.setLocation(rs.getString("a_location"));
				a.setColor(rs.getString("a_color"));
				a.setTaste(rs.getString("a_taste"));
				a.setPrice(rs.getInt("a_price"));
				a.setIntroduce(rs.getString("a_introduce"));
				aList.add(a);
				System.out.println(a.getLocation());
			}
			
			System.out.println("aList's size : " + aList.size());
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
		//request.setCharacterEncoding("UTF-8"); // POST방식이라면 이거 써야됨. 넘어온 데이터 UTF-8로 변환
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
	
}
