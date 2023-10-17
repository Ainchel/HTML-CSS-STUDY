'''
Created on 2023. 10. 17.

@author: ckd39
'''

# -*- coding:utf-8 -*-

#파이썬에서의 반복문은, Java의 일반 반복문 for(int i = 0; ...) 하는 이걸 지원하지 않는다.
#대신, forEach 형식의 반복문(int ii : i) 형식은 지원한다.

l = [123, 45, 6, 78, 910]

for ll in l:
    print(ll)

# ㅋ를 10번 출력
for z in range(10):
    print("ㅋ", end="")
    
for zz in range(1,21,2):
    print(zz, end = " ")

# 1~ 20까지의 숫자 중에서 홀수만 출력

#파이썬의 while문. #do-while문은 없다.
# while True:
    # y = int(input("y : "))
    # if y % 2 == 0:
        # print("짝수")
        # break
    
#enumerate : 반복문을 사용할 때, 몇 번 반복되었는지 확인할 수 있는 키워드.
#사용 시, (인덱스, 값) 형태의 tuple로 리턴시켜준다.

ll = ["컴퓨터", "모니터", "마우스", "키보드"]
for i, v in enumerate(ll): # 반복 횟수가 i, 내용물이 v자리.
    print(i + 1, v)

print("--------------------------------")

score = [10, 54, 56, 70, 70, 87, 65, 99, 91, 88]

max = -999
idx = 0

for i, s in enumerate(score):
    if s > max:
        max = s
        idx = i
        
print("1등 학생은", idx+1, "번째에 있으며", "점수는", max, "점입니다.")