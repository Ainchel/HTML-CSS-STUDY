'''
Created on 2023. 10. 18.

@author: ckd39
'''
import random
from p03_Example import mynum

# -*- coding:utf-8 -*-

#Java에서의 null은, 파이썬에서는 None으로 쓴다.

def RSP():
    comsel = random.randint(1, 3)
    mysel = input("가위, 바위, 보 중 입력해 주세요 : ")
    if(mysel == "가위"):
        mysel = 1
    elif(mysel == "바위"):
        mysel = 2
    elif(mysel == "보"):
        mysel = 3
    else:
        print("가위,바위,보가 아닌 값을 입력하셨습니다. 다시 입력해 주세요.")
        RSP()
    
    if(comsel == 1): # 가위
        if(mysel == 1):
            print("비겼습니다.")
        elif(mysel == 2):
            print("이겼습니다!")
            wincount+=1
        elif(mysel == 3):
            print("졌습니다...")
            return True
    
    elif(comsel == 2): #바위
        if(mysel == 1):
            print("졌습니다...")
            return True
        elif(mysel == 2):
            print("비겼습니다.")
        elif(mysel == 3):
            print("이겼습니다!")
            wincount+=1
    
    elif(comsel == 3): #보
        if(mysel == 1):
            print("이겼습니다!")
            wincount+=1
        elif(mysel == 2):
            print("졌습니다...")
            return True
        elif(mysel == 3):
            print("비겼습니다.")
            
#########################################
print("########가위바위보 게임########")
print("질 때까지 가위바위보를 하고, 몇 번 이기셨는지 확인하세요!")
wincount = 0
isLose = False
while (isLose == False):
   isLose = RSP()
    
print("승리 수 : %d" % wincount)