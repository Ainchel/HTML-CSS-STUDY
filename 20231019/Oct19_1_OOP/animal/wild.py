'''
Created on 2023. 10. 19.

@author: ckd39
'''

class Ant:
    def __init__(self, name, asset):
        self.name = name
        self.asset = asset
    
    def printInfo(self):
        print(self.name, self.asset)
#########################################################

# 아래 코드는, "이 모듈을 실행했을 때 동작해라" 라는 조건이다.
# 이 모듈을 실행한다는 것은, 이 모듈이 프로그램의 시작점이 된다는 뜻이다.
# 즉, 다른 모듈에서 import되었을 때에는 별도 작업을 하지 않게 된다.
# 즉, 이 모듈을 실행했을 때에만 동작하라는 뜻이며, Java에서의 main메소드 역할을 대신한다고 보면 된다. 
if __name__ == "__main__":
    from animal.pet import Dog
    d = Dog("고양이", 2)
    d.printInfo()
    
