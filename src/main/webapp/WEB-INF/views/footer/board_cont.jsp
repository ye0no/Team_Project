<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/Main_logo.jsp" />

<style>
.header{
margin-bottom:-470px;
}


.gongji_wrap{
width:600px;
text-align:center;
border:1px solid orange;
margin:auto;
letter-spacing: 3px;
}
.gongji_content{
line-height:30px;
}

#ad_title{
margin-left:18px;
}
#cont{
vertical-align:top;
}


#regdate{
margin-right:15px;
}
#gongji_cont{
margin-top:5px;
resize:none;
margin-right:6px;
}

.cont_button_page{
margin-bottom:30px;
margin-right:135px;
}



.cont_button_page input[type=button]{
width:50px;
margin-right:60px;
padding:5px;
background-color:darkorange;
border:0px;
color:white;
border-radius:15px;
}


.cont_button_page input[type=button]:hover{
cursor:pointer;
}

.footer{
margin-top:30px;
}
</style>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<div class="gongji_wrap"> 
<h2> 공지사항 내용</h2>


<div class="gongji_content">
<h4>
<label for ="title" id="ad_title" >제목  </label> <input name="title" id="title" size="40" maxlength="50" value="${gongji.title}" readOnly> <br>
 <label for ="writer" id="ad_writer" > 작성자  </label> <input name="writer" id="writer"  size="40" value="${gongji.writer}" readOnly><br>
 <label for ="hit" id="ad_hit" > 조회수  </label> <input name="hit" id="hit"  size="40" value="${gongji.hit}" readOnly><br>
 <label for="regdate" id="ad_regdate"> 등록날짜</label> <input name="regdate" id="regdate" size="40" value="${regdate}" readOnly><br>
 <label for ="gongji_cont" id="cont" >글내용   </label> <textarea id="gongji_cont" name="gongji_cont" rows="9" cols="45" readOnly>${cont}</textarea>
</h4>

</div>
<div class="cont_button_page">
<input type="button" value="목록" onclick="location='board?page=${page}';">
</div>
</div>

</body>
</html>

<jsp:include page="../include/Main_footer.jsp" /> 