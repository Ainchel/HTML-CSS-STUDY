'''
Created on 2023. 10. 17.

@author: ckd39
'''

#-*- coding:utf-8 -*-

#파이썬에서의 변수(Variable)에 대하여.
#Java에서는, 개발자가 변수의 데이터형을 명시함으로써 메모리 사용량을 최적화할 수 있다.
#Java예시 : 자료형 변수명 = 값; => int a = 10;

#Python에서는, Python이 알아서 자료형을 선정해준다.
#그래서, 파이썬 공부하는 사람은 자료형에 대해 공부할 일이 없다. => 개발자가 편하다.
#하지만, 자동으로 자료형을 선정하는 과정에서 시간도 걸리고, 메모리 사용량을 제어할 수가 없다.
#파이썬에서의 변수는 기본형이 없으며, 전부 참조형이다. => 메모리 사용량이 많아진다.
#결국 형식 : 변수명 = 값. 자료형 지정하지 않으며 세미콜론을 사용하지 않는다.

a = 10
print(a)
print(type(a)) # type(변수명)을 이용해 자료형을 알 수 있다.
print(id(a)) # id(변수명)을 이용해 해당 변수의 주소값을 알 수 있다.

#Java에서 값을 바꾸려면? 아래처럼.
#int b = 10;
#b = 20;

print('##############')
#파이썬에서도 비슷하다. 대신 참조형이므로, 값을 바꾸면 주소값도 따라서 바뀐다.
#그것이 의미하는 것은, Java에서의 문자열처럼, 새로운 객체를 만든 후 참조를 바꿨다는 것이다.
#이전 값은 더이상 참조되지 않으므로 가비지컬렉션당해서 없어질 것이다.
a = 20
print(a)
print(type(a))
print(id(a))
print('##############')

a = 'ㅎ'
print(a)
print(type(a))
print(id(a))
print('##############')

#python에서의 data type(자료형)
p_str = 'Inchel' #str : 문자열
print(p_str, type(p_str))
p_int = 10 #int : 정수
print(p_int, type(p_int))
p_float = 1.234 #float : 실수. Java와 다르게(Java가 독특한거지만) float을 사용.
print(p_float, type(p_float))
p_bool = True #boolean : 논리(True, False). 앞첫글자는 대문자로
print(p_bool, type(p_bool))

#python에서의 자료구조(Collection).
p_list = [3,7,5] #list: 리스트
print(p_list, type(p_list))

p_dict = { # dict : 사전(Dictionary). 네임과 밸류로 이루어진 리스트 느낌.
    'name': 'Inchel',
    'age' : 100
}
print(p_dict, type(p_dict))

p_set = {3,6,7} # set : 집합.
print(p_set, type(p_set))

p_tuple = (5,7,6) # tuple : 튜플
print(p_tuple, type(p_tuple))
################################################
#python에서의 형변환(Type Casting)
print('###############################')
d = 1
print(type(d), id(d))
#형변환을 하려면, 위 데이터타입명을 붙인 후 ()에 변수명을 넣어준다.
d = str(d)
print(type(d), id(d))
e = False
e = int(e)
print(e) # False = 0, True = 1 이렇게 형변환된다.
################################################
#콘솔에 키보드 입력받기(Java에서의 Scanner 기능)

ki = input("키 : ")
print(ki, type(ki)) #input으로 가져오면, 자료형은 기본적으로 str이다.
                    #그래서, 입력받은 숫자들을 수로 사용하려면 형변환을 해야한다.

ki = float(ki)
print(ki, type(ki))

#아래처럼, 매개인자로 받아오는 것도 가능하다.
ki2 = float(input("몸무게 : "))
print(ki2, type(ki2))

