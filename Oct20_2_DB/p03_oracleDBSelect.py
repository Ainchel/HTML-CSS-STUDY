'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

#연결
con = connect("ainchel/1541547@localhost:1521/xe")

#sql문 작성
sql = "select c_name, c_price, c_bean from oct20_coffee order by c_price"

#DB관련 총괄객체 만들기.
#자바에서는 Read할떄, resultset을 만들어 사용했다.
#파이썬에서는, select문의 결과가 cur에 그대로 담기게 된다.
cur = con.cursor()

#sql문 수행 - select쿼리문의 결과가 cur에 tuple 형태로 들어오게 된다.
cur.execute(sql)

#for c in cur:
#    print(c, type(c))

for n, p, b in cur:
    print(n, p, b)
    print("--------------------------------")

#사용 후 종료
con.close()