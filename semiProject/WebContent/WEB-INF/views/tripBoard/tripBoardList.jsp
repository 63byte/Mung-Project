<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		*{
            font-family: 'Noto Sans KR', sans-serif;
            font-weight: 500; /* 굵기 지정(100, 300, 400, 500, 700) */
            font-size: 16px;
            color: #212529;
            box-sizing: border-box;
            margin: 0;
            /* border : 1px solid black;  */
        }

        div{
            /* border : 1px solid black;  */
            box-sizing : border-box;
        }

        .wrapper{
            margin : auto; 
        }


#container{
    width:1100px;
    height:800px;
    display: block;
    margin: auto;

    /* background-color: ghostwhite; */
}

.aside{
    width:200px;
    height:100%;
    float: left;

    border-right: 1px solid #e5e5e5;
}

.aside > ul {
    list-style-type: none; /* 불렛 없음 */
    padding:0;
}

/* 메뉴 위아래 간격 */
.aside > ul > div {
    padding : 50px 0px 30px 0px ;
}

.aside > ul > div > li > a {
    text-decoration: none; /* 불렛 없음 */
    font-weight: 700;
    color: black;

    /* border: 1px solid red; */
}

	p{
		font-size: 12px;
	}
	
	.col-md-3{
		float: left;
		width: 21%;
		margin-bottom : 50px;
	}
	
/* 	.col-md-3:hover{
		backgroudColor: #17a2b8;
		cursor: pointer;
	}
	 */
/* 메뉴에 마우스 오버 했을 경우 민트색을 변경 */
/* .aside > ul > div > li > a {
    color: #8ad2d5; 
} */

#aside-touristSpot{
	color : #8ad2d5;
}
</style>
</head>
<body>

			<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>
<div class="container-fluid container my-5">
	
	<div class="row my-5">
		<div class="col-md-3">
			  <div class="aside">
            <ul>
                <div class="side-div-1"><li><a href="${contextPath}/freeBoard/freeList.do" class="aside-items" id="aside-localInfo">자유 게시판</a></li></div>
               <div class="side-div-2"><li><a href="${contextPath}/tripBoard/tripList.do" class="aside-items" id="aside-touristSpot">여행 후기 게시판</a></li></div>
            </ul>
        </div>
		</div>
		
		
		<div class="col-md-9 my-5">
			<div class="row">
			
				<div class="col-md-3">
					<div class="card" style="width: 11rem;">
					  <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						    <p class="card-text">제목제목제목제목[] <br> 작성자 : <br> yyyy년 MM월 dd일 HH:mm</p>
						  </div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card" style="width: 11rem;">
					  <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						    <p class="card-text">제목제목제목제목[] <br> 작성자 : <br> yyyy년 MM월 dd일 HH:mm</p>
						  </div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card" style="width: 11rem;">
					  <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						    <p class="card-text">제목제목제목제목[] <br> 작성자 : <br> yyyy년 MM월 dd일 HH:mm</p>
						  </div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card" style="width: 11rem;">
					  <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						    <p class="card-text">제목제목제목제목[] <br> 작성자 : <br> yyyy년 MM월 dd일 HH:mm</p>
						  </div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="card" style="width: 11rem;">
					  <img src="${pageContext.request.contextPath}/resources/image/common/logo.png" class="card-img-top" alt="...">
						  <div class="card-body">
						    <p class="card-text">제목제목제목제목[] <br> 작성자 : <br> yyyy년 MM월 dd일 HH:mm</p>
						  </div>
					</div>
				</div>
	</div>
</div>
</div>
</div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>


</body>
</html>