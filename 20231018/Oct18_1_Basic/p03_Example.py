'''
Created on 2023. 10. 18.

@author: ckd39
'''
import random

# -*- coding:utf-8 -*-

def Hello():
    print("########UP/DOWN 게임########")

def getname():
    return input("환영합니다. 이름을 입력해 주세요 : ")

def getnumber():
    return random.randint(1, 100)

def inputanswer():
    input = int(("컴퓨터가 1~100 사이의 숫자를 정했습니다. 몇일까요?"))
    if(1 <= input <= 100):
        return input
    else:
        print("1~100 사이의 값을 입력해 주세요!")
        inputanswer()

def checkAnswer(input, comnum, answerCount, isOver):
    if(input < comnum):
        print("입력하신 숫자보다 높은 수입니다!")
    elif(input == comnum):
        print("정답입니다!")
        isOver = True
    elif(input > comnum):
        print("입력하신 숫자보다 작은 수입니다!")
    answerCount+=1
##########################
name = ""
answerCount = 0
mynum = 0
comnum = 0
isOver = False

Hello()
name = getname()

while((isOver != False) or answerCount != 10):
    comnum = getnumber()
    mynum = inputanswer()