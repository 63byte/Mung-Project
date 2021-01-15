<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
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
	list-style-type: none;
	/* 불렛 없음 */
	padding: 0;
}

/* 메뉴 위아래 간격 */
.aside>ul>li {
	padding: 10px 0px 10px 0px;
}

.aside>ul>li>a {
	text-decoration: none;
	/* 불렛 없음 */
	font-weight: 700;
	color: black;

	/* border: 1px solid red; */
}

.aside>ul>li>a:hover {
	color: orange;
}
</style>

<div id="container">
	<div class="aside">

		<ul>
			<li><a href="#" class="aside-items" id="sChange">회원 조회</a></li>
			<li><a href="#" class="aside-items" id="sLike">비밀번호 변경</a></li>
			<li><a href="#" class="aside-items" id="sPostcheck">내가 쓴 글
					조회</a></li>
			<li><a href="#" class="aside-items" id="sWithdrawal">회원 탈퇴</a></li>
		</ul>
	</div>