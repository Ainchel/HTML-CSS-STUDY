package com.inchel.oct053.convertunit;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class ConvertDAO {

	HashMap<String, String> unit;

	// 이 setter를 통해서 xml의 값이 위의 unit으로 들어가게 됩니다
	//아 name같은건 상관없고 아래 Setter통해서 들어간건가요..?
	//그럼 beans를 처음에 선언할 때 class= 속성으로 클래스를 지정하고,
	//그 안에서 다시 name으로 값을 대입할 객체 이름까지 지정해준 다음에,
	//setter함수를 만들어두어야지 xml -> 객체?빈즈? 요렇게 연결이 된다는 말씀으로
	//이해하면 맞을까요??
	// 1. 이 DAO에 대한 class를 지정해줬고
	// 2. DAO의 멤버변수인 unit에 대한 값을 xml에서 지정해 줬는데
	// 3. 그 값을 가져오기 위해서는 setter 메소드를 사용!
	
	public void setUnit(HashMap<String, String> unit) {
		this.unit = unit;
	}
	
	//그렇네요 name까지 지정을 다 해줘야 애가 찾아가는 거...로 에러메세지 읽고 이해했습니다
	// 고민 해결인가요 ~?! 잠시만요... 제가
	//어제 DI쪽 코드를 읽고 이 부분을 캐치를 못했었는데
	//같은 형식으로 작성되었는지까지만 확인 얼른 해봐도 될까요?
	//확인했습니다 감사합니다.. 복습 마저 해보겠습니다
	//그 마지막으로 선생님 코드에서 지금 보여주시는 부분에
	//what이라고 되어있는 값이 select에서 고른 값 저장한
	//String데이터 맞을까요??
	// 지금 화면에서 option에 value심어둔거에요
	//아 네넵 그럼 선생님 코드는 전부 이해했습니다 감사합니다.
	//화이팅!
	public void convert(ConvertResult cr, HttpServletRequest req) {

		String convert = cr.getConvertUnit();
		String result = "";
		
		if(convert.equals("lengthconvert")) {
		result = String.format("%.2f", cr.getInputValue() / 2.54);
		} else if(convert.equals("widthconvert")) {
		result = String.format("%.2f", cr.getInputValue() / 3.306);
		} else if(convert.equals("temperatureconvert")) {
		result = String.format("%.2f", (cr.getInputValue() * 9/5 ) + 32);
		} else if(convert.equals("speedconvert")) {
		result = String.format("%.2f", (cr.getInputValue() * 9/5 ) + 32);
		}
		
		System.out.println("변환함수 통과");
		
		req.setAttribute("c", convert);
		req.setAttribute("r", result);
		
	}
	
}
