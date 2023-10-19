'''
Created on 2023. 10. 19.

@author: ckd39
'''

# -*- coding:utf-8 -*-

class Avengers:
    def __init__(self, realName):
        self.realName = realName
    def attack(self):
        print("므찐 공격 !")
    def printInfo(self):
        print(self.realName)
###############################################
class Human:
    def __init__(self, age):
        self.age = age
    def eat(self):
        print("쩝쩝박사")
    def attack(self):
        print("햄주먹")
    def printInfo(self):
        print(self.age)
###############################################
# Java에서는 다중 상속을 지원하지 않는다. 대신 인터페이스를 다중 구현시켜서 사용했다.
# 파이썬에서는 다시 다중 상속을 지원한다.
# 상속 받는 여러 클래스에서, 중복되는 메소드가 있을 경우...?(예시 : attack) 먼저 상속받은 것을 불러온다.
# 아래 코드에서는 Avengers 것을 가져오는데, Human의 attack을 가져오고 싶다면...?
# 직접 입력해주는 수밖에 없다. 대신, 자동으로 가져와진 메소드 코드를 건드릴 수는 없다.

class Ironman(Avengers, Human): # 다중상속은 이렇게. 어벤저스이기도 하고 사람이기도 한 아이언맨
    def __init__(self, realName, age): # 이름의 경우 어벤저스에 들어있음. 나이는 휴먼에.
        Avengers.__init__(self, realName)
        Human.__init__(self, age)
    def attack(self): # 공격의 경우, 어벤저스와 휴먼 모두에 있다...? 설명 주석 참조.
        Avengers.attack(self)
        Human.attack(self) # 이렇게밖에 안된다고 한다... 흠
    def printInfo(self):
        Avengers.printInfo(self)
        Human.printInfo(self)
##############################################################
if __name__ == ("__main__"):
    i = Ironman("토니 스타크", 40)
    i.attack()
    i.eat()
    i.printInfo()