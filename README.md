# shop-project
스프링 레거시로 진행한 팀 프로젝트 입니다.  
쇼핑몰 프로젝트 입니다.

## Description
* 개발 기간 : 2022.09.05 ~ 2022.10.27
* 참여 인원 : 5명
* 사용 기술 
  + JSP, CSS, JS, JQuery
  + Spring 3.9.18, Apache Tomcat 9.0, Mybatis
  + Java, Ajax, Jquery, Git, MVC Pattern
  + Oracle 12g Database

* 담당 구현 파트
  + 프로젝트 개발환경 구축, 설계 
  + Header 메인 메뉴 디자인 및 구성(검색)
  + 상품 카테고리 페이지 구현(상품리스트, 검색)
  + 관리자 상품(추가,수정,삭제) 구현 
  + 그 외 페이지 구현(사용자Home,사용자 관리, 주문관리, 상품 상세)

## Views
* **고객/상품(카테고리,검색)**  
  
![ezgif com-gif-maker](https://user-images.githubusercontent.com/106207558/202950698-cdccd95d-fffa-4eae-be4e-125370f22ebb.gif)  
* **관리자/상품 추가**  
  
![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/106207558/202951810-96aa4d80-bf6b-4bf2-acd5-0574ddd20402.gif)
* **관리자/상품 추가**    
  
![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/106207558/202952817-69435587-c70c-49f0-b03f-653f568214c7.gif)  
  
* **관리자/상품 삭제**  
  
![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/106207558/202954108-edaa0f0d-1703-4271-a4c7-b172ebd9087c.gif)  

## Implementation
  
* **Header**
![SEARCH](https://user-images.githubusercontent.com/106207558/202955461-98cfadc2-20b2-40a8-8e78-0df193b72ba8.png)  
![dd](https://user-images.githubusercontent.com/106207558/234510065-92c6a004-3ae5-4291-832e-ea4d2269fabe.png)  

  + **메뉴설정, 상품검색 기능** 
     1. Mybatis를 이용하여 DB에 등록된 카테고리 정보를 JSTL을 활용해 동적으로 출력 
     2. 검색 시 상품의 제목을 비교하여 데이터를 가져오고 JsonView를 설정해  
        Json형태로 데이터를 가져와 검색한 목록들을 출력. 
  
  
* **카테고리**
![ENHEADER](https://user-images.githubusercontent.com/106207558/202955036-aa034887-c716-4dc2-a210-7947fe2c6b37.png)  
  + **카테고리별 검색, 리스트** 
     1. JsonView를 설정하여 Json형태로 데이터를 가져와 Ajax통신으로 상품 리스트를 구성 
     2. 관리자에서 상품 추가시 Jstl을 활용하여 동적으로 상품 데이터를 출력  

  
* **관리자 (상품 리스트, 등록, 수정, 삭제)**
  + **상품 리스트** 
![admin_plist](https://user-images.githubusercontent.com/106207558/202957157-951362e2-9499-4bfe-ac8f-62cf363fa963.png)  
     1. Mybatis를 이용하여 등록상품 전체 정보 출력
     2. 관리자에서 상품 추가시 Jstl을 활용하여 동적으로 상품 데이터를 출력  
     
       
  + **상품 등록**  
![pinsert](https://user-images.githubusercontent.com/106207558/202957681-0bc4fe27-1442-44d8-b1a4-e3133d59d95c.png)  
     1. Mybatis를 이용하여 DB에 상품 등록 
     2. 분류 - Ajax통신으로 해당 카테고리의 값들을 DB에서 가져와 출력  
               선택한 값에 대해 하위 값이 존재하면 하위값을 출력.
               상위 selectbox에서 카테고리 전체를 선택하면 하위 selectbox는  
               초기값으로 설정
     3. 상품 데이터에 대한 유효성 체크
       
         
  + **상품 수정**  
![pupdate](https://user-images.githubusercontent.com/106207558/202958339-f3f68249-4a26-485c-99e5-a3048796b0d8.png)  
     1. DB에 저장되어 있는 상품 정보 가져오기.
     
       
  + **상품 삭제**  
![pdelete](https://user-images.githubusercontent.com/106207558/202958650-a7788af5-d395-4af9-9f0e-9dca603c81e3.png)  
     1. Mybatis, Jquery, Ajax통신을 이용하여 (선택,전체)삭제 
  
## 오류사항
<h3> 상품 추가 (카테고리/분류) 
<h4> 1. 문제점  
상품추가 → 분류의 카테고리 대,중,소  
대분류를 클릭시 대분류에 따른 중분류  
데이터를 append하지 못함  
(사용 방법은 전체 데이터를 DB에서 가져와 JS사용하여 append)      
  
<h4> 2. 원인분석 
카테고리 데이터에 상위카테고리 지정을 잘못했다는 것을 확인  

<h4> 3. 시도 1(실패)  
중분류 카테고리는 해결했으나 소분류 카테고리에서 
카테고리에서 같은 문제 발생 

<h4> 4. 해결방안 모색 -> 시도 2
레벨을 따로 줘야한다고 하는 것 같았으나 컬럼을 또 새로 만들어주어야 하고
실행할 때 마다 전체 데이터를 가져오는 방식이 비효율적이라 생각이 들어
Ajax로 바꿔서 실행

<h4> 5. 해결 



## ERD
![MyShopERD](https://user-images.githubusercontent.com/106207558/202336265-038603e4-375f-4bb5-877a-2666f5ce2ede.png)
