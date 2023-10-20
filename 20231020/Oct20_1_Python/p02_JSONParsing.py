'''
Created on 2023. 10. 20.

@author: ckd39
'''
from http.client import HTTPSConnection
from urllib.parse import quote
from json import loads

# -*- coding:utf-8 -*-

# 필요한 데이터를 챙긴 후,
# 책 이름을 검색한다. => 검색한 책의 제목 / 작가 / 할인가 / 도서 소개 출력

# 카카오 책검색 API URL : https://dapi.kakao.com/v3/search/book
# 내 REST API 키 : 51a7bc776e76b61ec69b7184568eb431

kakao_headers = {
        'Authorization' : 'KakaoAK 51a7bc776e76b61ec69b7184568eb431'
}

q = input("책 제목을 입력해 주세요 : ") # 한글값 입력할텐데, URL 패러미터에는 한글 들어가면 안되므로 인코딩이 필요하다.
#URLEncoding해서 주소로 넘겨줄 예정.
q = quote(q)
hc = HTTPSConnection("dapi.kakao.com")
hc.request("GET", f"/v3/search/book?target=title&query={q}", headers=kakao_headers)

resbody = hc.getresponse().read()
#print(resbody.decode())

#검색한 책의 제목 / 작가 / 할인가 / 도서 소개 출력

bookData = loads(resbody)

for d in bookData['documents']:
    print("책 제목 : ", d['title'])
    replacedauthors = ""
    for a in d['authors']:
        replacedauthors = replacedauthors + a + "/"

    #replacedauthors = str(d['authors'])
    replacedauthors = replacedauthors.replace("['", "").replace("']", "").replace("[]", "미상")
    print("작가 : ", replacedauthors)
    print("할인가 : ", d['sale_price'])
    print("도서 소개 : ", d['contents'])
    print("---------------------------------------------------")