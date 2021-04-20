# 뭉개뭉개
### 🐶 𝘾𝙊𝙉𝙏𝙀𝙉𝙏 🐶 

𝟭. TEAM SuperJunio <br>
𝟮. 개발 일정 및 환경 <br>
𝟯. 기획 의도 <br>
𝟰. 로고 & 컬러 <br>
𝟱. 구현 기능 <br><br>

### 👍 𝙏𝙀𝘼𝙈 𝙎𝙪𝙥𝙚𝙧 𝙅𝙪𝙣𝙞𝙤
![image](https://user-images.githubusercontent.com/74957603/115360254-6c8ce100-a1fa-11eb-92d6-05a1c2354789.png)
<br><br>

### 👍 개발 일정
𝟮𝟬𝟮𝟬.𝟭𝟮.𝟮 ~ 𝟮𝟬𝟮𝟭.𝟭.𝟮𝟱
<br><br>

### 👍 개발 환경
- OS : Windows 10
- WAS : Apache Tomcat 8.5
- Program : Java Eclipse , Oracle, SQL Developer, VS Code, PhotoShop, Illurstrator
- Site : 와이어프레임 (Figma), 미리캔버스 (로고, 아이콘), 핀터레스트 (사진), 구글 스프레드시트 (프로젝트 관련 실시간 공유)
- Skill : Servlet, JSP, HTML, CSS3, javascript, jQuery
- API : Kakao MAP API (동물병원 / 숙소 / 여행), 이메일 인증 API (회원가입 / 내 정보 이메일 수정)
- Library (cos.jar / gson-2.8.6.jar / json-simple-1.1.1.jar / mail-1.4.7.jar / ojdbc6.jar / taglibs-standard-impl-1.2.5.jar
           / taglibs-standard-jstlel-1.2.5.jar / taglibs-standard-spec-1.2.5.jar
<br><br>

### 👍 기획 의도
반려 인구의 증가로 반려 동물과 관련된 산업을 뜻하는 펫코노미 (petconomy) 시장 규모가 2020년에 약 3조 4000억원을 넘을 것으로 전망된다고 합니다. 펫코노미 시장은 펫 택시, 유치원, 여행, 장례 서비스, IT 결합상품 등 기존에 없던 새로운 서비스가 출시되고 있습니다. 저희는 여행과 반려견의 키워드를 합쳐서 반려견과 함께 여행할 수 있고 그에 관련된 정보를 제공할 수 잇는 사이트를 계획했습니다.
<br><br>

### 👍 로고 & 컬러
![image](https://user-images.githubusercontent.com/74957603/115365338-4158c080-a1ff-11eb-8c11-69b8a6112a67.png)

### 👍 구현 기능 및 화면
   #### 1. 𝖬𝖺𝗂𝗇 𝗁𝖾𝖺𝖽𝖾𝗋 & 𝖮𝗍𝗁𝖾𝗋 𝗁𝖾𝖺𝖽𝖾𝗋 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115370882-6f8ccf00-a204-11eb-9c73-0e6c199efdbc.png)
   - 로그인을 클릭하면 로그인 페이지, 회원가입 클릭시 회원가입 페이지로 이동한다.
   - 상단 강아지 로고를 클릭하면 메인으로 이동한다.
   - 각각 카테고리 메뉴를 클릭하면 해당 관련 페이지로 이동한다.
   - 로그인을 하면 로그인 부분은 닉네임으로 대체된다. 
   - 로그아웃을 클릭하면 로그아웃이 된다.
   - 카테고리 클릭시 보여지는 other header <br>
   ![image](https://user-images.githubusercontent.com/74957603/115374863-322a4080-a208-11eb-8748-1e54ce0dc7f2.png)
   <br>
  
   #### 2. 𝖫𝗈𝗀𝗂𝗇 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115376753-f001fe80-a209-11eb-91ca-6cc08e96d13f.png)
   - 로그인 화면을 구성.
   - 아이디와 비밀번호를 입력할 수 있다.
   - 아이디를 저장할 수 있는 체크 박스가 있다.
   - 정보를 입력 후 로그인 버튼을 누르면 로그인이 되며 메인으로 이동한다.
   - 하단에 id/pw 찾기와 회원가입 화면을 클릭시 해당 화면으로 이동한다.
   <br>
   
   #### 3. 𝖥𝗂𝗇𝖽 𝖨𝖣/𝖯𝖶 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115428434-5c4a2580-a23d-11eb-8484-1faa9620d2b6.png)
   - 상단 강아지 로고를 클릭하면 메인으로 이동한다.
   - 아이디 찾기와 비밀번호 찾기 버튼이 있어 각각 화면으로 이동한다.
   - 회원가입시 입력했던 이름과 이메일, 그리고 이메일 인증 번호를 입력할 수 있다.
   ![image](https://user-images.githubusercontent.com/74957603/115430379-46d5fb00-a23f-11eb-9de8-c2e88a5fef6f.png)
   - 이메일 인증 번호가 틀리면 알림창이 뜬다.
   - 모든 정보를 맞게 입력하면 다음 화면으로 이동한다.
   ![image](https://user-images.githubusercontent.com/74957603/115429094-075adf00-a23e-11eb-8673-5b9f250889f3.png)
   - 다음 화면으로 이동하면 본인 아이디가 확인 가능하다. 하단 버튼 클릭시 로그인 화면으로 이동한다. (비밀번호 찾기도 동일함.)
   ![image](https://user-images.githubusercontent.com/74957603/115429597-84865400-a23e-11eb-8903-5049b9b13116.png)
   - 비밀번호 찾기일 경우 비밀번호를 재설정할 수 있다. 재설정 후 완료 페이지로 이동한다.
   <br>
   
   #### 4. 𝖲𝖾𝗅𝖾𝖼𝗍 𝖬𝖾𝗆𝖻𝖾𝗋𝗌𝗁𝗂𝗉 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115431079-e0051180-a23f-11eb-8acf-45ea492d221a.png)
   - 회원은 회원가입시 선택할 수 있다. 일반 회원과 업체 회원으로 나눠진다. 
   - 버튼 클릭시 각각 회원가입 화면으로 이동한다.

   #### 5. 𝖬𝗒 𝗉𝖺𝗀𝖾 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115431689-8bae6180-a240-11eb-8028-e6f121e8a58d.png)
   - 마이페이지로 들어오면 왼쪽에 사이드 메뉴가 따로 있다.
   
   ---
   ##### ❤ 내 정보 수정 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115432203-14c59880-a241-11eb-86d4-4341928e14a7.png)
   - 회원은 자신의 정보를 수정할 수 있다.
   - 일반, 업체 회원으로 나뉘어져있어 입력 화면이 다르다. (좌-일반 / 우-업체)
   - 조건에 맞게 창에 입력하고 변경하기를 클릭하면 수정된 내용으로 저장된다.
   
   ---
   ##### ❤ 비밀번호 변경 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115432467-59e9ca80-a241-11eb-85a3-9bc0cf1cc308.png)
   - 회원은 비밀번호를 변경할 수 있다.
   - 회원가입시 입력했던 비밀번호와 변경할 비밀번호, 재확인 비밀번호를 입력해야한다.
   - 변경 버튼을 누르고 일치하면 알림창과 함께 변경이 된다.
   - 입력된 비밀번호가 불일치하면 불일치 알림창이 뜬다.
   
   ---
   ##### ❤ 내가 쓴 글 조회 <br>
   ![image](https://user-images.githubusercontent.com/74957603/115432780-bb119e00-a241-11eb-949b-01eb63611cb2.png)
   - 회원은 자유게시판에 쓴 글과 댓글을 조회할 수 있다. 상단 버튼 클릭시 해당 화면으로 이동한다.
   - 글 번호, 제목, 작성일, 조회수를 조회할 수 있다.
   - 글 목록을 클릭하면 해당 게시글로 이동이 가능하다.
   - 페이징 처리가 되어있어 1~10까지 숫자로 나타나며, 그 이상은 >,>> 버튼을 클릭해 다음으로 이동이 가능하다. (<,<< 또한 이전으로 이동 가능.)
   - 하단에는 검색 기능을 이용할 수 있다. 글 제목, 제목+내용을 옵션으로 고를 수 있다.
   

 



