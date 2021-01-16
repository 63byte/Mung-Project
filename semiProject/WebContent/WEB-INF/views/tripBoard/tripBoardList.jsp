<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		*{
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500; /* 굵기 지정(100, 300, 400, 500, 700) */
            font-size: 16px;
            color: #212529;
            box-sizing: border-box;
            margin: 0;
            /* border : 1px solid black;  */
        }

        div{
            /* border : 1px solid black;  */
            box-sizing : border-box;
        }

        .wrapper{
            margin : auto; 
        }


#container{
    width:1100px;
    height:800px;
    display: block;
    margin: auto;

    /* background-color: ghostwhite; */
}

.aside{
    width:200px;
    height:100%;
    float: left;

    border-right: 1px solid #e5e5e5;
}

.aside > ul {
    list-style-type: none; /* 불렛 없음 */
    padding:0;
}

/* 메뉴 위아래 간격 */
.aside > ul > div {
    padding : 50px 0px 30px 0px ;
}

.aside > ul > div > li > a {
    text-decoration: none; /* 불렛 없음 */
    font-weight: 700;
    color: black;

    /* border: 1px solid red; */
}

	p{
		font-size: 12px;
	}
	
	.col-md-3{
		float: left;
		width: 21%;
		margin-bottom : 50px;
	}
	
	

	
/* 	.col-md-3:hover{
		backgroudColor: #17a2b8;
		cursor: pointer;
	}
	 */
/* 메뉴에 마우스 오버 했을 경우 민트색을 변경 */
/* .aside > ul > div > li > a {
    color: #8ad2d5; 
} */

#aside-touristSpot{
	color : #8ad2d5;
}
</style>
</head>
<body>

			<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
<div class="container my-5">
	
	<div class="row my-5">
		<div class="col-md-3">
			  <div class="aside">
            <ul>
                <div class="side-div-1"><li><a href="${contextPath}/freeBoard/freeList.do" class="aside-items" id="aside-localInfo">자유 게시판</a></li></div>
               <div class="side-div-2"><li><a href="${contextPath}/tripBoard/tripList.do" class="aside-items" id="aside-touristSpot">여행 후기 게시판</a></li></div>
            </ul>
        </div>
		</div>
		
		
		<div class="col-md-9 my-5">
		
			<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
        
			<div class="row">
			
			<c:if test="${!empty tList }">
				<c:forEach var="board"  items="${tList}">
				<div class="col-md-3">

						<div class="card" style="width: 11rem;">
					  	<img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						  		<p class="card-text">${board.boardNo}</p>
						    	<p class="card-text">${board.boardTitle} [${board.readCount}] <br> 작성자 : ${board.memberId}<br> ${board.boardCreateDate }</p>
						  </div>
						</div>
					
				</div>
				</c:forEach>
			</c:if>
				
				
				<c:choose>
				<%-- 검색 내용이 파라미터에 존재할 때 == 검색을 통해 만들어진 페이지인가? --%>
				<c:when test="${!empty param.sk && !empty param.sv }">
					<c:url var="pageUrl" value="/search.do"/>
					
					<%-- 쿼리스트링으로 사용할 내용을 변수에 저장 --%>
					<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}" />
				</c:when>
				
				<c:otherwise>
					<c:url var="pageUrl" value="/tripBoard/tripList.do"/>
				</c:otherwise>
				
			</c:choose>
			
			<c:set var="firstPage" value="${pageUrl}?cp=1${searchStr}"/>
			<c:set var="lastPage" value="${pageUrl}?cp=${pInfo.maxPage}${searchStr}"/>
			
			
			<fmt:parseNumber var="c1" value="${(pInfo.currentPage - 1) / 10 }" integerOnly="true" />
			<fmt:parseNumber var="prev" value="${c1 * 10 }" integerOnly="true" />
			<c:set var="prevPage" value="${pageUrl}?cp=${prev}${searchStr}" />
			
			<fmt:parseNumber var="c2" value="${(pInfo.currentPage + 9) /10 }" integerOnly="true" />
			<fmt:parseNumber var="next" value="${ c2 * 10 + 1 }" integerOnly="true" />
			<c:set var="nextPage" value="${pageUrl}?cp=${next}${searchStr}" />
				
				
			<div class="container my-5">
				<ul class="pagination">
				
				<c:if test="${pInfo.currentPage > 10 }">
						<li>	<!-- 첫 페이지로 이동(<<)  -->
							<a class="page-link" href="${firstPage }">&lt;&lt;</a>
						</li>
						<li>	<!-- 이전 페이지로 이동 (<) -->
							<a class="page-link" href="${prevPage }">Previous</a>
						</li>
					</c:if>
					
					
					<c:forEach var="page" begin="${pInfo.startPage }" end="${pInfo.endPage}">
						<c:choose>
							<c:when test="${pInfo.currentPage == page}">
								<li>
									<a class="page-link">${page}</a>
								</li>
							</c:when>
							
							<c:otherwise>
							<li>
								<a class="page-link" href="${pageUrl}?cp=${page}${searchStr}">${page}</a>
							</li>
							</c:otherwise>
											
						</c:choose>
					</c:forEach>
					

					<%-- 다음 페이지가 마지막 페이지 미만인 경우 --%>
					<c:if test="${next <= pInfo.maxPage }">
						<li>	<!-- 다음 페이지로 이동 (>) -->
							<a class="page-link" href="${nextPage }">Next</a>
						</li>
						<li>	<!-- 마지막 페이지로 이동(>>)  -->
							<a class="page-link" href="${lastPage }">&gt;&gt;</a>
						</li>
					</c:if>
				</ul>
			<c:if test="${!empty loginMember}">
				<button type="button" class="btn btn-outline-info btn-md" id="insertBtn" 
					onclick="location.href = '${contextPath}/freeBoard/insertForm.do'">
					글쓰기
				</button>
			</c:if>
				</div>
			
				<div class="container my-5">
				<form action="${contextPath}/search.do" method="GET" class="text-center" id="searchForm">
					<select name="sk" class="form-control" style="width: 100px; display: inline-block;">
						<option value="title">글제목</option>
						<option value="content">내용</option>
						<option value="titcont">제목+내용</option>
						<option value="writer">작성자</option>
					</select>
					<input type="text" name="sv" class="form-control" style="width: 25%; display: inline-block;">
					<button class="form-control btn btn-outline-info" style="width: 100px; display: inline-block;">검색</button>
				</form>


			</div>
	</div>
</div>
</div>
</div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>


<script>
$(".card").on("click", function(){
	
	// 게시글 번호 얻어오기
	var boardNo = $(this).children().children().eq(0).text();
	
	var url = "${contextPath}/tripBoard/tripView.do?cp=${pInfo.currentPage}&no=" + boardNo + "${searchStr}";
	
	location.href = url;
	
});
</script>

</body>
</html>