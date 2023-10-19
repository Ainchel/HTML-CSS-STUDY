'''
Created on 2023. 10. 19.

@author: ckd39
'''

# -*- coding:utf-8 -*-

# 파이썬에서의 예외처리에 관련하여.
# 자바에서는 예외처리가 강제됐다. => 쓰다보면 try-catch에 넣으라고 난리쳤었음. 하기 싫어도 했어야했음.
# 예외 처리 방법 : 직접 하기(try-catch-finally)와 미루기(throws)가 있었다.

# 파이썬의 경우? 하기 싫으면 안 해도 됨.
# 직접 하기 : try-except-else-finally 구문.(else와 finally는 없어도 됨)

# 자바에서의 에러 구분.
# error : 코드를 컴파일(코드 -> 기계어 전환)하지 못하는 상황.
# warning : 실행에는 문제가 없으나, 코드가 더럽거나 불필요한 경우.(쓸모없는 변수, close안하기 등)
# exception : 실행하다가 예외상황이 발생하여, 실행 도중 문제가 발생한 경우.

# 파이썬에서는? 일단 인터프리터라, 실행하고 나서부터 한줄 씩 기계어로 바꿔나간다.
# 그래버리기 때문에, error와 exception의 경계가 매우 모호하다. 컴파일이 없으니까.
################################################################

# 정수 2개를 입력받아서, 앞의 숫자를 뒤의 숫자로 나눈 몫을 출력해라.
# 혹시나 나누는 수가 0일 것을 대비하여, try-except로 예외처리 시도해본다.
try:
    input1 = int(input("나뉘는 숫자 입력 : "))
    input2 = int(input("나눌 숫자 입력 : "))

    print("몫:", input1 // input2)
    
    l = [1, 23, 456]
    print[l[input2]]

# except에 아래처럼 예외 종류를 명시해도 좋지만, 한번에 뭉뚱그려서 해버릴 수도 있다.
# except ZeroDivisionError:
    # print("나누는 수에 0이 들어갈 수 없습니다.")
# except IndexError:
    # print("리스트 아웃 오브 레인지!!")
except Exception as asdf: #일괄 처리하는 방법. 예외 내용을 알기 위해 asdf 별칭도 준다.
    print(asdf) # 별칭 준걸 통해서 예외 내용을 확인하기
    
else: # try영역에서, 중간에 exception으로 가지 않고 코드가 정상적으로 실행되면 마지막에 실행된다.
    print("else는 try코드에서 문제가 없었다면 실행됩니다.")
    
finally: #여기는 예외발생 하던 안하던 무조건 실행하며, return을 만나도 실행된 후에 return된다.
    print("finally는, 문제가 있던 없던, return을 만나도 무조건 실행됩니다.")