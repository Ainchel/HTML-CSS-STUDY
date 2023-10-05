package com.inchel.oct052.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

//클래스에 필드가 없다면? static method 기반으로 만들면 된다.
//아래 같은 경우나 MVC에 사용되는 DAO같은 경우라면, 전역으로 관리하기 위한 필드가 생기기 마련이다.
//그러기 위해, static 기반의 메소드는 포기해야 할 것이다...
//그러자니 객체를 new로 써서 만들자니, 해당 페이지로 연결될 떄마다 객체를 계~~~속 생성해버릴 것이다.
//그럼 메모리를 계속해서 잡아먹을 것이고, 아래 변수 카운트도 올바르게(정확한 타이밍에 의도한만큼) 계산되지 않을 것이다.

//그래서, 이에 대한 해결 방안으로 DAO를 싱글톤 객체로 처리해버리는 것을 여태 해왔다.
//결국 돌아와서, Spring에서의 singleton으로 처리하는 방법에 대해서.
//방법 : @Service 어노테이션을 사용해서, servlet-context.xml에 객체를 하나 등록시키는 것과 같은 작동을 시킨다.

@Service
public class calcDAO {

	//계산 횟수를 세둘 필드 하나 만들어두기.
	private int allCalcCount; // 몇번 계산했는지 기록
	
	//CalcResult(DTO)를 매개변수로 하여,
	public void calculate(CalcResult cr, HttpServletRequest req) {
		allCalcCount++;
		System.out.println(allCalcCount);
		//해당 클래스의 객체 값을 넣지 않았으나, xml에서 
		int add = cr.getX() + cr.getY();
		req.setAttribute("r", add);
		
	}
	
}
