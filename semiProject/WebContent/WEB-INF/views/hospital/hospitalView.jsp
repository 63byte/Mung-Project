<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href=${pageContext.request.contextPath}/resources/css/hospital/hospitalView.css" type="text/css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
</head>
<body>
	
	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

	<div class="wrapper">

        <!-- 이미지 출력 -->
        <div class="imageArea">
            <img class="imageArea" src="#">
        </div>
    
        <!-- 동물병원 이름 -->
        <div class="row-item" >
            <p id="hospitalName">${hospital.hospNm }</p>
        </div> 

        <!-- 조회수 -->
        <div class="row-item">
            <div class="viewInfo iconArea">
                <span><img src="${contextPath}/resources/image/icon/view.png" class="icon"></span>
                <div class="count">${hospital.viewCount }</div><!-- 최대 999,999 -->
            </div>
        </div>

        <!-- 동물병원 주소 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/site.png"></span>
            <span id="hospitalAddress">${hospital.location2 } </span>
        </div> 
    
        <!-- 동물병원 전화번호 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/phone.png"></span>
            <span id="hospitalPhone">전화번호 : ${hospital.phone } </span>
        </div> 

        <!-- 동물병원 운영시간 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/clock.png"></span>
            <span id="hospitalHours">운영시간 : ${hospital.openingTime }  ~ ${hospital.closingTime }</span>
        </div> 

        <hr>

        <div class="row-item" style="margin:0;">

            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/WiFi.png">
                </div>
                <div class="text_area"> 
                    WiFi
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/park.png">
                </div>
                <div class="text_area"> 
                    주차
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/appointment.png">
                </div>
                <div class="text_area"> 
                    예약
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/business-trip.png">
                </div>
                <div class="text_area"> 
                    출장
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/24hour.png">
                </div>
                <div class="text_area"> 
                    24시
                </div>
            </div>
        </div>
        <hr style="margin-bottom: 15px;">

        <div class="row-item" >
            <p style="font-size:13px; margin-bottom: 15px;">병원 정보</p>
            <div style="font-size:15px;">
	               ${hospital.hospInfo }
            </div>
        </div>
        <hr style="margin-bottom: 15px;">


        <div class="row-item">
            <p>상세위치</p>

            <div class="mapAPI">
                &lt; 지도 API&gt;
            </div>

        </div>


        <!-- 관리자만 보이는 버튼 -->
        <div class="row-item" style="margin-top:50px;">
            <div class="btn_item">
                <button class= "btn_class"  id="backBtn" type="button">돌아가기</button>
                <button class= "btn_class"  id="deleteBtn" type="button">삭제</button>
            </div>
        </div>


    </div><!-- wrapper -->


	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>