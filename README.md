# Dawn
---
# 요청방법
**모든 데이터는 json 형식으로 보내야함**

---

### 1. 상품 정보 가져오기


### 1.1. 모든 상품 정보 가져오기
**url/product/all**

GET 요청 시 (상품코드, 상품카테고리, 상품 이미지 파일 이름, 상품브랜드, 상품명)
모든 상품데이터를 받을 수 있음
### 1.2 상품 코드로 데이터 받아오기
**url/product**
POST 요청 시 상품 코드를 JSON 형태로 전송하면 해당 상품에 해당하는 데이터를 받을 수 있음.
```JSON
{
  "pCode": 78 //상품분류코드
}
```
결과
```JSON
[
    {
        "상품분류코드": 78,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠1.jpeg",
        "상품브랜드": "프린트스타",
        "상품명": "베이식 무지 레이어드 반팔 티셔츠",
        "상품정상가": "20000",
        "상품할인가": "14900",
        "상품할인률": "26"
    }
]
```
### 1.3. 상품데이터 카테고리로 받아오기
**url/product/category**
POST 요청시 상품 데이터를 받을 수 있음
카테고리를 JSON으로 전송해야 함.
```JSON
{
    "category": "상의"
}
```
결과
```json
[
    {
        "상품분류코드": 78,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠1.jpeg",
        "상품브랜드": "프린트스타",
        "상품명": "베이식 무지 레이어드 반팔 티셔츠",
        "상품정상가": "20000",
        "상품할인가": "14900",
        "상품할인률": "26"
    },
    {
        "상품분류코드": 79,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠2.jpeg",
        "상품브랜드": "커버낫",
        "상품명": "에센셜 쿨 코튼 2-PACK 티셔츠",
        "상품정상가": "49000",
        "상품할인가": "39200",
        "상품할인률": "20"
    },
    {
        "상품분류코드": 80,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠3.jpeg",
        "상품브랜드": "마인드브릿지",
        "상품명": "고밀도순면기본반팔티셔츠",
        "상품정상가": "19900",
        "상품할인가": "19900",
        "상품할인률": "0"
    },
    {
        "상품분류코드": 81,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠4.jpeg",
        "상품브랜드": "지오다노",
        "상품명": "레이어드 반팔 티셔츠(2pck)",
        "상품정상가": "19800",
        "상품할인가": "15800",
        "상품할인률": "20"
    },
    {
        "상품분류코드": 82,
        "상품카테고리": "상의",
        "상품상세카테고리": "반소매 티셔츠",
        "상품이미지": "반소매_티셔츠5.jpeg",
        "상품브랜드": "그루브라임",
        "상품명": "NYC LOCATION T-SHRIT",
        "상품정상가": "58000",
        "상품할인가": "35000",
        "상품할인률": "40"
    },
    {
        "상품분류코드": 83,
        "상품카테고리": "상의",
        "상품상세카테고리": "맨투맨/스웨트셔츠",
        "상품이미지": "맨투맨_스웨터셔츠1.jpeg",
        "상품브랜드": "라퍼지스토어",
        "상품명": "헤비 기모 오버 럭비 맨투맨",
        "상품정상가": "45000",
        "상품할인가": "39000",
        "상품할인률": "13"
    },
    {
        "상품분류코드": 84,
        "상품카테고리": "상의",
        "상품상세카테고리": "맨투맨/스웨트셔츠",
        "상품이미지": "맨투맨_스웨터셔츠2.jpeg",
        "상품브랜드": "트래블",
        "상품명": "베이직 트래블러 피그먼트 스웨트셔츠",
        "상품정상가": "150000",
        "상품할인가": "59900",
        "상품할인률": "60"
    },
    {
        "상품분류코드": 85,
        "상품카테고리": "상의",
        "상품상세카테고리": "맨투맨/스웨트셔츠",
        "상품이미지": "맨투맨_스웨터셔츠3.jpeg",
        "상품브랜드": "비바스튜디오",
        "상품명": "RETRIEVER CREWNECK",
        "상품정상가": "69000",
        "상품할인가": "58650",
        "상품할인률": "15"
    },
    {
        "상품분류코드": 86,
        "상품카테고리": "상의",
        "상품상세카테고리": "맨투맨/스웨트셔츠",
        "상품이미지": "맨투맨_스웨터셔츠4.jpeg",
        "상품브랜드": "그루브라임",
        "상품명": "NYC LOCATION SWEATSHIRT",
        "상품정상가": "118000",
        "상품할인가": "59000",
        "상품할인률": "50"
    },
    {
        "상품분류코드": 87,
        "상품카테고리": "상의",
        "상품상세카테고리": "맨투맨/스웨트셔츠",
        "상품이미지": "맨투맨_스웨터셔츠5.jpeg",
        "상품브랜드": "지프",
        "상품명": "Half Zip-Up M-Logo Sweat",
        "상품정상가": "69000",
        "상품할인가": "58650",
        "상품할인률": "15"
    }
]
```
### 1.4. 상품데이터 상세카테고리로 받아오기
**url/product/category/detail**
POST 요청 시 상품 데이터를 받을 수 있음
상품 데이터 요청 시 상세 카테고리를 JSON으로 전송해야 함.
```json
{
    "detail": "데님팬츠"
}
```
결과
```JSON
[
    {
        "상품분류코드": 96,
        "상품카테고리": "하의",
        "상품상세카테고리": "데님팬츠",
        "상품이미지": "데님팬츠1.jpeg",
        "상품브랜드": "토피",
        "상품명": "와이드 데님 팬츠",
        "상품정상가": "49000",
        "상품할인가": "46000",
        "상품할인률": "6"
    },
    {
        "상품분류코드": 97,
        "상품카테고리": "하의",
        "상품상세카테고리": "데님팬츠",
        "상품이미지": "데님팬츠2.jpeg",
        "상품브랜드": "굿라이프웍스",
        "상품명": "이지 와이드 데님 팬츠",
        "상품정상가": "49800",
        "상품할인가": "42000",
        "상품할인률": "16"
    }
]
```
### 1.5. 상품 이미지 받아오기
**url/product/image**
POST 요청 시 상품 이미지를 받을 수 있음
상품데이터 요청 후 받은 이미지 파일 이름을 JSON 형식으로 전송 시 이미지를 받을 수 있음. 
```json
{
    "fileName": "셔츠1.jpeg" //상품 이미지 명
}
```
---
### 2. 상품 좋아요
### 2.1. 상품 좋아요 추가 삭제
**url/product/like**
POST 요청 시 상품이 좋아요 리스트에 추가 제거가 됨.
사용자의 좋아요 목록을 검색하여 해당 상품이 이미 좋아요 목록에 존재할 경우 자동으로 삭제
좋아요 목록에 존재하지 않는다면 좋아요 리스트에 추가
```json
{
    "uCode": 2, //유저분류코드
    "pCode": 56 //상품분류코드
}
```

