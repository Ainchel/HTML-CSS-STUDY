alert("08_Function.js");

//8. 자스에서의 함수에 대하여.

//서비스를 구현하다 보면 같거나 비슷한 기능들이 생기기 마련이다.
//팝업창, 결제, ... 등등 만들때, 매번 새로 만들지 말고 두고두고 쓰자는 취지.
//아래의 showError() 함수를 만들어뒀으니, 각종 에러에서 코드 쓰지말고 저것만 호출해주면 되겠다.

//파라미터가 있는 함수도 만들어보자.

//형식 : function 함수명 (파라미터) {실행할 코드 ....}
//호출 : 함수명(파라미터); 로 호출하면 된다.
//파라미터가 있는 함수에 파라미터를 넣지 않으면 undefined 값이 노출된다.


//함수를 다루는 데에 있어, 전역변수와 지역변수에 대해.
//함수 밖에 있어, 어디서나 접근 가능한 변수를 전역변수(Global Variable)라고 한다.
//함수 내에 있어, 함수 내부에서만 접근 가능하고 함수가 끝나면 증발하는 변수를 지역변수(
//지역변수는 함수 내에서 전역변수와 같은 이름으로 지을 수 있다.
//이럴 경우, 같은 이름의 전역변수와 지역변수는 서로 간섭을 받지 않는다.
//전역변수가 너무 많다면 전부 관리를 해야하므로, 특별한 관리가 필요한게 아니라면 지역변수를 쓰자.

//변수 지나서, 다시 함수로.
//함수의 패러미터에 기본값 넣어보기.
//1) OR 연산자(||)를 활용해서 함수 내 지역변수에 기본값 넣기(아래 sayHello2 함수 참조)
//2) 함수 패러미터에 기본값(default value)을 아예 설정해보기(아래 sayHello3 함수 참조)

//함수에서 return으로 값 반환도 할 수 있다.(아래 sayHello4 함수 참조). return은 값 반환 + 함수 종료를 동시에 수행함.

//정리
//1) 함수는 한 번에 한 작업만 해두는게 좋다.
//2) 여러 기능이 필요하다면, 그냥 여러 함수로 쪼개는게 좋다.
//3) 함수명은 이름을 읽기 쉽고, 기능을 알기 쉽게 짓는게 좋다.

let msg = "HI"; // 전역변수
console.log("함수 호출 전");
console.log(msg);

function showError(){
	alert("에러 발생!!!");
}

function sayHello(name){
	let msg = "BYE";
	if(name == undefined){
	let msg = `Hello`;
	alert(msg);
	} else{
		let msg = `Hello, ${name}`;
		alert(msg);
	}
	console.log("여기는 함수 내부입니다.")
	console.log(msg);
}

sayHello("Ainchel");

console.log("함수 호출 후");
console.log(msg);

showError();

/*function sayHello(name){
	
	if(name == undefined){
	let msg = `Hello`;
	alert(msg);
	} else{
		let msg = `Hello, ${name}`;
		alert(msg);
	}
}

sayHello("Ainchel");
sayHello();*/

function sayHello2(name){
	let newName = name || "Friend";
	let msg = `Hello, ${newName}`;
	console.log(msg);
}

sayHello2("Ainchel"); // 'Hello, Ainchel' 출력
sayHello2(); // 'Hello, Friend' 출력

function sayHello3(name = "Friend"){ // 매개변수 선언 단계에서 값을 초기화
	let msg = `Hello, ${name}`;
	console.log(msg);
}

sayHello3('Ainchel'); // 'Hello, Ainchel' 출력
sayHello3(); // 'Hello, Friend' 출력

function add(num1, num2){
	return num1 + num2;
}

let result = add(2,3);
console.log(result);