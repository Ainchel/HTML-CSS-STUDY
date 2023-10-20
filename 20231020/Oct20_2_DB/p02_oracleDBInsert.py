'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

#1. DB 우선 연결
con = connect("ainchel/1541547@localhost:1521/xe")

#3. Data 생성
#원두 예시 : 로부스타 / 아라비카 / 리베리카 등등 있다고 한다.
n = input("커피 이름 : ")
p = int(input("가격 입력 : "))
b = input("원두 이름 : ")

#4. sql문 작성
# Java에서는, 아직 미정인 데이터를 sql문 내에서 '?' 로 적고, 이후 메소드로 값을 설정했다.
# myBatis에서는, 받아온 값을 #{}를 통해 접근했다.
# 파이썬에서는, 비어있는 값 없이 완성된 sql문을 사용한다.(즉, sql문 전에 완성시켜야 한다.)
# 파이썬에서 sql문 작성이 끝난 후, 세미콜론은 작성하지 않는다. 파이썬이므로.
sql = "insert into oct20_coffee values(oct20_coffee_seq.nextval, "
sql += "'%s', %d, '%s')" % (n, p, b)
#print(sql)

#5. 실제 DB 작업(SQL문을 전송하고, 실행하고, 결과를 받아오고 등등)을 해줄 총괄객체 필요
#Java에서는 PreparedStatement(pstmt)가 있었다.
#파이썬에서는 con.cursor()라는 애가 필요하다.

cur = con.cursor()

#6. DB작업 실행
cur.execute(sql) #sql문을 수행

#7. 결과물 처리
#Java에서는 insert, update, delete의 결과(영향 받은 데이터 수)를 체크하여 처리했다.
if cur.rowcount == 1: # sql문으로 영향을 받은 데이터의 수가 하나라면? == sql문이 잘 실행됐다면
    print("DB적용 성공!")
    #파이썬에서는 반드시 위 sql문 처리 확인 후, 아래의 commit()을 해줘야 실제 반영이 된다.
    con.commit()
    
#2. DB 연결 종료
con.close()