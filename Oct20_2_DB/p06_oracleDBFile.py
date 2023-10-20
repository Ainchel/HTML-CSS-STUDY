'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

file = open("C:/Users/ckd39/Downloads/Test/oracle.csv", "a")

con = connect("ainchel/1541547@localhost:1521/xe")

sql = "select c_name, c_price, c_bean from oct20_coffee"
cur = con.cursor()
cur.execute(sql)

for name, price, bean in cur:
    decodestr = f"{name},{price},{bean}\n"
    file.write(decodestr)

file.close()
con.close()