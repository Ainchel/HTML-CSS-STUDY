'''
Created on 2023. 10. 19.

@author: ckd39
'''
from datetime import datetime

# -*- coding:utf-8 -*-

# 현재 시간과 날짜를 사용하는 자료 뽑아보기.

now = datetime.today() #자동완성할 때, _datetime 아님!!! 그냥 datetime임 주의하기!!!!
print(now)

# 특정 시간과 날짜를 뽑아보기.
yesterday = datetime(2023, 10, 18) # 연, 월, 일을 넣어 특정 날짜의 시간을 지정한다.
                                   # 입력한 부분만 나오므로, 필요한 추가 정보(시,분,초 등)를 넣어주자.
print(yesterday)
print(type(yesterday)) # 타입 : datetype이다.
#아래와 같이, 날짜 자료의 특정 부분만을 잘라서 출력시킬 수도 있다.
print(yesterday.year)
print(yesterday.month)
print(yesterday.day)

#생일을 입력받아서(연, 월, 일), 나이를 계산해주는 프로그램(출력하기)

# inputYear = int(input("태어나신 해를 입력해 주세요 : "))
# inputMonth = int(input("태어나신 월을 입력해 주세요 : "))
# inputDay = int(input("태어나신 날짜를 입력해 주세요 : "))
#
# resultYear = datetime.today().year - inputYear
# if(inputMonth > datetime.today().month):
    # resultYear-=1
    #
# if(inputMonth == datetime.today().month):
    # if(inputDay > datetime.today().day):
        # resultYear-=1
        #
# print(resultYear)

#선생님 풀이
birthday = input("생년월일(yyyy/mm/dd) : ") # string임.
#curYear = now.year #int임.
#print(curYear - int(birthday[0:4])) split처럼, string배열에서 연도부분만 빼오기.

########################################################
#str => datetime으로의 변환 방법 : strptime
bd = datetime.strptime(birthday, "%Y/%m/%d")# 이걸 거치면 datetime이다.
print(type(bd))

#datetime => str로의 변환 방법 : strftime
bd = datetime.strftime(bd, "%A")
print(bd)
#################################################################
#위 변환식에서의 패턴 정리
# %Y, %y : 연도 4자리 / 연도의 뒤 2자리
# %m : 월 / %d : 일 / %H : 시간(24시표기) / %I : 시간(12시표기) / %p : AM, PM
# %M : 분 / %S : 초 / %a : 요일(줄인버전) / %A : 요일(긴버전)
###################################################################
#특정 날짜를 연/월/일 형태로 입력받은 후 => 일/월 형태의 문자열로 출력하기.

inputYMD = input("날짜 입력(yyyy/mm/dd) : ")
print(inputYMD)
dt = datetime.strptime(inputYMD, "%Y/%m/%d")
print(dt)
str = datetime.strftime(dt,"%d/%m")

print(str)