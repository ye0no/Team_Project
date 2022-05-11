<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="admin_main.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 공지사항 글 수정 </title>
<script src="./resources/js2/admin_main.js"></script>
<link rel="stylesheet" href="./resources/css2/gongji_edit.css">


</head>
<body>
<div class="gongji_wrap"> 
<h2> 공지사항 글 수정하기</h2>

<form method="post" action="admin_Gongji_Edit_ok" onsubmit="return check_gongji();">
 <input type="hidden" name="gongji_no" value="${g.gongji_no}" />
  <input type="hidden" name="page" value="${page}" />
<div class="gongji_content">
<h4>
<label for ="title" id="ad_title" >제목 :</label> <input name="title" id="title" size="40" maxlength="50" value="${g.title}"> <br>
 <label for ="writer" id="ad_writer" > 작성자 :</label> <input name="writer" id="writer"  size="40" value="${g.writer}" readOnly><br>
 <label for ="gongji_cont" id="cont" >글내용 : </label> <textarea id="gongji_cont" name="gongji_cont" rows="8" cols="41">${cont}</textarea>
</h4>

</div>
<div class="button_page">
<input type="submit" value="수정 " > 
<input type="button" value="목록" onclick="location='admin_Gongji_list?page=${page}';">
</div>
</form>
</div>

</body>
</html>