alert("09_ArrowFunction.js");

//08_Function.js에서 다뤘던 함수는 '함수 선언문' 이라고 한다.
//아래에 다시한번 정리.

//함수 선언문 말고, '함수 표현식' 이라는 물건도 있다.
//무슨 변수 선언과 함수 선언을 동시에 하는 느낌?
//형식 : let sayHello = function(){
//	console.log("Hello");
//}

//함수 선언문과 함수 표현식의 문법적 차이에 대하여.
//둘은 함수를 호출하는 타이밍에 있어 차이가 생긴다.
//함수 선언문은, 프로그램 실행 전에 함수를 전부 읽어둔다(호이스팅-Hoisting). 아래 sayHello 함수선언 참조
//함수 표현식은, 실제로 해당 코드에 도달해야 함수를 선언하게 된다.
//그래서 뭘 쓰면 되나요?? 편해보이는거 쓰세요. 크게 다를거 없음.

//다시, 화살표 함수에 대하여.
//여지껏 봤던 함수(함수 선언문)보다 더 간결하게 작성하는 함수.
//예시는 sayHello보다 아래의 함수들 주석 참조.

//Function vs Method에 대하여.
// 1)Method : 어떤 객체의 속성(프로퍼티)으로 할당된 함수를 메소드라고 한다.
// 1-1) Java에서는 클래스 단위로 코드를 작성하므로, 클래스 내의 함수들이 모두 메소드였던 것.
// 2)Function : 클래스 내에 존재하지 않는 함수면 Function이라고 하자.

sayHello(); // 선언하기 전에 호출시켜도 작동한다. 왜?
			// 이는 함수 선언문과 관련이 있다.
			// 함수 선언문으로 함수를 짜면, 선언 위치와 관계 없이 호출이 가능하다.
			// 이거 꽤 중요하다고 한다.
			// JS는 프로그램을 실행하기 전에, 함수 선언문으로 작성된 함수를 모두 모아서 읽어둔다.
			// 이렇게 모아둔 함수는 호출 위치와 관계 없이, 읽어둔 것을 가져와서 사용한다.
			// 하지만 실제로 메모리를 먹거나, 코드를 끌어올리네 어쩌네 하는건 아님.
			// 이런 작동 방식을 "호이스팅(Hoisting)" 이라고 한다.
function sayHello(){
	console.log('Hello');
}

//함수 표현식 예를 하나 들어보자.
/*let add = function(num1, num2){
	return num1 + num2;
}*/

//위 함수를 화살표 함수로 표현하면?
/*let add = (num1, num2) =>{
	return num1 + num2;
}*/

//더욱 더 간결하게 하면, return 키워드까지 빼버릴 수 있다.
/*let add = (num1, num2) =>{
	num1 + num2;
}*/

//더더욱 더 간결하게 하면??? 중괄호 블록까지 제거해버리기.
//다만, 이 방법은 반환할 코드가 한줄이어야만 가능하다.
let add = (num1, num2) => num1 + num2;

//파라미터가 하나라면?? 파라미터 입력하는 부분의 소괄호 생략 가능.
let sayHello2 = name => `Hello, ${name}`;

//파라미터가 없는 경우라면?? 괄호도 생략해도될 것 같지만, 괄호는 내비둬야 한다.
let asdf = () => console.log("asdf");

let human = { // JS로 사람 객체를 하나 만듦.
			  // 필드와 메소드가 하나씩 있음.
	name: "김비버",
	walk: function(){
		console.log("걷는 중");	
		} 
}
