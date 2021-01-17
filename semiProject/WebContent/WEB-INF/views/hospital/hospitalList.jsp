<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물병원</title>

<!-- css연결  -->
<link rel="stylesheet" href="${contextPath}/resources/css/hospital/hospitalList.css" type="text/css">



<!-- 부트스트랩 사용을 위한 css 추가 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
    integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<!-- 부트스트랩 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
    crossorigin="anonymous"></script>


</head>
<body>
		<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
		    <div class="wrapper">


            <!-- 검색창 -->
            
            <div class="row-item">
            	<div class="bg-image-full" style="background-image: url('https://cdn.pixabay.com/photo/2016/01/19/17/41/friends-1149841_960_720.jpg');" >
            	  <form action="${contextPath }/search" method="GET" id="searchForm">
                    <div class="search">
                        <input type="text" name="sv" class="searchBar" placeholder="검색어를 입력해 주세요.">
                        <button class="btn_class" id="searchBtn">
                            <img src="${contextPath}/resources/image/icon/searchIcon.png" id="searchIcon">
                            <!-- <span></span> -->
                        </button>
                    </div>
                </form>  
            	</div>
            </div>
            
            <!-- 지역 선택/옵션 -->
            
            <div class="row-item">
                <div class="locationSelect">
	              <form>
                    <span style="font-size:16px; font-weight:bold;">대한민국 ></span>
		                    <select class="locationNm" name="sk">
		                        <option value="강원도">강원도</option>
		                        <option value="경기도">경기도</option>
		                        <option value="경상도">경상도</option>
		                        <option value="광주">광주</option>
		                        <option value="대구">대구</option>
		                        <option value="대전">대전</option>
		                        <option value="부산">부산</option>
		                        <option value="서울" selected>서울</option>
		                        <option value="세종">세종</option>
		                        <option value="울산">울산</option>
		                        <option value="인천">인천</option>
		                        <option value="전라도">전라도</option>
		                        <option value="제주">제주</option>
		                        <option value="충청도">충청도</option>
		                    </select>
	               </form>
                </div>
            </div>
            
           
           <!-- 동물 병원 리스트 -->
           
           <c:choose>
           		<c:when test="${empty hList }">
           		<!-- hList가 비어있을 때 : 게시글 목록 조회에서 조회되지 않았을 때  -->
           			<div style="text-align:center; font-size: 18px;">존재하는 게시글이 없습니다.</div>
           		
           		</c:when>
           
           		<c:otherwise>	<!-- 조회된 게시글 목록이 있을 때  -->
           			 <c:forEach var="hospital" items="${hList }"><!-- hList에서 하나씩 꺼내와 hospital에 담는다.  -->
				            <div class="row-item">
				                <div class="thumbnail">
				                    <div class="thumbnail_img">
				                        <a href="#"><!-- 해당 동물병원 상세페이지로 이동.  -->
				                        <!-- 썸네일 출력  -->
				                            <img class="hospital_img" src="#">
				                        </a>
				                    </div>
				                    <div class="thumbnail_info">
				                      <div class="hospital_info"><a id="hospital_name" href="#"> ${hospital.hospNm }</a></div>
				                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : ${hospital.location2 }</div>
				                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : ${hospital.phone }</div>
				                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : ${hospital.openingTime } ~ ${hospital.closingTime }</div>
				                    </div>
				                </div>
				            </div>
           			 </c:forEach>
           		</c:otherwise>
            </c:choose>
            <!-- 한 페이지 6개씩 보이기 -->



			<!-- 등록하기 버튼  (관리자로 로그인 했을 때만 보인다.-->
			<c:if test="${loginMember.memberAdmin == 'A' }">
	            <div class="row-item">
	                <button type="button" class= "btn_class"  id="insertHospital" onclick="location.href = '${contextPath}/hospital/insertForm'">등록하기</button>
	            </div>
			</c:if>
			
			
			
			
            
            <!-- 페이징 -->
            <div class="paging">
                <nav aria-label="Page navigation example">
                    <ul id="pagingBtn" class="pagination pagination-sm justify-content-center">
                    
               <%-- 현재 페이지가 10페이지 초과인 경우 --%>
               <c:if test="${pInfo.currentPage>10}">
                  <!-- 첫 페이지로 이동(<<) -->
                  <li class="page-item"><a class="page-link" href="${firstPage}">&lt;&lt;</a></li>
                  
                  <!-- 이전 페이지로 이동(<)  -->
                  <li class="page-item"><a class="page-link" href="${prevPage}">&lt;</a></li>
               </c:if>
               
               <!-- 페이지 목록  -->
               <c:forEach var="page" begin="${pInfo.startPage}" end="${pInfo.endPage}">
               		<c:choose> 
               			<c:when test="${pInfo.currentPage == page }">
								<!-- 현재 보고 있는 페이지는 클릭이 안 되게 한다.  -->               								
		                      <li class="page-item"><a class="page-link">${page }</a></li>
               			</c:when>
               			
               			<c:otherwise>
		                      <li class="page-item"><a class="page-link" href="${pageUrl }?cp=${page}${searchStr}">${page }</a></li>
               			</c:otherwise>
               		</c:choose>
               </c:forEach>       
               
               <%-- 다음 페이지가 마지막 페이지 이하인 경우 --%>
               <c:if test="${next <= pInfo.maxPage }">
               		  <!-- 다음 페이지로 이동  -->
                      <li class="page-item"><a class="page-link" href="${nextPage }">&gt;</a></li>
                      <li class="page-item"><a class="page-link" href="${lastPage }">&gt;&gt;</a></li>
               </c:if>
                    </ul>
                  </nav>
                </div>
    </div>
		
		 <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>