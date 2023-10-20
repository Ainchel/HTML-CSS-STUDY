'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

#원두의 이름을 검색해서, 해당 원두를 사용하는 커피의 종류 개수, 평균가를 출력하기.
#검색할 원두이름 입력받기
inputbean = input("검색할 원두 이름을 입력하세요 :")

#DB 연결
con = connect("ainchel/1541547@localhost:1521/xe")

#sql문 작성
sql = "select count(*), avg(c_price) from oct20_coffee where c_bean ='%s'" % inputbean 

#print(sql)

#DB Read 총괄객체 생성
cur = con.cursor()
#SQL문 실행 후 결과 받아오기
cur.execute(sql)

#결과물은 튜플로 생성되므로, for문 돌며 받아온 데이터 출력
for count, avg in cur:
    print("입력한 원두를 사용하는 커피 수 :", count)
    print("입력한 원두를 사용하는 커피 평균 가격 :", int(avg))
    
con.close()