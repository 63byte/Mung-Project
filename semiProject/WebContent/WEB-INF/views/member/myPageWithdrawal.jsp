<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지_회원탈퇴</title>
<head>
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    
    부트스트랩 사용을 위한 라이브러리 추가
    jquery가 항상 먼저여야된다!
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script> -->
<style>
.withdrawalTitle {
	text-align: center;
	height: 70px;
	line-height: 100px;
	font-size: 25px;
}

.memberWithdrawal > hr {
	border: 1px solid orange;
}

#p1 {
	font-size: 20px;
}

.memberWithdrawal {
	width: 400px;
	margin: 0 auto;
	margin-right: 28ch;
}

#withdrawalDiv{
	line-height : 10px;
}
/* 레이블 태그 class명*/
.lb {
	font-weight: bold;
	line-height: 25px;
	font-size: 13px;
	margin: 0 auto;
}

/* 인풋 태그 class명 */
.inputTag {
	margin: 0 auto;
	height: 40px;
	width: 100%;
	padding: 0;
	border: 1px solid #bdbbbb;
}

/* inline-block 스타일 들어가야 하는 곳 전부 class 속성값 추가 */
.display-ib {
	display: inline-block;
}

.submit {
	margin-bottom: 387px;
}

#submitBtn {
	margin: 0 auto;
	height: 40px;
	width: 100%;
	font-size: 16px;
	border: 1px solid #8bd2d6;
	background-color: #8bd2d6;
	border-radius: 5px;
	color: white
}

#submitBtn:hover {
	background-color: #17a2b8;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

	<jsp:include page="myPageSideMenu.jsp"></jsp:include>

	<div class="wrapper2">
		<div class="withdrawalTitle">
			<p style="font-size: 30px;">회원 탈퇴</p>
		</div>
		<br>


		<form action="#" method="POST"
			onsubmit="return memberChangevalidate();">
			<div class="memberWithdrawal">
				<hr>
				<br>

				<div id="withdrawalDiv">
					<p id="p1">비밀번호를 입력 후 회원 탈퇴가 가능합니다.</p>
					<p id="p2">탈퇴를 진행하면 계정의 모든 정보가 삭제됩니다.</p>
				</div>

				<br>

				<!-- 비밀번호 입력 -->
				<div>
					<div class="lb">
						<label for="pwd1">비밀번호</label> <br>
					</div>
					<div class="ip">
						<input type="password" class="inputTag" id="pwd1" name="" required>
					</div>
					<div>
						<span id="chechPwd1">&nbsp;</span>
					</div>
				</div>

				<br>
				<br>
				<div class="submit">
					<input id="submitBtn" type="submit" name="" value="다음">
				</div>
			</div>
	</div>


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>






</body>
</html>