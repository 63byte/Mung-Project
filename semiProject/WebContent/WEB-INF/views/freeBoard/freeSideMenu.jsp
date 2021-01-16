<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <<style>

       #container{
            width:1100px;
            height:800px;
            display: block;
            margin: auto;

            /* background-color: ghostwhite; */
        }

        .aside{
        		margin-top : 50px;
            width:200px;
            height:100%;
            float: left;
            //border-right: 1px solid #e5e5e5;

            /* border: 1px solid red; */
        }

        .aside > ul {
            list-style-type: none; /* 불렛 없음 */
            padding:0;
        }

        /* 메뉴 위아래 간격 */
        .aside > ul > div > li {
            padding : 30px 0px 30px 0px ;
        }

        .aside > ul > div >li > a {
            text-decoration: none; /* 불렛 없음 */
            font-weight: 700;
            color: black;

            /* border: 1px solid red; */
        }

        /* 메뉴에 마우스 오버 했을 경우 민트색을 변경 */
        .aside > ul > div > li > a:hover {
            color: #8ad2d5; 
            
        }
        
        .aside > ul > div:hover{
        	backgroundColor : #8ad2d5;
        }
        
        
        
</style>
    
<div class="col-sm-4 mt-5">
	<h3>사이드 메뉴</h3>
	<ul class="list-group">
		<li class="list-group-item list-group-item-action"><a href="myPage.do">내정보</a></li>
		<li class="list-group-item list-group-item-action"><a href="changePwd.do">비밀번호 변경</a></li>
		<li class="list-group-item list-group-item-action"><a href="secession.do">회원 탈퇴</a></li>
	</ul>
</div>
