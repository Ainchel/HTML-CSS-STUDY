'''
Created on 2023. 10. 17.

@author: ckd39
'''

# -*- coding:utf-8 -*-

#이번에는 연산자(Operator) 보기.
#정수 2개를 입력받아서, 사칙연산한 결과와 나머지를 출력해보기.
#우리가 알던 거랑 똑같으니 어려울 것 없음.

input1 = float(input("첫번째 수 : "))
input2 = float(input("두번째 수 : "))

print("input1 + input2 : {0:.2f}".format(input1 + input2))
print("input1 - input2 : {0:.2f}".format(input1 - input2))
print("input1 * input2 : {0:.2f}".format(input1 * input2))
print("input1 / input2 : {0:.2f}".format(input1 / input2))
print("input1 % input2 : {0:.2f}".format(input1 % input2))

#추가로, 나누기기호 2개(//)를 써서 몫을 구할 수도 있다.
f = int(input1 // input2)
print("f : ", f)

#그리고 곱하기기호 2개(**)를 사용하여 거듭제곱을 시킬 수 있다.
g = int(input1**input2)
print(g)

z = 'ㅋㅋㅋ '
#h = input1 + z # 현재 숫자 + 문자열을 더하고 있음.
#결과 : 출력안됨. 숫자와 문자는 서로 산술할 수 없다는 에러가 출력되므로 조심.
h = str(input1) + z 
print(h) 

i = int(input1) * z # 숫자(정수) * 문자열 상황.
print(i) # 문자열을 정수횟수만큼 반복해서 출력시켜준다.
##########################################

#x = x + 3처럼 하고 싶다면?
#Java처럼 붙여서 x += 3 이렇게 가능하다.
input1 += 3
print(input1)
#대신, ++랑 --는 없으므로 주의
##########################################

#조건식 출력. 조건식이 맞으면 True를, 아니면 False를 출력시킨다.
j = input1 > 10
print(j)

#자바에서 사용하던 && 연산자, || 연산자는 파이썬에서는 각각 다른 용어로 쓴다.
#&& : and, || : or

k = (input1 > 10) and (input2 < 3)
print("k : ", k)

#! 또한, 영어 그대로 not으로 사용한다.
l = not k
print("l : ", l)

#변수 m : x가 5이상 10 이하일 경우 True/ 아니면 False를 출력
#m = (5 <= input1) and (input1 <= 10)
#그리고 아래처럼도 가능.
m = (5 <= input1 <= 10)
print("m : ", m)

# 파이썬에서의 3항연산자.
# 파이썬에서 3항연산자가 있다고 하는 사람도, 없다고 하는 사람도 있다. ????
# 형식 : [참일 때의 값] if [조건식] else [거짓일 때의 값] 이렇게 한다.
# 정수를 새로 하나 입력받아, 짝수면 '짝수', 홀수면 '홀수' 라고 출력해보자.

# input으로 입력받은 값은 String으로 저장된다. 기억기억기억기억해두기. 형변환해야됨
input3 = int(input("홀짝 체크 : "))
r = '짝수' if (input3 % 2 == 0) else '홀수'
print('input3은', r, '입니다.')

# 파이썬 3.8 이상에서는, 다른 삼항연산자 문법을 사용할 수 있다.
# [조건식] and [참일 때의 값] or [거짓일 때의 값] 형식도 사용할 수 있다고 한다.
r = (input3 % 2 == 0) and '짝수' or '홀수'
print('input3은', r, '입니다.')