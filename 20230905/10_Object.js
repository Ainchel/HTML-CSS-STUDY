alert("10_Object.js");

//내가 쓰는 마우스의 제조사는 로지텍, 가격은 32000원이다.
//요걸 객체로 만들어보자.

//객체는 중괄호 안에서 구성되며, 키(key) - 밸류(value) 형태의 프로퍼티(속성)로 묶인다.
//각각 쉼표로 구분하며, 마지막 속성을 선언한 이후에는 쉼표가 있어도 없어도 무방하다.

//해당 객체 멤버로의 접근은 .을 찍거나, 키값을 통해 접근할 수 있다.
//키값 접근은 인덱스 접근하듯이 []를 붙인 후, 키값을 ''에 싸서 적는다.

//멤버를 추가하려면, 추가할 멤버값을 위의 접근 방식으로 접근해서 초기화하듯이 넣어준다. 아래 참조

//멤버를 삭제하려면, 멤버명 앞에 delete 키워드를 붙여준다. 아래 참조

//객체를 단축시켜 만들어보기(단축 프로퍼티). 아래 예제 참조

//존재하지 않는 속성에 접근하려할 경우, 에러가 아닌 undefined 값을 출력시킨다.
//이럴 때를 위해, in 연산자를 사용하면 in 뒤에 적은 속성이 있는지 아닌지 확인할 수 있다. (true/false 반환)
//for문을 통해, 어떤 객체의 키와 밸류를 전부 확인하는 방법. 아래 for문 예시 참조

//함수를 통해서도 객체를 만들 수 있다. 아래 makeObject 함수 참조

//console 등 출력할 때, 멤버 없이 객체 이름을 적으면 객체 멤버를 모두 출력해준다.
let mouse = {
	mamufacture: "로지텍",
	price: 32000, // 쉼표 붙여놔도 에러 안남. 와우
}

//멤버 접근 예시
console.log(mouse.mamufacture);
console.log(mouse['price']);

//멤버 추가 예시
mouse.size = 15;
mouse['color'] = "gray";

//멤버 삭제 예시
delete mouse['color'];
console.log(mouse);

//일반적인 객체 선언 예시.
//아래 선언을 좀더 줄여보자.
let name = "Ainchel";
let age = 5;
/*let person = {
	name: name,
	age: age,
	getnder: "Male",
}*/

let person = {
	name,
	age,
	gender: "Male",
} //이런 형식으로 표현 가능(단, key와 value로 받아올 변수가 반드시 밖에 있어야 한다.)

console.log('birthday' in person);
console.log('age' in person);

for(let key in person){
	console.log(key);
	console.log(person[key]);
}

function makeObject(name, age){
	return{
		name,
		age,
		hobby: "Game",
	}
}

let inchel = makeObject("inchel", 5);

let inchel2 = makeObject("BBBA", 15);
console.log(inchel);
console.log(inchel2);