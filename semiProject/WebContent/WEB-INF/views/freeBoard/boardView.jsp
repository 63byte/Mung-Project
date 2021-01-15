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
	.imgdiv{
		height: 300px;
		
	}
	
		.boardImg{
		width : 100%;
		height: 100%;
		
		max-width : 500px;
		max-height: 300px;
		
		display: block;
		
		margin-left : auto;
		margin-right : auto;
	}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

<div class="container  my-5">
	<div>
		<div id="board-area">
			<!-- Title -->
				<h3 class="mt-4 display-3">${board.boardTitle }</h3>		
				
				<p class="lead">
					작성자 : ${board.memberId }
				</p>
				
				<hr>
				
				<p>
					<span class="board-dateArea">
						작성일 : <fmt:formatDate value="${board.boardCreateDate}" pattern="yyyy년 MM월 dd일 HH:mm:ss" />
					</span>
					<span class="float-right">조회수 ${board.readCount }</span>
				</p>
		
		
				<hr>
				
				<c:if test="${!empty fList }">
					<c:forEach var="file" items="${fList}">
						<div class="imgdiv">
							<img class="boardImg" id="${file.fileNo}"
								src="${contextPath}/resources/uploadImages/${file.fileName}">
					</div>
					</c:forEach>
				
				</c:if>
				
				
				
				<div id="board-content">${board.boardContent }</div>
				
				<div>
				
				
				
				<c:if test="${!empty loginMember && (board.memberId == loginMember.memberId) }">
						<button id="deleteBtn" class="btn btn-info float-right">삭제</button>
				
						<a href="updateForm.do?cp=${param.cp}&no=${param.no}${searchStr}" class="btn btn-info float-right ml-1 mr-1">수정</a>
				</c:if>
				
				</div>
				<c:choose>
						<c:when test="${!empty param.sk && !empty param.sv }">
							<c:url var="goToList" value="../search.do">
								<c:param name="cp">${param.cp}</c:param>
								<c:param name="sk">${param.sk}</c:param>
								<c:param name="sv">${param.sv}</c:param>
							</c:url>
						</c:when>
						
						<c:otherwise>
							<c:url var="goToList" value="freeList.do">
								<c:param name="cp">${param.cp}</c:param>
							</c:url>
						</c:otherwise>
					</c:choose>
					
					
					<a href="${goToList}" class="btn btn-info float-right">목록으로</a>
				
		</div>
	</div>
</div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

		<script>
			$("#deleteBtn").on("click", function(){
			
			if(window.confirm("정말 삭제하시겠습니까?")){
				location.href = "delete.do?no=${board.boardNo}";
				
			}
			
		});
		</script>
</body>
</html>