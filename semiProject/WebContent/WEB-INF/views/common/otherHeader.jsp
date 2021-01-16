<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>header-footer</title>

<!-- 구글 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Bootstrap core JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<!-- sweetalert : alert창을 꾸밀 수 있게 해주는 라이브러리 https://sweetalert.js.org/ -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js">
</script>

<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: 500; /* 굵기 지정(100, 300, 400, 500, 700) */
	font-size: 16px;
	color: #212529;
	box-sizing: border-box;
	margin: 0;
}

#header {
	height: 56px;
	margin: 0;
	padding: 0;
	background: #8ad2d5;
}
/* #header {min-height:100%;} */
/* 위의 부분이 div를 화면에 꽉 차게 만들어 주는 스타일 */
#header-group {
	height: 56px;
	/* border-bottom: 1px solid #e5e5e5; */
	display: flex;
	align-items: center;
	margin: auto;
	width: 1100px;
	position: relative;
}

#logo {
	height: 50px;
	display: block;
	position: absolute;
	right: 45%;
	
    top:0;
    bottom:0;
}

.header-right-items {
	display: flex;
	margin-left: auto; /* 오른쪽 정렬 */
}

.header-item {
	margin-left: 20px;
	font-size: 16px;
}

/* .search-input{
            background-color: #F5F6F8;
            height: auto;
            padding: .375rem .75rem;
            border: 1px solid #ced4da;
        } */

/* ------------------------------------------------------ */
#nav {
	height: 56px;
	border-bottom: 1px solid #e5e5e5;
	width: 1100px;
	display: flex;
	margin: auto;
	align-items: center;
	font-size: 16px;
	justify-content: space-between !important;
}

#nav>ul {
   list-style-type: none; /* 불렛 없음 */
    margin-top: 15px; /* 부트스트랩으로 올라가있던 네비 위치 내리기  */
}

#nav>ul>li>a {
	text-decoration: none; /* a태그 밑줄 없음 */
	font-size: 16px;
	color: black;
	font-weight: bold;
	display: flex;
	/* margin : 0px 65px 0 65px; */
	margin: 0px 50px 0px 50px;
}

#nav>ul>li {
	display: inline-block;
}

/* 메뉴에 마우스 오버했을 경우 민트색으로 변경  */
#nav>ul>li>a:hover {
	color: #8ad2d5;
}

/* ------------------------------------------------------ */
a{
   color:#000000;
   text-decoration: none;
}

a:hover{
   color:#ffffff;
   text-decoration: none;
}
</style>
</head>

<body>
	<div id="header">

		<div id="header-group">
			<!-- <form class="search">
                <input class="search-input" type="text" placeholder="검색어를 입력해주세요" aria-label="Search">
            </form> -->
			
			<a href="${contextPath}">
			<img id="logo" src="${pageContext.request.contextPath}/resources/image/common/logo2.png">
			</a>
			
			<c:choose>
				<c:when test="${empty sessionScope.loginMember }">
					<div class="header-right-items">
						<div class="header-item" id="header-login">
							<a href="${contextPath}/member/loginForm.do">로그인</a>
						</div>
						<div class="header-item" id="header-signUp">
							<a href="${contextPath}/member/signUpForm.do">회원가입</a>
						</div>
					</div>
				</c:when>

				<c:otherwise>
					<div class="header-item" id="header-login">
						<a href="${contextPath}/member/myPage.do">${loginMember.memberNickName }</a>
					</div>
					<div class="header-item" id="header-signUp">
						<a href="${contextPath}/member/logout.do">logout</a>
					</div>

				</c:otherwise>
			</c:choose>
		</div>
	</div>

	<!-- ------------------------------------------------------------------------- -->

	<div id="nav">
       <ul>

           <li><a href="#" class="nav-items" id="nav-home">홈</a></li>
           <li><a href="${contextPath}/travel/localList.do" class="nav-items" id="nav-travel">여행</a></li>
           <li><a href="#" class="nav-items" id="nav-room">숙소</a></li>

           <li><a href="${contextPath}/hospital/list" class="nav-items" id="nav-animalHospital">동물병원</a></li>
           <li><a href="#" class="nav-items" id="nav-board">게시판</a></li>
           <li><a href="#" class="nav-items" id="nav-mypage">마이페이지</a></li>
           <li><a href="#" class="nav-items" id="nav-serviceCenter">고객센터</a></li>
       </ul>
	</div>



</body>

</html>