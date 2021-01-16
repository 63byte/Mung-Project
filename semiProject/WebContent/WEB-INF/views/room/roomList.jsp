<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 리스트</title>

<!-- css연결  -->
<link rel="stylesheet" href="${contextPath}/resources/css/room/roomList.css" type="text/css">



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
            <div class="bg-image-full" style="background-image: url('https://t1.daumcdn.net/liveboard/modetour/ce1ed892f7e4419e86dd3228d8a6faf2.JPG');" >
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

    <!-- 숙소 리스트 -->

        <div class="row-item">
            <table id="list">
              <tr>
                  <td>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/bookhansan.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">서울 북한산 럭셔리 카라반&수영장</p>
                            </div>
                            <div class="address_area">
                                <p class="address">서울 은평구 진관동 326-1</p>
                            </div>
                       </div>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/adam.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">아담한옥</p>
                            </div>
                            <div class="address_area">
                                <p class="address">서울 종로구 필운대로6길 21</p>
                            </div>
                       </div>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/dalbit.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">달빛애견글램핑 럭셔리수영장</p>
                            </div>
                            <div class="address_area">
                                <p class="address">경기 포천시 일동면 사기막길 67-6</p>
                            </div>
                       </div>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/bookhansan.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">서울 북한산 럭셔리 카라반&수영장</p>
                            </div>
                            <div class="address_area">
                                <p class="address">서울 은평구 진관동 326-1</p>
                            </div>
                       </div>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/bookhansan.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">서울 북한산 럭셔리 카라반&수영장</p>
                            </div>
                            <div class="address_area">
                                <p class="address">서울 은평구 진관동 326-1</p>
                            </div>
                       </div>
                      <div class="roomList">
                          <div class="thumbnail_area">
                              <img class="thumbnail_img" src="${contextPath}/resources/image/room/seoul/bookhansan.jpg"></img>
                            </div>
                            <div class="title_area">
                                <p class="title">서울 북한산 럭셔리 카라반&수영장</p>
                            </div>
                            <div class="address_area">
                                <p class="address">서울 은평구 진관동 326-1</p>
                            </div>
                       </div>
                  </td>
              </tr>  
            </table>
        </div>


        <!-- 등록하기 버튼  -->
        <div class="row-item">
            <button type="button" class= "btn_class"  id="insertRoom" onclick="#;">등록하기</button>
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
            
    </div> <!-- WRAPPER -->






<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>
</html>