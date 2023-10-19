'''
Created on 2023. 10. 19.

@author: ckd39
'''

#강아지 클래스 => 생성자에 이름, 나이 + 그 속성을 출력하는 기능까지.

class Dog:
    name = "dog"
    age = "2"
    
    def __init__(self, name, age):
        self.name = name
        self.age = age
        
    def printInfo(self):
        print("이름 :", self.name)
        print("나이 :", self.age)

#################################################
if __name__ == "__main__":
    from animal.wild import Ant
    a = Ant("동학개미", 10000000)
    a.printInfo()
    #위 코드는, oMain1.py에서 실행할 경우 실행되지 않는다.
    
#d = Dog("나리", 8)
#d.printInfo()