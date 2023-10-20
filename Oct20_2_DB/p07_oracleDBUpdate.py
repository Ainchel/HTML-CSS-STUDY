'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

#input을 2개 사용 : 하나는 원두 이름 검색, 하나는 숫자 입력
#검색한 원두를 사용하는 커피 가격을, 입력한 숫자만큼 인상

searchbean = input("원두 이름을 입력해 주세요 : ")
addprice = int(input("얼마나 인상시킬까요? : "))

con = connect("ainchel/1541547@localhost:1521/xe")

sql = f"update oct20_coffee set c_price = c_price + {addprice} where c_bean = '{searchbean}'"

cur = con.cursor()
cur.execute(sql)

if cur.rowcount >= 1:
    print("가격 인상 성공! 흑흑")
    con.commit()

else:
    print("db 수정 실패!!")
    
con.close()
