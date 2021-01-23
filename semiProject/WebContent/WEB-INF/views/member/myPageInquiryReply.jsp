<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>마이페이지_내가 쓴 글 조회</title>
<head>
<!-- 구글 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<!-- 부트스트랩 사용을 위한 css 추가 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- 부트스트랩 사용을 위한 라이브러리 추가 (반드시 jQuery가 항상 먼저여야한다. 순서 중요!) -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>

<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
	font-weight: 500;
	/* 굵기 지정(100, 300, 400, 500, 700) */
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

.main {
	width: 900px;
	height: 100%;
	float: left;
}

th, td {
	font-size: 13px;
}

#inquiryBtn {
	margin-top: 15px;
	margin-left: 15px;
	background-color: #8ad2d5;
	color: white;
	border: white;
	border-radius: 5px;
	width: 150px;
	height: 40px;
}

#inquiryBtn:hover, #searchBtn:hover {
	background-color: #17a2b8;
}

.search{
	margin-bottom : 20px;
}

#searchBtn {
	background-color: #8ad2d5;
	color: white;
	border: white;
	border-radius: 5px;
	height: 38px;
}

h6 {
	margin-left: 15px;
	height: 30px;
}

.page-item>a {
	color: black;
}

.page-item>a:hover {
	color: orange;
}
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

	<jsp:include page="myPageSideMenu.jsp"></jsp:include>

	<div class="main">

                <div id="btnDiv">
                    <a href="myPageInquiryPost.do"><button type="menu" id="inquiryBtn">내가 쓴 게시글</button></a>
                    <a href="myPageInquiryReply.do"><button type="menu" id="inquiryBtn">내가 쓴 댓글</button></a>
                </div>

                <br>
                
                <h6>댓글 조회 결과</h6>

                <div id="resultDiv">
                    <table class="table table-hover table-striped text-center" id="result">
                        <thead>
                            <tr>
                                <th>글 번호</th>
                                <th>글 제목</th>
                                <th>댓글 내용</th>
                                <th>작성일</th>
                            </tr>
                        </thead>

                        <tr>
                            <td>1</td>
                            <th>서울 쪽 반려견과 함께 갈 수 있는 숙소 추천 해주세요.</th>
                            <td>저는 @@호텔 좋았어요 ^ㅅ^</td>
                            <td>2021-01-13</td>
                        </tr>
                    </table>
                </div>

                <div class="paging">
                    <nav aria-label="Page navigation example">
                        <ul id="pagingBtn" class="pagination pagination-sm justify-content-center">
                          <li class="page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">&lt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">4</a></li>
                          <li class="page-item"><a class="page-link" href="#">5</a></li>
                          <li class="page-item"><a class="page-link" href="#">6</a></li>
                          <li class="page-item"><a class="page-link" href="#">7</a></li>
                          <li class="page-item"><a class="page-link" href="#">8</a></li>
                          <li class="page-item"><a class="page-link" href="#">9</a></li>
                          <li class="page-item"><a class="page-link" href="#">10</a></li>
                          <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
                        </ul>
                      </nav>
                    </div>

                <div class="search">
                    <form action="${contextPath}/search.do" method="GET" class="text-center" id="searchForm">
                        <select name="sk" class="form-control" style="width: 100px; display: inline-block;">
                            <option value="title">글제목</option>
                            <option value="content">내용</option>
                            <option value="titcont">제목+내용</option>
                            <option value="writer">작성자</option>
                        </select>

                        <input type="text" name="sv" class="form-control" style="width: 25%; display: inline-block;">
                        <button id="searchBtn" style="width: 100px; display: inline-block;">검색</button>
                    </form>
    
    
                </div>

</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>






</body>
</html>