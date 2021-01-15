<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="join.css" type="text/css">

<!-- 구글 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<!-- 부트스트랩 사용을 위한 css 추가 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- 부트스트랩 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>


<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: 500; /* 굵기 지정(100, 300, 400, 500, 700) */
	font-size: 16px;
	color: #212529;
	box-sizing: border-box;
	margin: 0;
	/* border : 1px solid black;  */
}

div {
	/* border : 1px solid black;  */
	box-sizing: border-box;
}

.wrapper {
	margin: auto;
}

/* ------------------------------------------------------ */
#container {
	width: 1100px;
	height: 800px;
	display: block;
	margin: auto;

	/* background-color: ghostwhite; */
}

.aside {
	width: 200px;
	height: 100%;
	float: left;
	border-right: 1px solid #e5e5e5;

	/* border: 1px solid red; */
}

.aside>ul {
	list-style-type: none; /* 불렛 없음 */
	padding: 0;
}

/* 메뉴 위아래 간격 */
.aside>ul>li {
	padding: 10px 0px 10px 0px;
}

.aside>ul>li>a {
	text-decoration: none; /* 불렛 없음 */
	font-weight: 700;
	color: black;

	/* border: 1px solid red; */
}

/* 메뉴에 마우스 오버 했을 경우 민트색을 변경 */
.aside>ul>li>a:hover {
	color: #8ad2d5;
}

/* ------------------------------------------------------ */
.main {
	width: 900px;
	height: 100%;
	float: left;
}

/* ------ 상단 빅배너 ------ */
#localInfo-bigBanner {
	width: 900px;
	height: 200px;
	position: relative;
}

#big-banner-title {
	/* background-color: yellow; */
	color: white;
	font-size: 45px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

/* ------ 인기도시 ------ */
.hot-city-area {
	width: 900px;
	height: 100px;
	border: 1px solid red;
	display: flex;
}

.hot-city-box {
	width: 100px;
	height: 100px;
	background-color: lightgrey;
	/* padding: 0px 5px 0px 5px ; */
	margin: 0px 14px 0px 0px;
}

.hot-city-thumbnail-img {
	width: 100px;
	height: 60px;
	border: 1px solid red;
}

.hot-city-title {
	width: 100px;
	height: 40px;
	text-align: center;
	/* border:1px solid blue; */
}
</style>
</head>




</head>
<body>

	<!-- header 연결 -->
	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

	<div id="container">
		<div class="aside">

			<ul>
				<li><a href="#" class="aside-items" id="aside-localInfo">지역정보</a></li>
				<li><a href="#" class="aside-items" id="aside-touristSpot">관광지</a></li>
			</ul>
		</div>


		<div class="main">

			<div id="localInfo-bigBanner">
				<img
					src="${pageContext.request.contextPath}/resources/image/travel/localInfo/local-bigbanner(900x200)_seoul.jpg">
				<div id="big-banner-title">서울</div>
			</div>

			<div>인기도시</div>
			<div class="hot-city-area">
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="서울">서울</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="인천">인천</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="대구">대구</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="부산">부산</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="강원도">강원도</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="경상도">경상도</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="전라도">전라도</div>
				</div>
				<div class="hot-city-box">
					<div class="hot-city-thumbnail-img"></div>
					<div class="hot-city-title" name="제주도">제주도</div>
				</div>
			</div>

		</div>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>



</body>
</html>