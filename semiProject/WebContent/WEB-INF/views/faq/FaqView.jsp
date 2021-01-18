 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>html문서 제목</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<!-- Bootstrap core JS -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

<!-- sweetalert : alert창을 꾸밀 수 있게 해주는 라이브러리 https://sweetalert.js.org/ -->
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<style>

 #wrapper {
    width: 1100px;
 	height:100%;
    margin: 0px auto;
    border: 1px soild black;
    display: block;
    
    
	
    } 
 #side {
	width: 200px;
    height: 100%;
	float:left;
	margin-top:30px;
 } 
#contenthead{
	width: 900px;
    height: 100%;
    float:left;
	
}

#uls > li{
    list-style: none;
	line-height: 80px;
    
}
#button > button{
 background-color:#8bd2d6; 
 color:white;
}
/*.a{
 display: inline-block;
/  border: 1px solid black;
 
 }*/
 
/*.b{
    margin-left: 450px;
}
/* #contenthead2{
    width: 100%;
     border: 1px solid;
} */
 
 .g{
     font-size: 13px;
 }
/* 이미지 관련 스타일 */
 .boardImg{
width : 100%;
height: 100%;
max-width : 300px;
max-height: 300px;
margin : auto;
}
.boardImgArea{
    height: 300px;
}
.carousel-indicators > li{
background-color: #ccc !important;
}
.carousel-control-prev-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
}

.carousel-control-next-icon {
    background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%23000' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
}
li{
  list-style: none;
}
a{
  color:black;
}


/* 댓글 스타일 */


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
    <div id="contenthead">
        <div class="container-fluid" style="margin-top:50px;">
            <div class="row">
                <div class="col-md-12">
                    <h3>제목 : 아... 너무 어렵다..</h3>   
                    <div class="col-md-12" style="text-align:right; font-size: 0.5em;
					color: gray;">조회수:1230</div><hr>
                </div>
            </div>
        </div>           
         <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8" style="color:gray;font-size: 0.8em;">
                 	       글쓴이 : 관리자
                    </div>
                    <div class="col-md-4" style="text-align:right; font-size: 0.5em;
					color: gray;">
			                        작성일 :  2020년1월18일19:29:09  <br>
			                        수정일 :  2020년1월18일19:29:09
                    </div>
                </div>
            </div>

            
            <div class="container-fluid">
                 <div class="row">
                    <div class="col-md-12">
                        <div class="carousel slide boardImgArea" id="board-image">
                            <ol class="carousel-indicators">
                                <li data-slide-to="0" data-target="#board-image" class="active">
                                </li>
                                <li data-slide-to="1" data-target="#board-image">
                                </li>
                                <li data-slide-to="2" data-target="#board-image">
                                </li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="carousel-item active">
                                    <img class="d-block w-100 boardImg" alt="Carousel Bootstrap First" src="${pageContext.request.contextPath}/resources/image/common/logo.png"/>
                           
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100 boardImg" alt="Carousel Bootstrap Second" src="${pageContext.request.contextPath}/resources/image/common/logo.png" />
                         
                                </div>
                                <div class="carousel-item">
                                    <img class="d-block w-100 boardImg" alt="Carousel Bootstrap Third" src="${pageContext.request.contextPath}/resources/image/common/logo.png" />
                        
                                </div>
                            </div> 
                            <a class="carousel-control-prev" href="#board-image" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> 
                            <a class="carousel-control-next" href="#board-image" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
                        </div>
                    </div>
                </div> 
            		<div id="" style="height: 250px; margin-top:20px;">안녕하세요 저는 관리자입니다.. 많은 분들이 뭐라뭐라 하시는데열심히하고 있습니다 제발 믿어주세요 ..제발ㄹ</div>
            </div>
              
        
        <div class="float-right" id="button">
            <button type="button" class=" btn  ml-1 mr-1" onclick="location.href='faqUpdate.do'">수정</button>
            <button id="deleteBtn" class=" btn">삭제</button>
        </div>
        
        
     	 <div style="margin-top:80px;">
        	   댓글
        	 <hr>
         </div> 
        
        </div> 
        
        <jsp:include page="/WEB-INF/views/notice/NoticeReply.jsp"></jsp:include>

  	</div>
     
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>





</body>
</html>