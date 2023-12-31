'''
Created on 2023. 10. 18.

@author: ckd39
'''

# -*- coding:utf-8 -*-



#파이썬에서의 함수(function).
#형식 : def 함수명(패러미터명):
#    (들여쓰기 후) 실행 코드

def test():
    print("수마가쏟아지는수요일")
    
def test2(): # 파이썬 어느 문법에서든 :를 썼다면, 그 다음 코드는 반드시 들여쓰기를 해주어야 한다.
    pass #위 룰을 지키면서도, 코드를 정하지 못한 상태라면 이렇게 pass를 써서 넘긴다.
    
#정수 2개를 집어넣으면, 그 합을 출력해주는 함수를 만들어서 호출까지.

def printsum(a=1, b=2): # 호출할 때 값을 넣지 않아도 기본적으로 작동하게, 패러미터에 기본값을 정해준다.
    print("a + b :", a+b)
    
#정수 3개를 넣으면 그 합을 출력해주는 함수 만들기.
#참고로, 자바에서는 함수명이 같고 패러미터가 다르면 오버로딩이 됐었지만, 파이썬에서는 되지 않는다.
#따라서, 비슷한 기능을 가진 함수라도 이름을 전부 다르게 해야 한다.
def printsum2(a=1, b=2, c=3):
    print("a + b + c :", a+b+c)

#정수 2개를 넣으면 그 합을 구하기만 하는 함수를 만들기.
def getsum(a, b):
    return a+b

def getsachik(a, b):
    #자바에서는 리턴이 하나만 가능했지만, 파이썬에서는 튜플 형태로 아래처럼 리턴도 가능하다.
    '''
    이렇게, 함수 선언 부분에 함수를 설명하는, 특별한 설명서 주석을 사용할 수 있다.
    함수마다 이렇게 적어둔 설명서는, help(함수명)함수를 호출하여 특별하게 따로 불러올 수 있다.
    '''
    return a+b, a-b, a*b, a/b

#정수 2개를 넣으면 그 사칙연산 결과를 구하는 함수를 만들기.
    
##########################

#함수의 호출 : 함수명(패러미터)
help(getsachik)
test()
printsum(5,10)
printsum() # 함수 호출할때 패러미터를 안넣으면 에러가 발생한다. 이를 위해서 기본값을 지정할 수 있다.
printsum2(10,20,30)
printsum2()
c = getsum(10,20)
print("c :", c)
d = getsachik(10, 20)
print(d, type(d))
#u,i,o,p = getsachik(10, 20) # 튜플을 만든 후 이렇게 넣을 수도 있다.
u,i,_,p = getsachik(10, 20) # _를 이용해, 사용하지 않을 빈값을 넣을 수도 있다.
print(u,i,p)
