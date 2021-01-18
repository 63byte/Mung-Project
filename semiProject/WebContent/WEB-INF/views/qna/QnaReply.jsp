<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.replyWrite {
	width: 900px;

}
#replyWrite{
	width:30px;
}

#replyContentArea {
	width: 80%;
	
}

#replyContentArea > textarea {
	resize: none;
	width: 80%;

}
#replyBtnArea {
	width: 100px;
	
}

.rWriter {
	display: inline-block;
	margin-right: 30px;
	vertical-align: top;
    font-size: small;
}
.rContent{
    font-size: small;

}

.rDate {
	display: inline-block;
	font-size: 0.5em;
	color: gray;
}

#replyListArea {
    float: left;
    width: 900px;
}

.rContent, .replyBtnArea {
	height: 100%;
	width: 100%;
}

.replyBtnArea {
	text-align: right;
}

.replyUpdateContent {
	resize: none;
	width: 100%;
}

.reply-row{
/* 	border-bottom : 1px solid #ccc;
 */	padding : 15px 0;
}
.replyBtn{
cursor: pointer;
}
#addReply{
 background-color:#8bd2d6; 
 color:white;
}


</style>
<body>
      <div id="reply-area" style="margin-left:195px;">
        
            <div class="replyList">
                
<!--                 <ul id="replyListArea">
 -->                    
                   
                    <div class="reply-row">
                        <div>
                            <p class="rWriter"><strong>관리자</strong></p>
                            <p class="rDate">작성일 : 2021.01.11 10:30</p>
                        </div>
        
                        <p class="rContent"> tlqkfqltlasdasdasdasdasdasdasdasdasdasdasdasdasdsadasdasdasda </p>
                        
                        <div class="replyBtnArea">
                            <a class="replyBtn" style="color:gray;font-size: 0.8em;" id="updateReply" onclick="showUpdateReply(2, this)">수정</a>
                            <a class="replyBtn"  style="color:gray;font-size: 0.8em;"id="deleteReply" onclick="deleteReply(2)">삭제</a>
                        </div> 
<!--                        <div>조그만 기다려주세요 .. 답변 처리 중입니다....</div>
 -->                    </div>
            
<!--                 </ul>
 -->        
     	     <div class="replyWrite" style="margin-top: 20px;">
                    <table align="center">
                        <tr>
                            <td id="replyContentArea">
                                <textArea rows="2" id="replyContent" style="width: 830px; border: 3px solid #8bd2d6;
   								 border-radius: 5px;"></textArea>
                            </td>
                            <td id="replyBtnArea"  style="text-align:right; align:center;">
                                <button class="btn" id="addReply">
                                                                     등록
                                </button>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
</body>
</html>