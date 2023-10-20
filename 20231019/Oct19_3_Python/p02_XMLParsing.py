'''
Created on 2023. 10. 19.

@author: ckd39
'''
from urllib.parse import quote
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring, tostring

#naver API Client ID : uu0ZxUx8b8207VjfMtzS
#naver API Client secret: WhGfRSeAbi

#네이버 쇼핑 api URL : https://openapi.naver.com/v1/search/shop.xml

# 상품명을 입력받은 후, XML 파싱을 시킨다.
# 문서의 제목 / 최저가 / 브랜드 / 대분류 카테고리 정보를 출력해보자.

q = input("상품명 : ") # 한글값 입력할텐데, URL에는 한글 들어가면 안되므로 인코딩이 필요하다.
#URLEncoding해서 주소로 넘겨줄 예정.
q = quote(q)
print(q)

#HTTP요청 시, .request() 함수를 잘 살펴보고 요청헤더 처리까지 하자.
#.request()에서 헤더를 처리하려면, 매개변수로 headers = dict 형식으로 넘겨줘야 한다.
#그래서 아래에 naver에서 정한 규약 name 및 value로 dict를 만들었다.

naver_headers = {
    'X-Naver-Client-Id': 'uu0ZxUx8b8207VjfMtzS',
    'X-Naver-Client-Secret': 'WhGfRSeAbi' 
}

hc = HTTPSConnection("openapi.naver.com")
#뱀발로, .request()의 패러미터로 body가 있는데, 내부적으로 데이터를 전송해야할 때 쓴다.
#우리는 일단은 쓸 일 없는 것으로...
hc.request("GET", f"/v1/search/shop.xml?query={q}", headers=naver_headers)
res = hc.getresponse()
resBody = res.read()
#print(resBody.decode())

xmlToString = fromstring(resBody);

for i in xmlToString.iter("item"):
    replacedI = i.find("title").text
    replacedI = replacedI.replace("<b>", "")
    replacedI = replacedI.replace("</b>", "")
    print("상품명 : ", replacedI)
    print("최저가 : ", i.find("lprice").text)
    print("브랜드 : ", i.find("brand").text)
    print("대분류 : ", i.find("category1").text)
    print("-----------------------------------")