### 2.2. 상품 좋아요 모두 받아오기
**url/product/like/all**
POST 요청 시 유저 코드를 전송하면 해당 유저가 좋아요한 모든 상품의 데이터를 받을 수 있음.
```JSON
{
    "uCode": 1 //유저분류코드
}
```
결과
```JSON
[
    {
        "좋아요분류코드": 5,
        "유저분류코드": 1,
        "상품분류코드": 53
    },
    {
        "좋아요분류코드": 7,
        "유저분류코드": 1,
        "상품분류코드": 54
    },
    {
        "좋아요분류코드": 8,
        "유저분류코드": 1,
        "상품분류코드": 55
    },
    {
        "좋아요분류코드": 9,
        "유저분류코드": 1,
        "상품분류코드": 56
    },
    {
        "좋아요분류코드": 10,
        "유저분류코드": 1,
        "상품분류코드": 57
    }
]
```
여기서 받은 상품 분류 코드로 다시 서버에 요청하여 상품 상세정보를 받으면 됨.

---
### 3. 유저 정보 관리
### 3.1. 회원가입
**url/user/signup**
POST 요청을 보내면 회원가입 요청이 가능함.
요청 시 JSON 형식으로 유저 데이터 전송 시 회원가입 가능
회원가입 성공이 true 반환
```JSON
{
   "uid": 2,
   "password": "password",
   "email": "test@test.com",
   "phone": "010-0000-0000",
   "name": "의문의 누군가",
   "sex": "test",
   "age": "test"
}
```
결과
```JSON
true
```
### 3.2. 로그인
**url/user/login**
POST 요청을 보내면 로그인 요청이 가능함.
요청 시 JSON 형식으로 유저 데이터 전송 시 로그인 가능
로그인 성공 여부를 true, false로 반환
```JSON
{
    "email": "test@test.com",
    "password": "password"
}
```
결과
```JSON
true
```
```JSON
{
    "email": "test@test.com",
    "password": "pass"
}
```
결과
```JSON
false
```