'''
Created on 2023. 10. 19.

@author: ckd39
'''

# -*- coding:utf-8 -*-

# 파이썬에서의 상속에 관련하여.
# 일단, 파이썬에서 abstract 키워드는 없다. (추상메소드 없음)
# Java에서는 생성자 메소드는 상속이 불가능했다.
# 하지만, 파이썬에서는 생성자도 상속이 가능하다. ?????
# 멤버변수를 생성자에서 결정할 경우, 생성자를 상속시키지 않으면 해당 변수를 상속시킬 수 없다!!!
# 위는 예문을 좀 잘 보기.

class Avengers:
    def __init__(self, name, age):
        print("Avengers ~~~~~~~~~ Assemble.")
        self.name = name
        self.age = age
        
    def attack(self):
        print("공------격")
        
    def printInfo(self):
        print(self.name)
        print(self.age)
#############################################################

class Ironman(Avengers): #상속은 이렇게 진행. 클래스명 선언 시()안에 상속받을 클래스명 적기.
    #상속받은 메소드의 기능을 바꾸는 것이므로, 오버라이딩에 해당될 것이다.
    #비슷한 대상인 오버로딩 : 함수명이 같되 패러미터가 다른 경우. 파이썬에서는 이거 지원 안한다.
    def __init__(self, name, age, suitType):
        Avengers.__init__(self, name, age) # 생성자에, 상속받은 클래스의 생성자를  집어넣음.
        self.suitType = suitType
        
    def attack(self): # 상속받은 클래스에도 해당 메소드가 있으므로, 자동완성시 오버라이딩된다.
        #Avengers.attack(self)
        super().attack() # 위 코드와 같은 뜻. super가 상속받은 클래스를 가리킨다.
        print("탈모------빔") # 이렇게 되면 내용이 추가되었으므로 오버라이딩시킨 게 맞다.
        
    def printInfo(self): # 얘도 오버라이딩됨
        Avengers.printInfo(self)
        print(self.suitType)
        
###################################################################
#헐크 상속시키기(어벤져스 소속) / 이름, 나이, 바지사이즈 / 공격 있고 정보 출력
class Hulk(Avengers):
    
    def __init__(self, name, age, pantsSize):
        Avengers.__init__(self, name, age)
        self.pantsSize = pantsSize
    
    def attack(self):
        Avengers.attack(self)
        print("헐크 짱쎄다 펀치")
        
    def printInfo(self):
        Avengers.printInfo(self)
        print(self.pantsSize)

###################################################################

if __name__ == "__main__":
    i = Ironman("토니 스타크", 1, "mk-50") # 오버라이딩된 생성자로 잘 작동한다.
    i.attack() # 상속받은 애에 탈모빔까지 같이 뜬다.
    i.printInfo() # 상속받은 내용에 슈트타입까지 같이 뜬다.
    print("----------------------------------------------")
    
    h = Hulk("브루스 배너", 2, 999)
    h.attack()
    h.printInfo()
    print("-----------------------------------------------")