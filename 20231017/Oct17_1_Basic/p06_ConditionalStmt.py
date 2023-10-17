'''
Created on 2023. 10. 17.

@author: ckd39
'''

#-*- coding:utf-8 -*-

#파이썬에서의 조건문 : 똑같이 흐름 제어를 위한 문법.
#조건이 참이라면 실행, False라면 실행하지 않음.
#파이썬의 경우, 블록이 없으므로 :를 통해 블록을 명시해준다.
#또한, 들여쓰기를 해줘야 인터프리터 확인 상 if문의 실행 블록임을 명시하는 것이므로 반드시 들여쓰기를 해야한다.
#연산자의 우선순위(산술/관계/논리 내에서) : 산술 > 관계 > 논리 순을 따른다.

#파이썬에서의 if ~ else문 또한, if와 같은 방식으로 else:를 사용한다.

#문제 : 놀이동산 A 기구는 성인이며 키가 150 이상일 때에만 탑승 가능하다.
#나이와 키를 입력받아, 해당 사람이 탑승 가능한지 불가한지 출력해라.

# age = int(input("나이를 입력해 주세요 : "))
# height = float(input("키를 입력해 주세요 : "))
#
# if (age >= 20):
    # if(height >= 150):
        # print("탑승 가능합니다.")
    # else:
        # print("탑승 불가능합니다.")
        #
# else:
    # print("탑승 불가합니다.")
    #
# if (age>= 20 and height >= 150):
    # print("탑승 가능합니다.")
# else:
    # print("탑승 불가능합니다.")
    #
# print("탑승 가능합니다." if (age >= 20 and height >= 150) else "탑승 불가능합니다.")
# print((age>= 20 and height >= 150) and "탑승 가능합니다." or "탑승 불가능합니다.")
#
# if True:
    # print("조건문 True 진입")
    #
# if False:
    # print("조건문 False는 안들어옴")
    #
# print(10 + 2 > 8 + 3)
# print(10 + 2 * 2 > 8 + 3 * 2)
# print(((10 + 2) > 3) and (6 + 4 == 10))

#파이썬에서의 다중 조건문 (if - else if - else)
#형식: if - elif - else

#점수를 입력받아, 80점 이상이라면 'A', 70점 이상이라면 'B', 60점 이상이라면 'C', 나머지는 'D' 출력

score = int(input("점수를 입력해 주세요 : "))

if(score > 100 or score < 0):
    print("구라 ㄴ")
elif(score >= 80):
    print("등급 : A")
elif(score >= 70):
    print("등급 : B")
elif(score >= 60):
    print("등급 : C")
else:
    print("등급 : D")
    
#java나 js에서 사용했던 switch-case는 파이썬에서 지원하지 않으므로 패스.

#파이썬의 in, not in
#Dict 하나 생성({}로 시작, 네임-밸류 형식)
abc = {"name" : "비버", "age" : 19, "phone": "010-1111-2222"}
#abc 안에, "name"이라는 네임이 있는지 확인하려면?
print("name" in abc) #True나 False 반환
#abc안에 20이라는 값이 있는지 확인하려면?
print(20 in abc.values()) #True나 False 반환
#abc안에 "height"라는 네임이 있지 않은지 확인하려면?
print("height" not in abc) #없으므로 True 반환