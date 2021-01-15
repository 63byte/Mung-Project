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
    .pagination{
       justify-content: center;
    }
    
    .btn-md{
             float: right;
         }
         
    .table-hover td{
    	cursor : pointer;
    }
    
    .container-fluid{
	min-height: 540px;
	
		}
		
		#list-table th {
	text-align: center;
		}

#list-table td:not(:nth-of-type(2)) {
	text-align: center;
		}
		
		#list-table td{
  vertical-align: middle;
  /* vertical-align : inline, inline-block 요소에만 적용 가능(td는 inline-block)*/
	
		}
		
		
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

.th1, .th5{
	width : 10%;
}

.th3, .th4{
	width : 20%
}

.th2 {
	width : 40%
}

/* 메뉴에 마우스 오버 했을 경우 민트색을 변경 */
/* .aside > ul > div > li > a {
    color: #8ad2d5; 
} */

#aside-localInfo{
	color : #8ad2d5;
}

.hit { animation-name: blink; animation-duration: 1.5s; animation-timing-function: ease; animation-iteration-count: infinite; 
/* 위 속성들을 한 줄로 표기하기 */ /* -webkit-animation: blink 1.5s ease infinite; */ } /* 애니메이션 지점 설정하기 */ /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
 @keyframes blink { from {color: white;} 30% {color: yellow;} to {color: red; font-weight: bold;} /* 0% {color:white;} 30% {color: yellow;} 100% {color:red; font-weight: bold;} */ }




		
		
</style>

</head>
<body>

		<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
	<div class="container my-5">
<div class="wrap-1">
		<div id="container">
        <div class="aside">
            
            <ul>
                <div class="side-div-1"><li><a href="${contextPath}/freeBoard/freeList.do" class="aside-items" id="aside-localInfo">자유 게시판</a></li></div>
               <div class="side-div-2"><li><a href="${contextPath}/tripBoard/tripList.do" class="aside-items" id="aside-touristSpot">여행 후기 게시판</a></li></div>
            </ul>
        </div>
		

<div class="container-fluid container my-5">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-hover table-striped my-5"  id="list-table">
				<thead>
					<tr>
						<th class="th1">
							글번호
						</th>
						<th class="th2">
							제목
						</th>
						<th class="th3">
							닉네임
						</th>
						<th class="th4">
							작성일
						</th>
						<th class="th5">
							조회수
						</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty bList }">
								<tr>
									<td colspan="5">존재하는 게시글이 없습니다.</td>
								</tr>
							</c:when>
							
							<c:otherwise>
								<c:forEach var="board"  items="${bList}">
									<tr>
										<td>
											${board.boardNo}
											
										</td>
										<td>
													${board.boardTitle}
													<c:if test="${board.readCount >= 20}"><span class="hit">HOT!</span></c:if>
										</td>
										<td>${board.memberId}</td>
										<td>
										 <%-- 날짜 출력 모양 지정 --%>
											<fmt:formatDate var="createDate" value="${board.boardCreateDate}" pattern="yyyy-MM-dd"/>
											<fmt:formatDate var="today" value="<%= new java.util.Date() %>" pattern="yyyy-MM-dd"/>
										
											<c:choose>
												<%-- 글 작성일이 오늘이 아닐 경우 --%>
												<c:when test="${createDate != today}">
													${createDate}
												</c:when>
												
												<%-- 글 작성일이 오늘일 경우 --%>
												<c:otherwise>
													<fmt:formatDate value="${board.boardCreateDate}" pattern="HH:mm"/>
												</c:otherwise>
											</c:choose>
										</td>
										<td>
											${board.readCount}	
											</td>
										
									
									
									</tr>
								
								</c:forEach>
							</c:otherwise>
					</c:choose>

				</tbody>
			</table>
			
			<c:choose>
				<%-- 검색 내용이 파라미터에 존재할 때 == 검색을 통해 만들어진 페이지인가? --%>
				<c:when test="${!empty param.sk && !empty param.sv }">
					<c:url var="pageUrl" value="/search.do"/>
					
					<%-- 쿼리스트링으로 사용할 내용을 변수에 저장 --%>
					<c:set var="searchStr" value="&sk=${param.sk}&sv=${param.sv}" />
				</c:when>
				
				<c:otherwise>
					<c:url var="pageUrl" value="/freeBoard/freeList.do"/>
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
			
			
			<div class="my-5">
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
			
				<div class="my-5">
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
</div>
</div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    
    
<script>
	// 게시글 상세보기 기능 (jquery를 통해 작업)
	$("#list-table td").on("click", function(){
		
		// 게시글 번호 얻어오기
		var boardNo = $(this).parent().children().eq(0).text();
		
		var url = "${contextPath}/freeBoard/view.do?cp=${pInfo.currentPage}&no=" + boardNo + "${searchStr}";
		
		location.href = url;
		
	});
	
	(function(){
		var searchKey = "${param.sk}";	
		
		var searchValue = "${param.sv}";

		// 검색창 select의 option을 반복 접근
		$("select[name=sk] > option").each(function(index, item){
					
			if( $(item).val() == searchKey ){ 
				$(item).prop("selected", true);
			}
		});

		// 검색어 입력창에 searchValue 값을 출력
		$("input[name=sv]").val(searchValue);
	})()
    
</script>

</body>
</html>