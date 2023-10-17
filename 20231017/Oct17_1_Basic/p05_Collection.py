'''
Created on 2023. 10. 17.

@author: ckd39
'''

# -*- coding:utf-8 -*-

#파이썬에서의 자료구조(Collection)

#str의 인덱싱(인덱스 찾아가기)

s = "Can't tuna kkk"
print(s)
#아래처럼, 문자열의 인덱스를 찍어서 해당 값만 떼올 수 있다.(인덱싱)
print(s[0])
#아래처럼, 문자열의 인덱스 범위를 지정해서 떼올 수도 있다. (슬라이싱)
print(s[0:6])
#아래처럼, 문자열의 인덱스 범위 내에서, 몇개씩 건너뛰어서 떼올 수도 있다.
print(s[2:10:2])
print("----------------------------------------")

#파이썬의 리스트(List) : 순서가 있으며(0번부터), 중복값을 허용한다. 요소 값을 수정/삭제할 수 있다.

a = [123, 4, 56, 789, 1011]
print(a, type(a))
print(a[0]) # 123
print(a[0:3]) # 123, 4, 56
print(a[0:5:2])#123, 56, 1011
print(a[-1]) # 음수값을 넣을 경우, 뒤에서부터 센다.(-1부터 시작)

#리스트의 요소 개수는 len()으로 확인할 수 있다.
print(len(a))
#리스트.append(값)으로 리스트 맨뒤에 요소 추가할 수 있다.
a.append(1213)
#리스트.insert(인덱스 번호, 값)으로, 원하는 요소 번호에 값을 추가할 수 있다.
a.insert(2, 1415)
print(a)
#요소 값 변경은 인덱스 번호에 값을 넣는다.
a[4] = 7788
#요소 삭제는 del 리스트명[인덱스수]로 진행한다.
del a[0]
print(a)
#정렬은 리스트명.sort()으로 진행한다. 아무것도 안쓰면 오름차순으로 간다.
a.sort()
print(a)
#리스트 정렬에 내림차순을 넣고 싶다면, ()안에 reverse = True 값을 넣는다.
a.sort(reverse = True)
print(a)
print('-------------------------------------------------')

#파이썬의 Tuple : 순서대로 들어가며, 중복값을 허용한다. 들어간 값의 수정 및 삭제가 불가능하다.
tuple1 = ('1', '2', '3') #소괄호는 생략할 수 있다.
print(tuple1)
#del tuple1[0] 삭제는 진행되지 않는다. 에러도 뜸
#TypeError: 'tuple' object doesn't support item deletion
#tuple1[0] = 'c'
#tuple 요소는 수정도 불가능하다. 에러 뜸
#TypeError: 'type' object does not support item assignment
#print(tuple1)

t = (1, 2, 3, 4, 5, 4, 4)
print(t)
#튜플의 특정 값을 가지는 인덱스를 가져오려면, 튜플명.index(찾는 값)를 사용한다.
#만약 튜플 내 인덱스 값이 여러개 있다면, 첫번째 인덱스 값을 가져온다.
print(t.index(5))
#튜플 내 지정한 값을 가진 인덱스가 몇개 있는지 확인하려면 튜플명.count()를 사용한다.
print(t.count(4))
#튜플의 좋은 기능 중 하나로, 변수 여러개를 한번에 선언할 수 있다. 아래 참조
(a1, b1) = (10, 20)
print("교환전 : ", a1, b1)
#더 좋은 기능 중 하나로, 튜플의 형태로 빈 변수를 만들지 않고도 값 교환을 할 수 있다.
(a1, b1) = (b1, a1)
print("교환후 : ", a1, b1)

#아래도 튜플을 이용한 선언 방식이다.
x, y, z = 10, 20, 30
x, y, z = z, x, y
print(x, y, z)
print("---------------------------------------")

#파이썬의 "Set(집합)" : 중복값을 제거하며, 순서 개념이 없다. 뽑을 때에는 랜덤으로 뽑는다.
#형식 지정은 {}로 한다.
s = {"ㅋ", "ㅋ", "ㄹ", "ㅃ", "ㅃ"}
print(len(s)) # 중복값을 허용하지 않아 3개라고 나온다.
#Set을 출력하려면, 아래처럼 리스트화도 한번 해야 한다.
s = list(s)
print(s)
print("-----------------------------------------")

#파이썬에서의 Dict : 자바에서의 map과 비슷하며, 네임과 밸류로 연결된다.
#활용도가 높으며, 미들웨어와 연결하여 사용하는 경우 자주 사용한다.(DB나 몽고메리? 등)
d = {"name" : "킹두괄", "age" : 12}
print(type(d))
print(d["name"])
print(d["age"])
print("-----------------------------------------")

#파이썬에서의 범위를 지정하는 Range
r = range(10) # 0~ (10-1)까지의 범위를 저장한다.
#0이 아닌 값의 범위를 지정하려면 패러미터를 2개 넣는다.
r = range(2, 10)
#0이 아닌 값 + 범위 내 특정 패턴의 수를 만들려면, 패러미터를 3개 넣는다.
r = range(2, 10, 3) # 2~10까지, 값을 3개씩 건너뛰면서 생성
r = list(r)
print(r, type(r))

#0 ~ 9까지 있는 list와, 1 ~ 20까지의 홀수만 있는 list를 출력하기.
r1 = range(10)
r1 = list(r1)
r2 = range(1, 20, 2)
r2 = list(r2)
print(r1)
print(r2)