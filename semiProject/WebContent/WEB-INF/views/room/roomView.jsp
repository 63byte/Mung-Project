<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 상세조회</title>
</head>
<body>
		<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
		
		<!-- 숙소 상세조회  -->
    <div class="wrapper">

        <!-- 이미지 출력 -->
        <div class="imageArea">
            <img class="imageArea" src="">
        </div>
    
        <!-- 숙소 이름 -->
        <div class="row-item" >
            <p id="roomName">숙소 이름</p>
        </div> 

        <!-- 조회수/좋아요 -->
        <div class="row-item">
            <div class="viewInfo iconArea">
                <span><img src="${contextPath}/resources/image/icon/view.png" class="icon"></span>
                <div class="count">0</div><!-- 최대 999,999 -->
            </div>
            <div class="viewInfo">
                <button type="button" class="like"><img src="${contextPath}/resources/image/icon/like/png" class="icon"></button>
                <div class="count">0</div><!-- 최대 999,999 -->
            </div>    
        </div>

        <!-- 숙소 주소 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/site.png"></span>
            <span id="roomAddress">숙소 주소 : </span>
        </div> 
    
        <!-- 숙소 전화번호 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/phone.png"></span>
            <span id="roomPhone">전화번호 : </span>
        </div> 

        <!-- 숙소 체크인/체크아웃시간 -->
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/clock.png"></span>
            <span id="roomCheckIn">체크인 : </span>
        </div> 
        <div class="row-item" >
            <span><img class="icon" src="${contextPath}/resources/image/icon/clock.png"></span>
            <span id="roomCheckOut">체크아웃 : </span>
        </div> 
        
        <div class="row-item">
            <span><img class="icon" src="${contextPath}/resources/image/icon/clock.png"></span>
            <span id="roomCheckIn">출입가능 견종 : </span>
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
                    주차장
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/appointment.png">
                </div>
                <div class="text_area"> 
                    수영장
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/business-trip.png">
                </div>
                <div class="text_area"> 
                    바베큐
                </div>
            </div>
            <div class="facility">
                <div class="icon_area">
                    <img class="facility_icon" src="${contextPath}/resources/image/icon/24hour.png">
                </div>
                <div class="text_area"> 
                    마당
                </div>
            </div>
        </div>





        <hr style="margin-bottom: 15px;">

        <div class="row-item" >
            <p style="font-size:13px; margin-bottom: 15px;">숙소 정보</p>
            <div style="font-size:15px;">
                해운대 조망의 파라다이스 호텔 부산은 해운대 해수욕장 바로 앞에 있습니다. 지하철 이용 시, 부산 2호선 해운대역 3번 출구에서 도보로 약 10분 걸립니다. 주변 명소인 누리마루APEC하우스는 차로 약 5분 거리에 있습니다. 또한, 해동 용궁사까지는 차로 약 20분이 소요됩니다. 야외에는 '오션 스파 씨메르'가 있으며 많은 노천탕과 어린이 놀이 공간도 있어 온 가족이 즐기시기에 좋습니다. 
                또한, 인피니티 풀장에서도 시간을 보낼 수 있습니다. 
                실내에는 옥돌 베드, 자쿠지탕, 건식 및 습식 공간을 갖춘 사우나가 있으며, 
                피트니스 클럽과 실내 골프장도 마련되어 있습니다. 
                '리트리트 스파'에서는 천연 성분을 함유한 브랜드 순다리를 사용합니다. 
                자녀와 즐길 수 있는 '키즈 빌리지'에는 BMW 키즈 드라이빙, 
                플레이스테이션, 하바 키즈 라운지, 웅진 북클럽 및 가족형 키즈카페 
                '키즈앤 패밀리'로 구성되어 여러 체험을 할 수 있습니다. 
                이외에도 인원에 따라 예식과 연회를 진행 할 수 있는 컨벤션 시설도 갖춰져 있습니다. 
                신관 1층에서 3층까지 위치한 카지노에서는 다양한 게임 체험할 수 있습니다. 
                객실은 디럭스, 프리미엄 디럭스, 스위트와 스페셜 스위트로 구성되어 있습니다. 
                전 객실에는 에어컨, TV, 소파, 테이블, 냉장고 금고, 커피/티 메이커, 
                생수 등이 있으며 욕실에는 욕실용품, 가운 및 헤어드라이어 등이 완비되어 있습니다. 
                '온 더 플레이트'는 올데이 뷔페 식사를 제공합니다. 유러피안 레스토랑인 '닉스 그릴닉스그릴'에서는 이탈리안, 프렌치, 아메리칸 등의 색다른 요리를 드실 수 있습니다. 
                중식당인 '남풍'에서는 각종 모임 식사를 할 수 있는 여러 규모의 다이닝 룸이 마련되어 있어 다 같이 음식을 즐길 수 있습니다. 
                일식당 '사까에'에서는 신선한 재료의 음식을 맛 볼 수 있습니다. 로비에는 '크리스탈 가든'에서는 통유리 창을 통해 탁 트인 전경을 감상하며 다양한 음료 또는 칵테일을 마실 수 있습니다. '찰리스' 바에서는 간단한 스낵과 함께 주류를 드시며 일과를 마무리 할 수 있습니다. 
                야외의 '아쿠아 바'와 '풀 사이드풀사이드 바'에서는 스파와 물놀이 후에 간단한 음식과 음료로 노곤함을 떨쳐버릴 수 있습니다. 
                다양한 디저트와 빵이 진열된 베이커리도 있어 들려보시기에 좋습니다. 
                '이그제큐티브 라운지' 에서는 라이브러리, 다이닝, 컨퍼런스의 세 공간으로 구성되어 있으며 특별한 서비스를 느낄 수 있습니다. 
                '라운지 파라다이스'에서는 온종일 스낵과 음료와 함께 휴식을 취할 수 있습니다.
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
                <button class= "btn_class"  id="updateBtn" type="button">수정</button>
                <button class= "btn_class"  id="deleteBtn" type="button">삭제</button>
            </div>
        </div>


    </div><!-- wrapper -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
    
</body>
</html>
