package com.inchel.oct131.error;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ErrorDAO {

	@Autowired
	private SqlSession ss;
	
	public void getAllError(HttpServletRequest req) {
		
		try {
			//getAllError()쿼리문 (DB 조회) 돌려서 바로 어트리뷰트에 꽂아주기.
			req.setAttribute("errors", ss.getMapper(ErrorMapper.class).getAllError());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//오늘은 어제 XML로 데이터 빼주듯이 JSON으로 데이터 빼보기.
	
	public Errors getJSON(HttpServletRequest req) {
		//우선 myBatis로 데이터 받아오기. List형식일 것.
		return new Errors(ss.getMapper(ErrorMapper.class).getAllError());
	}
	
	public Errors searchJSON(Error e, HttpServletRequest req) {
		return new Errors(ss.getMapper(ErrorMapper.class).searchError(e));
	}
	
}
