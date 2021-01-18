<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    
    <!-- 부트스트랩 사용을 위한 라이브러리 추가 -->
    <!-- jquery가 항상 먼저여야된다! -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>


</head>
<style>
 
    #side{
        float: left;
        width: 200px;
        height: 800px;
    }
    #wrapper{
        width: 1100px;
        height: 800px;
        margin: 0px auto;
    }   
    #wrapper2{
     float: left;
     width: 895px;
     margin-top: 35px;

    } 
 

    #uls{
        margin-top: 30px;
    } 

   #uls > li{
        line-height: 80px;
        list-style: none;
    }
/*     div{
        border: 1px solid;
    } */
    #img > div{
        display: inline-block;
        border: 1px solid gray;
   	    border-radius: 5px;
   	    
    }
    #img{
  	 width: 895px;
    }
    
    a{
	  color:black;
	}


</style>
<body>
<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
<div id="wrapper">
    <div id="side">
        <ul id="uls">
	        <li><a href="${contextPath}/notice/notice.do">공지사항</a></li>
			<li><a href="${contextPath}/faq/faq.do">자주묻는질문</a></li>
			<li><a href="${contextPath}/qna/qna.do">Q&A</a></li>
        </ul>
    </div>
    <div id="wrapper2">
      <form method="get">
        <div>
            <h3>자주묻는질문 수정</h3>
            <hr>
        </div>
        <div>
            <input type="text"style="width:80%; border:none;" placeholder="제목을입력하세요.">
            <hr>
        </div>
        <div>
            <p style="color: gray;">이미지 업로드</p>
        </div>
        <div id="img" >
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"style="width: 100px;">
            </div>
             <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
            <div>
                <img src="${pageContext.request.contextPath}/resources/image/common/logo.png"  style="width: 100px;">
            </div>
        </div> 
        <hr>
          <p style="color:gray">내용</p>
          <textarea rows="13" style="resize: none; width: 895px; border: 3px solid #8bd2d6;
   								 border-radius: 5px;"></textarea> 

        <div class="float-right">
            <button type="submit" class="btn" style="background-color:#8bd2d6; color:white;">수정</button>
            <button type="button"  class="btn"  style="background-color:#8bd2d6; color:white;">취소</button>
        </div>

		</form>
    </div> 
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
<script>

</script>
</body>
</html>
