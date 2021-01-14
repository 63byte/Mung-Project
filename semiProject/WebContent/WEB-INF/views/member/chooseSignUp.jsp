<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>

    <!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
   
   <style>
         html,body {height:100%; margin:0; padding:0; background : #8ad2d5;}
         #contents {min-height:100%;}
         /* 위의 부분이 div를 화면에 꽉 차게 만들어 주는 스타일 */
        
        *{
            font-family: 'Noto Sans KR', sans-serif;
            /* font-weight: 100; --> 굵기 지정 */
            font-weight: 500;
            color: #212529;
        }

        #logo {
            width: 300px;
            text-align: center;
            margin: 50px;
        }
        
        #joinDiv {
            text-align: center;
            margin : -70px;
        }

        #userJoin, #companyJoin {
            width: 307px;
            height: 300px;
            margin: 20px;
            border: white;
            background : white;
            color : #46a2a5; 
            border-radius : 10px;
            font-size: 30px;
            border : 1px solid #46a2a5; 
        }

        #cloudDiv{
            position: absolute;
            right:    0;
            bottom:   0;
        }
        
        #userJoin:hover{
            cursor: pointer;
        }
        
        #companyJoin:hover{
        	cursor: pointer;
        }
        
        #logoDiv {
       		display: block;
			margin-left: auto;
			margin-right: auto;
       }
       
       #logo {
       		width : 300px;
  			margin : 110px;
  			margin-left : 810px;
       } 
       
       #userJoin:hover, #companyJoin:hover {
            font-weight: bold;
        }
        
        

    </style>

</head>
<body>
		<a href="${contextPath}">
			<div id="logoDiv">
				<img src="${pageContext.request.contextPath}/resources/image/logo.png" id="logo">
			</div>
		</a>

    <div id="joinDiv">
        <a href="${contextPath}/member/nomalSignUpForm.do"><button type="button" id="userJoin">일반<br>회원가입</button></a>
        <a href="${contextPath}/member/companySignUpForm.do"><button type="button" id="companyJoin">업체<br> 회원가입</button></a>
    </div>

    <div id="cloudDiv">
        <img src="${pageContext.request.contextPath}/resources/image/cloud.png" id="cloud" style='height: 100%; width: 100%; object-fit: contain;'>
    </div>


    

</body>
</html>