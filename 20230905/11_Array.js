alert("11_Array.js");

//JS에서의 배열도, 순서가 있는 데이터들의 리스트와 같다.
//배열은 한가지 타입 뿐만 아니라 문자, 숫자, 객체, 함수 데이터를 한번에 전부 포함할 수 있다.
//배열의 길이를 배열명.length로 볼 수 있다.
//배열을 사용하는 가장 큰 이유는, 반복문을 사용하기 위해서이다.

//배열에서 사용 가능한 추가/제거 관련 메소드 확인하기
//1. push() : 배열 끝에 입력한 값을 추가한다.
//2. pop() : 배열 끝의 요소를 제거한다.
//3. shift() / unshift() : 배열의 가장 앞의 요소를 제거 / 추가한다.

let students = ["곽두팔", "김춘삼", "이춘식"];

console.log(students[1]); // 여기 배열도 0번부터 시작한다.

let arr = [
	"인첼",
	3,
	false,
	{
		name : "Inchel",
		age: 7,
	},
	function(){
		console.log('test');
	}
]
//배열 전체 출력
console.log(arr);

//배열 길이 출력
console.log(arr.length);

let days = ["월", "화", "수"];
console.log(days);

//배열에 push로 요소 추가 예제
days.push("목");
console.log(days);

//배열에 pop으로 요소 제거 예제
days.pop();
console.log(days);

//배열의 맨앞의 요소를 제거하는 예제
days.shift();
console.log(days);

//배열의 맨앞에 요소를 추가하는 예제
days.unshift("목", "금", "토");
console.log(days);

console.log('---------------------------');

//배열을 사용한 반복문 예제 1 : Java에서 쓰던 방식
for(let i = 0; i < days.length; i++){
	console.log(days[i]);
}

console.log('---------------------------');

//배열을 사용한 반복문 예제 2 : 향상된 반복문(for-each)문
for(let day of days){
	console.log(day);
}

days.unshift("오늘 수업 끝");
console.log(days);