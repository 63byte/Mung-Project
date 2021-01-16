<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            	  <form action="#" method="GET" id="searchForm">
                    <div class="search">
                        <input type="text" name="" class="searchBar" placeholder="검색어를 입력해 주세요.">
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
                    <span style="font-size:16px; font-weight:bold;">대한민국 ></span>
                    <select class="locationNm" name="location">
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
                </div>
            </div>
            
           
           <!-- 동물 병원 리스트 -->
            <div class="row-item">
                <div class="thumbnail">
                    <div class="thumbnail_img">
                        <a href="#">
                            <img class="hospital_img" src="${contextPath}/resources/image/hospital/seoul/dana.jpg">
                        </a>
                    </div>
                    <div class="thumbnail_info">
                      <div class="hospital_info"><a id="hospital_name" href="#"> 다나 동물병원</a></div>
                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : 사당동 1019-54</div>
                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : 02-3471-0375</div>
                      <div class="hospital_info" ><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : 10:00 ~ 20:00</div>
                    </div>
                </div>
            </div>

            <div class="row-item">
                <div class="thumbnail">
                    <div class="thumbnail_img">
                        <a href="#">
                            <img class="hospital_img" src="${contextPath}/resources/image/hospital/seoul/goodpapa.jpg">
                        </a>
                    </div>
                    <div class="thumbnail_info">
                      <div class="hospital_info"><a id="hospital_name" href="#">굿파파 24시 반려동물건강검진센터</a></div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : 서울 동작구 사당로 289 사당의원</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : 02-593-8275</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : 00:00 ~ 24:00</div>
                    </div>
                </div>
            </div>

            <div class="row-item">
                <div class="thumbnail">
                    <div class="thumbnail_img">
                        <a href="#">
                            <img class="hospital_img" src="${contextPath}/resources/image/hospital/seoul/naeul.jpg">
                        </a>
                    </div>
                    <div class="thumbnail_info">
                      <div class="hospital_info"><a id="hospital_name" href="#">나을동물병원</a></div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : 서울 동작구 사당로 196 거묵프리미엄상가 1층</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : 02-521-5775</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : 10:00 ~ 19:00</div>
                    </div>
                </div>
            </div>

            <div class="row-item">
                <div class="thumbnail">
                    <div class="thumbnail_img">
                        <a href="#">
                            <img class="hospital_img" src="${contextPath}/resources/image/hospital/seoul/myfriend.jpg">
                        </a>
                    </div>
                    <div class="thumbnail_info">
                      <div class="hospital_info"><a id="hospital_name" href="#">동물은 내친구</a></div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : 서울 동작구 사당로 252</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : 02-582-7708</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : 10:00 ~ 19:00</div>
                    </div>
                </div>
            </div>

            <div class="row-item">
                <div class="thumbnail">
                    <div class="thumbnail_img">
                        <a href="#">
                            <img class="hospital_img" src="${contextPath}/resources/image/hospital/seoul/lojan.jpg">
                        </a>
                    </div>
                    <div class="thumbnail_info">
                      <div class="hospital_info"><a id="hospital_name" href="#">로잔동물의료센터</a></div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/site.png">주소 : 서울 관악구 관악로29길 3</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/phone.png">연락처 : 02-872-7588</div>
                       <div class="hospital_info"><img class="icon" src="${contextPath}/resources/image/icon/clock.png">영업시간 : 10:00 ~ 20:00</div>
                    </div>
                </div>
            </div>
            <!-- 한 페이지 5개씩 보이기 -->



						<!-- 등록하기 버튼  -->
            <div class="row-item">
                <button type="button" class= "btn_class"  id="insertRoom" onclick="location.href = '${contextPath}/room/insertForm'">등록하기</button>
            </div>
            
            <!-- 페이징 -->
            <div class="paging">
                <nav aria-label="Page navigation example">
                    <ul id="pagingBtn" class="pagination pagination-sm justify-content-center">
                      <li class="page-item"><a class="page-link" href="#">Previous</a></li>
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
                      <li class="page-item"><a class="page-link" href="#">Next</a></li>
                    </ul>
                  </nav>
                </div>
            
            
    </div>
		
		 <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>