<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물병원 수정</title>
<!-- css연결  -->
<link rel="stylesheet" href="${contextPath}/resources/css/hospital/hospitalUpdate.css" type="text/css">
</head>
<body>

<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

<!-- 동물병원 수정 -->
<div class="wrapper">

        <div class="main">

            <div class="row-item">
                <div id="page_name">병원 수정</div>
                <hr id="hr_tag">
            </div>
            
            <div class="insert_hospital">
                <form action="#" method="POST" onsubmit="return hospitalUpdatevalidate();">
                    
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
                            <label for="companyName">업체명</label>
                        </div>
                        <div class="input_tag">
                            XXX 동물병원
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
                            <label for="office_hours">영업시간</label>
                        </div>
                        <div class="input_tag">

                            <input type="text" class="office_hours" id="open_hours" name="" autocomplete="off" required>
                            &nbsp;~&nbsp;&nbsp;
                            <input type="text" class="office_hours" id="close_hours" name="" autocomplete="off" required>
                        </div>
                    </div>

                    <div class="row-item">
                        <div class="label_name">
                            <label for="facility">병원 시설</label>
                        </div>
                        <div class="input_tag">
                           <input type="checkbox" class="facility" name="" value="wifi">WiFi
                           <input type="checkbox" class="facility" name="" value="Parking">주차
                           <input type="checkbox" class="facility" name="" value="appointmtnet">예약
                           <input type="checkbox" class="facility" name="" value="businessTrip">출장
                           <input type="checkbox" class="facility" name="" value="fullTime">24시간
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
                            <label for="hospital_info" >동물병원 정보</label>
                        </div>
                        <div class="input_tag">
                            <textarea class="full_input hospital_info" id="hospital_info" rows="10"
                                placeholder="동물병원 소개글을 작성해주세요."></textarea>
                        </div>
                    </div>


                    <!-- 수정 / 취소 버튼  -->
                    <div class="row-item">
                        <div class="btn_item">
                            <button class= "btn_class"  id="insertBtn" type="submit">수정</button>
                            <button class= "btn_class"  id="resetBtn" type="reset">취소</button>
                        </div>
                    </div>
                </form>
	        </div>
	    </div>
	</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

</body>
</html>