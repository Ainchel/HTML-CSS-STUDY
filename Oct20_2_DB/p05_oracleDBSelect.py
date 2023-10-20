'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

#input으로 숫자 2개 입력
#가격순으로 오름차순한 다음, ? ~ ?번째까지의 평균 가격을 출력

input1 = int(input("시작 숫자 입력 : "))
input2 = int(input("끝 숫자 입력 : "))

con = connect("ainchel/1541547@localhost:1521/xe")

sql = "select avg(c_price) from ("
sql += "select c_price, ROWNUM AS rn from ("
sql += "select * from oct20_coffee order by c_price)) "
sql += f"where rn between {input1} and {input2}"

print(sql)

cur = con.cursor()
cur.execute(sql)

for avg in cur:
    print(f"가격 순으로 정렬한 {input1}번부터 {input2}번 항목의 평균 가격은 {avg[0]}원입니다.")
    
con.close()