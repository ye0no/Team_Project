<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:include page="admin_main.jsp" />  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 공지사항 글쓰기 </title>
<link rel="stylesheet" href="./resources/css2/gongji_insert.css">

</head>
<body>
<div class="gongji_wrap"> 
<h2> 공지사항 내용</h2>


<div class="gongji_content">
<h4>
<label for ="title" id="ad_title" >제목 :</label> <input name="title" id="title" size="40" maxlength="50" value="${g.title}" readOnly> <br>
 <label for ="writer" id="ad_writer" > 작성자 :</label> <input name="writer" id="writer"  size="40" value="${g.writer}" readOnly><br>
 <label for ="hit" id="ad_hit" > 조회수 :</label> <input name="hit" id="hit"  size="40" value="${g.hit}" readOnly><br>
 
 <label for ="gongji_cont" id="cont" >글내용 : </label> <textarea id="gongji_cont" name="gongji_cont" rows="8" cols="41" readOnly>${cont}</textarea>
</h4>

</div>
<div class="cont_button_page">
<input type="button" value="글쓰기" onclick="location='admin_Gongji_insert';">
<input type="button" value="목록" onclick="location='admin_Gongji_list?page=${page}';">
</div>
</div>

</body>
</html>