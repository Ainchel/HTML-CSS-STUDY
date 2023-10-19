'''
Created on 2023. 10. 19.

@author: ckd39
'''
from datetime import datetime

# -*- coding:utf-8 -*-

#좋아하는 음료의 이름과 마시는 횟수를 입력받아서 출력하자.

input1 = input("좋아하는 음료를 입력해 주세요 : ")
input2 = input("그래서 하루에 몇 번 드세요? : ")

print("{}을(를) {}번 마셔요.".format(input1, input2))
print("---------------------------------------")

#Python 3.6.x부터, f-string이라고 불리우는, 포맷팅을 쉽게 할수 있는 방법이 추가됐다고 한다.
#f-string의 형태는, f와 {}만 기억해라. ??????????????????
#형식 : f"문자열 {변수명} 숫자... "
print(f"저는 {input1}을(를) 좋아하고, 하루 {input2}캔을 마십니다.")
print("--------------------------------------------")

# f-string을 이용해, 소수점의 반올림 표현하기.
# 기본적으로 % 포맷팅과 거의 유사하다.
# 하지만 {}를 써서 포맷팅을 할 땐, 포맷팅하는 값의 자료형에 상관없이 {}를 사용해야 한다.

#f = 1.125
f = 1.135
print(f"{f}")       # 1.125
print(f"{f:.1f}")   # 1.1
print(f"{f:.2f}")   # 1.13(1.12였음) / 1.14

# 왜 1.125를 2자리에서 반올림시킨다 했는데 1.12가 떴느냐?
# Python의 반올림은, 반올림의 대상이 되는 수(위 1.125에서의 2)가 0, 1, 2일떄에는 반올림을 안시켜준다.
# 이진 소수의 한계라고 공식 문서에도 적어놨다고 하니, 궁금하면 확인하자(근데 영어띠)
print("-----------------------------------------")

#문자 정렬
#형식 : f-string에서, 출력시킬 변수 뒤에 :붙인 후, 정렬기호(< / > / ^)를 넣고 자릿수를 적는다.
#< : 왼쪽 정렬 / > : 오른쪽 정렬 / ^ : 가운데 정렬

#왼쪽 정렬
s1 = "left"
result = f"|{s1:<10}|"
print(result)
#중앙 정렬
s2 = "mid"
result2 = f"|{s2:^10}|"
print(result2)
#오른쪽 정렬
s3 = "right"
result3 = f"|{s3:>10}|"
print(result3)

#f-string에서 중괄호(변수 입력할 때 사용한다)는 어떻게 쓸까? 아래 참조
num = 10
result4 = f"my age : {num}, {{num}}, {{{num}}}"
#출력 결과 : 10, {num}, {10}
#즉, {}를 두개로 싸면 {}를 표현하고, {}를 세개로 싸면 {변수}까지 표현할 수 있다.
print(result4)

#f-string과 dict
d = {
    "name" : "beaver",
    "age" : 100,
    "gender" : "남자"
}
#dict내의 요소 또한 f-string에서, 중괄호를 이용해 키값에 접근함으로써 가져올 수 있다.
result5 = f"name : {d['name']}, gender : {d['gender']}, age : {d['age']}"
print(result5)

#f-string과 list
n = [100, 200, 300]
#각 요소를 f-string으로 출력하려면?
print(f"list : {n[0]}, {n[1]}, {n[2]}")

#아니면 이렇게 for문으로도 가능하다.
for v in n:
    print(f"list element : {v}")
print("-----------------------")

num2 = 1234567890
print(num2)

#위 num2를, f-string을 이용해 세자리씩 끊어보기.
print(f"{num2:,}")

date1 = datetime.today()
print(date1)
#f-string을 이용해, 위 date1 연-월-일 + 요일 형식으로 바꿔 출력해보기.
print(f"{date1:%Y-%m%d} is on a {date1:%A}.")

######################################################
#f-string 정리
#1) 문자열 맨 앞에(따옴표 전에) 'f'를 붙인다.
#2) 사용하고 싶은 변수나 값을 {}(중괄호)안에 넣는다.
#3) 출력한다.