<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NoticeCenter</title>
<!-- 부트스트랩을 사용을 위한 css 추가 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- 부트스트랩 사용을 위한 라이브러리 추가 -->
<!-- jquery가 항상 먼저여야된다! -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
</head>
<style>
#bbbb {
	float: left;
	height: 1000px;
	width: 200px;
}

#aa {
	float: left;
	height: 1000px;
	width: 900px;
/* 	text-align:center;
 */}

#aaaaa {
	width: 1100px;
	height: 1000px;
	margin: 0px auto;
}

ul>li {
	list-style: none;
	line-height: 50px;
/* 	margin-top: 3px;
 */}

.pagination {
	justify-content: center;
}


table {
	/* 	text-align: center;
	margin: auto; */
/* 	margin-top: 55px;
 */}

#uls {
	margin-top: 30px;
	
}
#uls > li{
	 line-height : 80px;
}
.pagination  a{
	color :black;
	
}
a{
  color:black;
}

</style>
<body>

	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
	<div id="aaaaa">
		<div id="bbbb">
			<ul id="uls">
		        <li><a href="${contextPath}/notice/notice.do">공지사항</a></li>
				<li><a href="${contextPath}/faq/faq.do">자주묻는질문</a></li>
				<li><a href="${contextPath}/qna/qna.do">Q&A</a></li>
			</ul>
		</div>
		<div class='content' id="aa">
 				<h2 style="text-align:center; margin-top:10px;">Q&A</h2>
 	
 			<form>	
 			<table class="table" id="list-Table">
				<thead class="" style="background-color:#8ad2d5;">
					<tr>
						<th scope="col" width="50px;" style="text-align:center; color:white; ">번호</th>
						<th scope="col" width="500px;" style="text-align:center;color:white;">제목</th>
						<th scope="col" width="20px;" style="color:white;">닉네임</th>
						<th scope="col" width="20px;"  style="color:white;">작성일</th>
						<th scope="col"width="20px;"  style="color:white;">조회</th>
					</tr>
				</thead>
				<tbody>
										<tr>
						<th scope="row" style="text-align:center">1</th>
						<td style="color:gray;">비공개(처리중...)</td>
						<td>Otto</td>
						<td>@mdo</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">2</th>
						<td style="color:gray;">비공개(답변완료)</td>
						<td>Thornton</td>
						<td>@fat</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">3</th>
						<td style="color:gray;">(처리중...)</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">4</th>
						<td style="color:gray;">(답변완료)</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">5</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">6</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">7</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">8</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">9</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
					<tr>
						<th scope="row" style="text-align:center">10</th>
						<td>Larry</td>
						<td>the Bird</td>
						<td>@twitter</td>
						<td>aaa</td>
					</tr>
				</tbody>
			</table>
			</form>
			<div style="text-align: right;" id="insertBtn">
				<input type="button" class="btn" value="글쓰기" 
				style=" background-color:#8bd2d5; color:white; border: 3px solid #8bd2d6;
   								 border-radius: 5px;">
			</div>

			<div class="my-5">
				<ul class="pagination">

					<li><a class="page-link">&lt;&lt;</a></li>
					<li><a class="page-link">&lt;</a></li>

					<li><a class="page-link">1</a></li>

					<li><a class="page-link" href="#">2</a></li>
					<li><a class="page-link" href="#">3</a></li>
					<li><a class="page-link" href="#">4</a></li>
					<li><a class="page-link" href="#">5</a></li>
					<li><a class="page-link" href="#">6</a></li>
					<li><a class="page-link" href="#">7</a></li>
					<li><a class="page-link" href="#">8</a></li>
					<li><a class="page-link" href="#">9</a></li>
					<li><a class="page-link" href="#">10</a></li>
					
					<li><a class="page-link" href="#">&gt;</a></li>

					<li><a class="page-link" href="#">&gt;&gt;</a></li>


				</ul>
					<div class="my-5">
						<form action="" method="GET" class="text-center" id="searchForm">
						<select class="form-control  col-md-2" style="display:inline-block; 
   								 border-radius: 5px;">
							  <option>글제목 </option>
							  <option>내용</option>
							  <option>제목+내용</option>
							  <option>작성자</option>
						</select>
							<input type="text" name="sv" class="form-control"
								style="width: 350px;  border: 3px solid #8bd2d6;
   								 border-radius: 5px; display: inline-block;">
							<button class="form-control"
								style="width: 100px; display: inline-block; background-color:#8bd2d6; color:white;margin-bottom: 5px;">검색</button>
						</form>


					</div>


			</div>



		</div>

	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>



</body>
 <script>
	
	$("#list-Table td").on("click",function(){
		
		
		var url = "${contextPath}/qna/qnaView.do";
		
		location.href = url;
		
		
	});
	
	$("#insertBtn > input").on("click",function(){
		
		
		var url = "${contextPath}/qna/qnaInsert.do";
		
		location.href = url;
		
		
	});
 
 
 
 </script>
</html>