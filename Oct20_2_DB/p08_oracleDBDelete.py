'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

# 번호순으로 조회한 후, 번호를 입력하면 해당 데이터를 삭제!
# 999를 입력하면, 프로그램이 종료된다.

con = connect("ainchel/1541547@localhost:1521/xe")
cur = con.cursor()

while True:
    sql = "select * from oct20_coffee"

    cur.execute(sql)

    for no, name, price, bean in cur:
        print(f"번호 : {no} | 이름 : {name} | 가격 : {price}원 | 원두 : {bean}산")
    
    inputdel = int(input("삭제할 커피 번호를 입력해 주세요 : "))
    if inputdel == 999:
        break

    sql = f"delete from oct20_coffee where c_no = {inputdel}"
    cur.execute(sql)

    if cur.rowcount == 1:
        print("삭제 성공!")
        con.commit()
        print("---------------------------------------------")
        
print("프로그램을 종료합니다.")

con.close()