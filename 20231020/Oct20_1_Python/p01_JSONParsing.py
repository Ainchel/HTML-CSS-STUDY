'''
Created on 2023. 10. 20.

@author: ckd39
'''
from http.client import HTTPSConnection
from json import loads

# -*- coding:utf-8 -*-

# JSONParsing.

#오픈웨더맵 - 도시이름으로 검색 API URL : 
#https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

#오픈웨더맵 인증키
#42008a8c8e7402a3fc9d3b1a7df8fee9

#도시 이름을 영어로 입력하여(한국의 경우 시 단위까지만)
#요청파라미터는 알아서 추가하기.
#HTTP로 요청해서, 응답 내용 출력까지만.

where = input("도시 이름(영어로, 한국은 시 단위까지만) : ")

hc = HTTPSConnection("api.openweathermap.org")

hc.request("GET", f"/data/2.5/weather?q={where}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9&lang=kr&units=metric")

resbody = hc.getresponse().read()

#print(resbody.decode())

#위까지가 HTTP통신이었으며, 아래는 이제 JSON 형태로 변형해보기.

weatherData = loads(resbody) # JS -> Python으로 변경
#print(weatherData)

#JSON은 JS에서의 배열(Array)로 되어있다.
#즉, Python에서의 list로 연관짓는 게 가능할 것이다.
#그리고 JSON에서의 object는, python에서의 dict로 연관지을 수 있다.

#받아온 JSON에서 날씨 / 기온 / 체감기온 / 습도 / 바람속도
#데이터를 콘솔창에 출력하기.

findkey = weatherData['base']
findweather = weatherData['weather'][0]['description']
findtemp = weatherData['main']['temp']
findfeelslike = weatherData['main']['feels_like']
findhumidity = weatherData['main']['humidity']
findwindspeed = weatherData['wind']['speed']
#print("base :", findkey)
print("도시명 : ", where)
print("날씨 : ", findweather)
print("기온 : ", findtemp)
print("체감온도 : ", findfeelslike)
print("습도 : ", findhumidity)
print("바람속도 : ", findwindspeed)