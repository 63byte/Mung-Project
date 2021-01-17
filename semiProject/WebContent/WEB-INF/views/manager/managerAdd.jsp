<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>일반 조회</title>
<head>

	<!-- 구글 폰트 -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
        rel="stylesheet">

    <!-- 부트스트랩 사용을 위한 css 추가 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    <!-- 부트스트랩 사용을 위한 라이브러리 추가 (반드시 jQuery가 항상 먼저여야한다. 순서 중요!) -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

<style>
.main{
            width:900px;
            height:100%;
            float: left;
        }

        th, td {
            font-size: 13px;
        }

        #additionalBtn {
            margin-top: 15px;
            margin-left: 15px;
            background-color : #8ad2d5 ;
            color: white;
            border: white;
            border-radius: 5px;
            width: 150px;
            height: 40px;
        }
        
        #additionalBtn:hover, #searchBtn:hover {
            background-color: #17a2b8;
        }

        #searchBtn {
            background-color : #8ad2d5 ;
            color: white;
            border: white;
            border-radius: 5px;
            height: 38px;
        }

        h6 {
            margin-left: 15px;
            height: 30px;
        }

        .page-item > a{
            color : black;
        }

        .page-item > a:hover{
            color: orange;
        }
</style>
</head>
<body>

	<jsp:include page="/WEB-INF/views/common/otherHeader.jsp"></jsp:include>

	<jsp:include page="managerSideMenu.jsp"></jsp:include>

            <div class="main">

                <div id="btnDiv">
                    <a href="${contextPath}/manager/managerAdd.do">
                    <button type="menu" id="additionalBtn">숙소 등록 조회</button></a>
                </div>

                <br>
                
                <h6>숙소 등록 신청 조회 결과</h6>

                <div id="resultDiv">
                    <table class="table table-hover table-striped text-center" id="result">
                        <thead>
                            <tr>
                                <th>회원 번호</th>
                                <th>아이디</th>
                                <th>업체명</th>
                                <th>전화번호</th>
                                <th>업체 전화번호</th>
                            </tr>
                        </thead>

                        <tr>
                            <td>1</td>
                            <th>1004Roy</th>
                            <td>멍멍아!야옹해!</td>
                            <td>010-1111-1111</td>
                            <td>02-1234-1234</td>
                        </tr>
                    </table>
                </div>

                <div class="paging">
                    <nav aria-label="Page navigation example">
                        <ul id="pagingBtn" class="pagination pagination-sm justify-content-center">
                          <li class="page-item"><a class="page-link" href="#">&lt;&lt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">&lt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">1</a></li>
                          <li class="page-item"><a class="page-link" href="#">2</a></li>
                          <li class="page-item"><a class="page-link" href="#">3</a></li>
                          <li class="page-item"><a class="page-link" href="#">4</a></li>
                          <li class="page-item"><a class="page-link" href="#">5</a></li>
                          <li class="page-item"><a class="page-link" href="#">6</a></li>
                          <li class="page-item"><a class="page-link" href="#">7</a></li>
                          <li class="page-item"><a class="page-link" href="#">8</a></li>
                          <li class="page-item"><a class="page-link" href="#">9</a></li>
                          <li class="page-item"><a class="page-link" href="#">10</a></li>
                          <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                          <li class="page-item"><a class="page-link" href="#">&gt;&gt;</a></li>
                        </ul>
                      </nav>
                    </div>

                <div class="search">
                    <form action="${contextPath}/search.do" method="GET" class="text-center" id="searchForm">
                        <select name="sk" class="form-control" style="width: 100px; display: inline-block;">
                            <option value="id">아이디</option>
                            <option value="nickName">업체명</option>
                        </select>

                        <input type="text" name="sv" class="form-control" style="width: 25%; display: inline-block;">
                        <button id="searchBtn" style="width: 100px; display: inline-block;">검색</button>
                    </form>
    
    
                </div>
            </div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>






</body>
</html>