'''
Created on 2023. 10. 19.

@author: ckd39
'''

# -*- coding:utf-8 -*-

# 파이썬에서의 파일 처리 방법에 대하여.
# 파일 처리 : 파일로부터 데이터를 읽어온 후, 이 프로그램(코드)에서 활용하기 위함.
# 아니면 프로그램을 통해 만든 데이터를 파일 형태로 다른 곳에 저장하기 위함.

# 진행 순서 : 파일 열기 => 작업(읽기? 쓰기?) => 연 파일 닫아주기(필수!!).

# 1. 파일에 내용 덮어쓰기(write).

# 먼저 경로(폴더)를 미리 만들고 지정한다. 파일은 존재하지 않아도 실행 시 만들기가 가능.
# 형식 : open("파일 경로", "모드유형", encoding = "인코딩 방식")
# file = open("C:/Users/ckd39/Downloads/Test/test.txt", "w", encoding = "UTF-8")
# file.write("점심먹고 식곤증 지려 @_@")
# print("작성 완료!")
# file.close() # 파일 연 뒤에는 꼭 닫아준다.
# 위 파일 생성 코드를 반복해서 실행하면, 내용이 계속 붙는 게 아니라 기존 것에서 덮어써진다.

# 2. 파일에 내용을 추가하기. 두번째 패러미터의 "a"는 "append"를 의미한다.
# 아래 코드를 실행하면, 해당 파일에 계속계속해서 추가되어간다.
# file = open("C:/Users/ckd39/Downloads/Test/test.txt", "a", encoding = "UTF-8")
# file.write("\n오늘 점심은\n코울슬로 치킨버거...\n맛있었다 오늘 점심은... 흑흑")
# print("append 완료!")
# file.close()

# 3. 파일 읽어오기 (read). 두번쨰 패러미터에 "r"(read)를 집어넣는다.
file = open("C:/Users/ckd39/Downloads/Test/test.txt", "r", encoding = "UTF-8")
# # 3-1. 파일 전체 읽어오기
# data = file.read()
# print(data)
# file.close

# 3-2. 파일을 한줄한줄 읽어오기.
while True: #파일 내 데이터가 얼마나 되는지 모르므로, 일단 while True로 걸어야 한다.
    data = file.readline() # 한 줄만 읽어옴
    print(data, end="") # 받아온 줄 출력하고 줄내림하면 보기 힘드므로 end에 빈값""을 넣는다.
    #readline의 결과가, 마지막에는 공백이 될 것이다.(한줄한줄 읽고 마지막줄은 비었을 것이므로)
    if data=="": # 맨 마지막줄까지 가면 
        break #while문 종료시켜라

file.close()