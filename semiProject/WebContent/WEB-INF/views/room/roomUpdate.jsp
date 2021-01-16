<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>숙소 수정</title>

<!-- css연결  -->
<link rel="stylesheet" href="${contextPath}/resources/css/room/roomUpdate.css" type="text/css">

</head>
<body>
<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

<!-- 숙소 등록하기 -->
    <div class="wrapper">
        <div class="main">

            <div class="row-item">
                <div id="page_name">숙소 등록</div>
                <hr id="hr_tag">
            </div>


            <div class="insert_room">
                <form action="#" method="post" onsubmit="return roomInserValidate();">
                    
                    <div class="row-item">
                        <div class="label_name">
                            <label for="location1">지역</label>
                        </div>
                        <div class="input_tag">
                            <select class="full_input" id="location1" name="" required>
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


                    <div class="row-item">
                        <div class="label_name">
                            <label for="companyName">숙소명</label>
                        </div>
                        <div class="input_tag">
                                XXX 숙소
                        </div>
                    </div>


                    <div class="row-item">
                        <div class="label_name">
                            <label for="phone">전화번호</label>
                        </div>
                        <div class="input_tag">
                            <select class="phone" id="phone1" name="" required> 
                                <option>02</option>
                                <option>051</option>
                                <option>053</option>
                                <option>032</option>
                                <option>062</option>
                                <option>042</option>
                                <option>052</option>
                                <option>044</option>
                                <option>031</option>
                                <option>033</option>
                                <option>043</option>
                                <option>041</option>
                                <option>063</option>
                                <option>061</option>
                                <option>054</option>
                                <option>055</option>
                                <option>064</option>
                                <option>070</option>
                            </select>
                            &nbsp;-&nbsp;&nbsp;
                            <input type="number" class="phone" id="phone2" name="" required>
                            &nbsp;-&nbsp;
                            <input type="number" class="phone" id="phone3" name="" required>
                        </div>
                    </div>


                    <div class="row-item">
                        <div class="label_name">
                            <label for="location2">상세주소</label>
                        </div>
                        <div class="input_tag">
                            <input type="text" class="full_input" id="location2" name="" autocomplete="off" required>
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name">
                            <label for="checkIn">체크인/체크아웃</label>
                        </div>
                        <div class="input_tag">
                            <input type="text" class="checkHours" id="checkIn" name=""  autocomplete="off" required>
                            &nbsp;/
                            <input type="text" class="checkHours" id="checkOut" name=""  autocomplete="off" required>
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name">
                            <label for="facility">숙소 부대 시설</label>
                        </div>
                        <div class="input_tag">
                           <input type="checkbox" class="facility" name="" value="wifi">WiFi
                           <input type="checkbox" class="facility" name="" value="parking">주차장
                           <input type="checkbox" class="facility" name="" value="pool">수영장
                           <input type="checkbox" class="facility" name="" value="BBQ">바베큐
                           <input type="checkbox" class="facility" name="" value="yard">마당
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name">
                            <label for="dog">출입 가능 견종</label>
                        </div>
                        <div class="input_tag">
                           <input type="checkbox" class="dog" name="" value="small">소형견
                           <input type="checkbox" class="dog" name="" value="medium">중형견
                           <input type="checkbox" class="dog" name="" value="large">대형견
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name">
                            <label for="file">이미지 업로드</label>
                        </div>
                        <div class="input_tag filebox ">
                            <label for="file">업로드</label>
                            <input type="file" id="file">
                            <input class="file-upload-name" value="파일경로..">
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name" style="vertical-align:80px;" >
                            <label for="room_info" >숙소 상세 정보</label>
                        </div>
                        <div class="input_tag">
                            <textarea class="full_input room_info" id="room_info" rows="10"></textarea>
                        </div>
                    </div>

                    <!-- 수정 / 취소 버튼  -->
                    <div class="row-item">
                        <div class="btn_item">
                            <button class= "btn_class"  id="updateBtn" type="submit">수정</button>
                            <button class= "btn_class"  id="resetBtn" type="reset">취소</button>
                        </div>
                    </div>
                </form>

            </div>

        </div>

    </div><!-- wrapper -->
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>
</html>