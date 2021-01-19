<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디,비밀번호 찾기</title>
<!-- 구글 폰트 -->
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">

<style>
* {
	font-family: 'Noto Sans KR', sans-serif;
	/* font-weight: 100; --> 굵기 지정 */
	font-weight: 500;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	background: #8ad2d5;
}


#wrapper {
        width : 1100px;
        height: 500px;
        padding-bottom :5%;
        padding-top: 3%;
        margin : 0 auto;
    }
    
    #logoDiv {
        width: 300px;
        display: block;
        margin : 0 auto;
    }

    /* 아이디,비밀번호 찾기 버튼 & 효과 */
    #btnDiv {
        width: 300px;
        height: 30px;
        margin : 0 auto;
        text-align: center;
        padding : 40px;
    }

    #idBtn, #pwBtn {
        width: 130px;
        height: 40px;
        background-color: #379194;
        border-radius: 10px;
        border: white;
        color: white;
        font-weight: 200;
        
    }

    #idBtn:hover, #pwBtn:hover {
        font-weight: 500;
    }

    /* 찾기 전체 Div */

    #findWrapper {
        border-radius: 10px;
        border: 1px solid white;
        background-color: white;
    }

    /* 찾기 Div 모음 */
    #findDiv1 {
        margin: 30px;
        
    }

    #findDiv2{
        width: 350px;
        height :160px;
        margin : 0 auto;
        text-align: center;
    }

    #findDiv2 > label {
        margin: 3px;
        line-height: 35px;
    }

    #findDiv2 > input, #findDiv2 > button{
        margin: 3px;
        float: right;
    }

    
    /* p 태그 */
    #p1 {
        font-size: 20px;
        font-weight: 700;
        margin: auto;
        text-align: center;
    }

    #p2 {
        font-size: 14px;
        font-weight: normal;
        margin: auto;
        text-align: center;
    }

    /* 이메일 버튼 & 효과 */
    #eCode { 
        border: white;
        background-color:  #379194;
        color: white;
        font-weight: 10;
        border-radius: 5px;
    }

    #eCode:hover {
        font-weight: 500;
    }

    /* 다음 버튼, 구름 이미지 Div*/  

    #changeDiv{
        margin: auto;
        text-align: center;
    }

    #changeBtn {
        width: 65px;
        height: 35px;
        background-color: #379194;
        border-radius: 10px;
        border: white;
        color: white;
        font-weight: 200;
        margin: 30px;
    }

    #changeBtn:hover {
        font-weight: 500;
    }

    #coludDiv{
        position: absolute;
        right: 0;
        bottom: 0;
    }

    #cloudImg {
        margin-top: 100px;
    }
</style>
</head>

<body>


	<div id="wrapper">
        
        <div id="logoDiv">
            <a href="#"><img src="logo2.png" width="300px"></a>
        </div>
        
        <div id="btnDiv">
            <a href="${contextPath}/member/findIdForm"><button id="idBtn">아이디 찾기</button></a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="${contextPath}/member/findPdForm"><button id="pwBtn">비밀번호 찾기</button></a>
        </div>
    
        <div id="findWrapper">
        <div id="findDiv1">
            <p id="p1">본인 확인 완료!</p> 
            <p id="p2">비밀번호 재설정</p>
        </div>

        <div id="findDiv2">
            <label id="pw1">새 비밀번호</label>
            <input type="password" id="input" required>
            <br>

            <label id="pw2">새 비밀번호 확인</label>
            <input type="password" id="input" required>
            
        </div>

        </div>

        <div id="changeDiv">
            <a href="#"><button type="submit" id="changeBtn">변경</button></a>
        </div>
    </div>


    <div id="cloudDiv">
        <img src="${pageContext.request.contextPath}/resources/image/common/cloud.png" id="cloud">
    </div>

</body>
</html>