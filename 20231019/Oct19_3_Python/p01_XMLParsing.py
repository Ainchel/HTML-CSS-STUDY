'''
Created on 2023. 10. 19.

@author: ckd39
'''
from http.client import HTTPConnection
from xml.etree.ElementTree import fromstring

# -*- coding:utf-8 -*-

#파이썬으로 데이터 가공 많이 한다고 했다.

#기상청 - 구래동 - 3시간별 URL :
#http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=4157057000

#파이썬으로 HTTP 통신 해보기...! 아래 7줄로 끝난다. 참쉽죠?
hc = HTTPConnection("www.kma.go.kr")#먼저, 메인 주소까지만 가져온다. 
#HTTP/HTTPS처리는 Connection 이름에서 해결했음.
#메인주소 이은 후, request를 사용하여 연결한다.
#패러미터 : ("연결방식(GET/POST 등)", "메인주소 이후 URL")
hc.request("GET", "/wid/queryDFSRSS.jsp?zone=4157057000") #요청
res = hc.getresponse() #응답 결과 받아오기
resBody = res.read() #받아온 결과를 읽어오기
#print(resBody) # 받아온 결과를 출력해보기.
#위 코드까지만 진행하면, jsp에 처리되어있는 인코딩을 디코딩하지 않아 깨져서  나온다.
print(resBody.decode()) #받아온 결과.decode를 사용하여 디코딩시켜준다.

#XML-Parsing. xml형식 내의 온갖 DOM객체들에 접근해야 하는데..
#위 URL의 결과물에서는, <data>라는 DOM객체를 여러개 찾아와야 한다.
#여러개 찾는 방법 : .getiterator("태그명") 이었으나, .iter("태그명")으로 변경되었다고 한다.
#하나만 찾는 방법 : .find("태그명")

# 먼저, 찾아온 XML 데이터를 파이썬의 str로 변환한다.
# kmaWeather = fromstring(resBody)
# weathers = kmaWeather.iter("data") # 변환한 str내에서, "data"라는 이름의 태그를 가져온다.
# for w in weathers:
    # print(w)
    # print("---------------------------------")

#위 코드 좀 더 줄여보기.
#xml인 resBody를 String으로 변환 후, "data"라는 태그를 가진 각 DOM객체들에 접근해서
for w in fromstring(resBody).iter("data"):
    #각 "data" 객체 내에서 다시 DOM객체들을 하나씩 찾아, 그 내용물(.text)을 출력시킨다.
    print(w.find("hour").text)
    print(w.find("temp").text)
    print(w.find("wfKor").text)
