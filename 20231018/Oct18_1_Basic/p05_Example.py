'''
Created on 2023. 10. 18.

@author: ckd39
'''
from random import randint

def generate_numbers():
    numbers = [] #빈리스트 생성
    while len(numbers) < 3:
        num = randint(0, 9)
        if num not in numbers: # 리스트 내에 현재 뽑은 숫자가 없을 때에만
            numbers.append(num) #리스트에 추가
    print("번호뽑기 완료")
    return numbers

def get_userAns():
    userAns = input("숫자야구 답 입력 : ")
    if len(userAns) != 3:
        print("답은 세자리를 입력해주셔야 합니다.")
        return get_userAns()
    elif((userAns[0] == userAns[1]) or
         (userAns[1] == userAns[2]) or
         (userAns[0] == userAns[2])):
        print("중복된 숫자를 입력할 수 없습니다.")
        return get_userAns()
    return userAns

def check(gn, ua):
    strike, ball = 0, 0
    for i in range(0, 3):
        for j in range(0, 3):
            if gn[i] == int(ua[j]):
                if i == j:
                    strike +=1
                else:
                    ball += 1
    return strike, ball

def playGame():
    gn = generate_numbers()
    turn = 0
    print(gn)
    s = 0
    b = 0
    while s != 3:
        s, b = check(gn, get_userAns())
        turn += 1
        print("{}S {}B !".format(s, b))
    if s == 3:
        print("%d번만에 맞췄습니다!" % turn)
        print("정답은", end = " ")
        for a in gn:
            print(a, end="")
        print("입니다!")
#########################################################

playGame()