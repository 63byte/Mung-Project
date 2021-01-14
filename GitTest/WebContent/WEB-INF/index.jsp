<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
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
        }

        .semi-text1{
            font-weight: 700;
        }

        .semi-text2{
            font-weight: 400;
        }



    </style>
</head>

<body>
	<jsp:include page="WEB-INF/views/common/mainHeader.jsp"></jsp:include>
  <div id="main">

      <div id="big">
          <div class="big-title">
              뭉개뭉개와 함께 어디로 갈까요? 🐶 테스트에요 
          </div>
          <div class="big-banner">
              big-banner
          </div>
      </div>


      <div id="sub">      
          <div class="semi-title">인기 숙소</div>
          <div>
              <div class="semi-banner">
                  <div class="semi-banner1">
                      <div class="semi-banner-img-area"></div>
                      <div class="semi-text1">서울</div>
                      <div class="semi-text2">어쩌구 느낌의 숙소!</div>
                  </div>

                  <div class="semi-banner2">
                      <div class="semi-banner-img-area"></div>
                      <div class="semi-text1">부산</div>
                      <div class="semi-text2">어쩌구 느낌의 숙소!</div>
                  </div>

                  <div class="semi-banner3">
                      <div class="semi-banner-img-area"></div>
                      <div class="semi-text1">강릉</div>
                      <div class="semi-text2">어쩌구 느낌의 숙소!</div>
                  </div>
              </div>
      </div>

  </div>
  
  <jsp:include page="WEB-INF/views/common/footer.jsp"></jsp:include>
  


</body>

</html>