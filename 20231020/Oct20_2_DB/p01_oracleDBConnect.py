'''
Created on 2023. 10. 20.

@author: ckd39
'''
from cx_Oracle import connect

# -*- coding:utf-8 -*-

# 파이썬에서 Oracle DB와 연결해보기. 코드 짧다고 함 우왕

# Java에서 OracleDB에 연결하려면...? instant client에 있는 ojdbc8.jar가 필요했다.
# 파이썬에서 OracleDB에 연결할 때에는..? cx_oracle.py라는 모듈(이 ojdbc8.jar를 사용)이 필요하다.
# 기본적으로, 파이썬에는 OracleDB에 연결하는 기능이 없다. ??????????????????

# cmd를 연 후, pip install cx_oracle이라고 입력하여 설치.
# 설치 확인은, pip list라고 친 후 목록에 cx_oracle이 있는지 확인.
# DB 연결에 필요한 주소로, [ID]/[PW]@[IP Address(localhost로 대체):[PORT]/[SID]값이 필요하다.
# ainchel/1541547@localhost:1521:xe

try:
    #DB에 연결 시도 : cx_oracle 모듈의 "connect" 메소드를 사용한다(패러미터로 위 DB주소)
    con = connect("ainchel/1541547@localhost:1521/xe")
    print("성공")
    
except Exception as e:
    print(e)
    
con.close()