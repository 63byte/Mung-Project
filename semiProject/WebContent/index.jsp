<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>

<!-- 카카오 지도 API  -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0195b24c7dce0dc71f3dbcf7ca0a12c4"></script>


    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">


    <style>
        *{
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500; /* 굵기 지정(100, 300, 400, 500, 700) */
            font-size: 16px;
            color: #212529;
            box-sizing: border-box;
            margin: 0;
        }



        #main{
            width:1100px;
            display: block;
            margin: auto;
        }

        .big-title{
            font-size: 30px;
            font-weight: 800;
            padding-top: 25px;
        }

        .big-banner{
            display: block;
            margin:auto; /* 가운데 정렬 */
            background-color: #F5F6F8;
            margin-top:20px;
            width:1100px;
            height:362px;
        }

        /* -------------------------------------- */

        .semi-title{
            font-size: 20px;
            font-weight: 700;
            padding-top: 30px;
            padding-bottom: 15px;
        }

        .semi-banner{
            display: flex;
            padding-bottom: 50px;
        }

        .semi-banner2{ margin-left: 25px; }
        .semi-banner3{ margin-left: 25px; }

        .semi-banner-img-area{
            display:inline-block;
            background-color: #F5F6F8;
            width:350px;
            height:250px;
            margin : 5px;;
        }
        
        .thumbnail_img{
      	    width:350px;
            height:250px;
        }

        .semi-text1{
            font-weight: 700;
            margin:5px;
            margin-left : 10px;
        }

        .semi-text2{
            font-weight: 400;
             margin:5px;
            margin-left : 10px;
        }



    </style>
</head>

<body>
	<jsp:include page="WEB-INF/views/common/mainHeader.jsp"></jsp:include>
  <div id="main">

      <div id="big">
          <div class="big-title">
              뭉개뭉개와 함께 어디로 갈까요? 🐶
          </div>
          <div class="big-banner">
              big-banner
          </div>
      </div>

      <div id="sub">      
          <div class="semi-title">인기 숙소</div>
          <div>
              <div class="semi-banner">
              	<c:choose>
              		<c:when test="${!empty roomList }">
              			<c:forEach var="room" items="${roomList }">
              			
	              			<div class="semi-banner1">
	              				
	              				<c:forEach var="thumbnail" items="${fList }">
	              					<c:if test="${room.roomNo == thumbnail.roomNo }">
			                     		 <div class="semi-banner-img-area">
			                     		 	<img class="thumbnail_img" src="${contextPath}/resources/image/uploadRoomImages/${thumbnail.fileName}">
			                     		 </div>
	              					</c:if>
	              				</c:forEach>
			                      <div class="semi-text1 numberSelect" style="cursor: pointer;">${room.roomName }</div>
			                      <div class="semi-text2 numberSelect" style="cursor: pointer;">${room.location2 }</div>
			                      <span style="visibility:hidden">${room.roomNo }</span>
			                  </div>	
              			</c:forEach>
              		</c:when>
              	</c:choose>
              </div>
    	  </div>
      </div>

  </div>
  <jsp:include page="WEB-INF/views/common/footer.jsp"></jsp:include>
  
<script>
//숙소 상세조회
$(".numberSelect").on("click", function(){
	var roomNo = $(this).siblings("span").text();
	
	var url = "${contextPath}/room/view?cp=${pInfo.currentPage}&roomNo="+ roomNo;
	
	location.href=url;
});
</script>

</body>

</html>