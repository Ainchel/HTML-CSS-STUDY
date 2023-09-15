package com.inchel.db.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 기존의 JDBC 프로그램을 구현하려면? DBMS와 연동하는 작업을 거쳐야만 했다.
// 클라이언트로부터 요청이 있을 때마다, DB 서버와 연결을 하는 Connection 객체를 얻어내야 했다.

// 이 방식의 단점? 1) Connection을 통해 연결할 때 정해진 시간이 필요하다.
//			    2) 불필요한 연결 반복으로 인해, 서버 자원을 낭비한다.

// 위 단점을 보완하기 위한 것이 DBCP(DataBase Connection Pool).
// 여러개의 DB Connection들을 하나의 Pool에 모아놓고 관리해준다.
// 필요할 때마다 Pool에서 불러다가 사용한다.
// 우리가 미리 받은 Context.xml이 Pool을 만들어주는 코드이다.
// 현재 Pool 내에서 빌려올 수 있는 Connection(객체)가 없다면, 생겨서 돌려받을 때까지 대기상태로 전환된다.

// 아래는 비유.
// 우리가 튜브를 달라고 할 때마다, 튜브에 바람을 넣어 채워서 하나하나 주는 것이 JDBC.
// 우리가 튜브를 달라고 안해도, 미리 튜브를 채워놔서 달라고 하면 바로 주는 것이 DBCP.

public class InchelDBManager {
	
	//JNDI (Java Naming and Directory Interface) 생성
	//Java에서 지정한 API로, 어떤 파일/프로그램에 이름 및 디렉토리 지정이 가능하다.
	//DataSource : 커넥션 풀의 Connection을 관리하기 위한 객체이다.
	//lookup 메소드를 통해서, Connection 객체를 가져옴으로써 관리한다.
	
	public static Connection connect(String poolName) throws Exception{
		Context ctx = new InitialContext();
		DataSource ds = (DataSource)ctx.lookup("java:comp/env/" + poolName);
		return ds.getConnection();
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			rs.close();
		} catch (Exception e) {
			
		} try {
			pstmt.close();
		} catch (Exception e) {
			
		} try {
			con.close();
		} catch (Exception e) {
			
		}
		
	}
	
}
