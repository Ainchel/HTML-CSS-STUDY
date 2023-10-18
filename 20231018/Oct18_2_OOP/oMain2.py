'''
Created on 2023. 10. 18.

@author: ckd39
'''

# -*- coding:utf-8 -*-

class Book:
    #클래스 생성자 만들어보기. 아래와 같이 만든다.
    #def __init__(self):
    #    print("기본생성자 - 책 생성")
    
    #생성자란, 객체를 만들 때 객체가 메모리상에 뜨면 실행되는 메소드이다.
    #파이썬에선 기본적으로 오버로딩이 불가능하니, 생성자를 하나만 사용할 수밖에 없다.
    #그래서, 오버로딩된 형태의(패러미터가 존재하는) 생성자를 그냥 만들어서 써본다.
    def __init__(self, title, price):
        print("그렇다고 이게 오버로딩된 생성자일까? 아니다. 그냥 생성자인 것이다.")
        self.title = title # 이렇게, 생성자에서 변수를 만들어 이 객체의 필드값을 설정한다.
        self.price = price
    
    def print(self):
        print(self.title, self.price)
        
    #파이썬에는 소멸자 함수도 존재한다. 이 객체가 메모리에서 사라질 때 호출되는 메소드이다.
    def __del__(self):
        print(self.title, "책을 삭제합니다.")
    
    
#사람 클래스 만들기 : 이름, 나이 / 각 속성을 출력하는 메소드 / 생성자, 소멸자 만들기.

class Human:
    
    name = "홍길동"
    age = 19
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
    
    def printInfo(self):
        print("이름 :", self.name, "나이 :", self.age)
    
    def __del__(self):
        print(self.name, "객체가 삭제됩니다.")
    
#b1 = Book()
##########################################################
b2 = Book("원피스", 8000)
b2.print()
print("----------")
#이후 코드가 없어서 프로그램이 종료되므로, 이 시점에서 소멸자 함수가 실행된다.
##########################################################
h1 = Human("김휴먼", 20)
h1.printInfo()
h2 = Human("박휴먼", 30)
h2.printInfo()

h3 = h1 #참조값 대입
h3.printInfo()
print(id(h3))
print(id(h1))

h1 = None # 이 시점에서 소멸자가 호출된다. 기존의 메모리 주소값을 잃었기 떄문
h3 = None # 이 시점에서 소멸자가 호출된다. 기존의 메모리 주소값을 잃었기 떄문
print("!#!#!@%!@#^#^#%&$%&!@$!%@#%@")

#h2의 소멸자는 여기서 호출된다. 프로그램의 끝에서
