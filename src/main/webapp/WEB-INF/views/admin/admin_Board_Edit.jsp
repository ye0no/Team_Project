<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="./admin_main.jsp"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" href="./resources/css2/admin_board_edit.css">

 <script src="./resources/js2/jquery.js"></script>
<script src="./resources/js2/admin_board_edit.js"></script> 
  

</head>
<body>

<h2 style="text-align:center;"> 게시판 글 수정</h2>
<div class="batch">
<form method="post" action="admin_Board_Edit_ok" enctype="multipart/form-data" >

<c:if test="${!empty f.food_file1}">
<span><img id="food_img" src="./resources/upload${f.food_file1}">  </span>
&nbsp;
<span><img id="food_img2" src="./resources/upload${f.food_file2}" > </span>
&nbsp;
<span><img id="food_img3" src="./resources/upload${f.food_file3}" > </span>
&nbsp;

</c:if>

<c:if test="${empty f.food_file1}">
<span><img id="food_img" >  </span>
&nbsp;
<span><img id="food_img2"  > </span>
&nbsp;
<span><img id="food_img3"  > </span>
&nbsp;

</c:if>



<h4> 이미지 1 : <input type="file"  name="file1"id="file1"  onchange="readURL(this);">${f.food_file1}</h4>

<h4>이미지 2 : <input type="file" name="file2"id="file2"   onchange="readURL2(this);"  >${f.food_file2} </h4>
<h4> 이미지 3 : <input type="file" name="file3"id="file3" onchange="readURL3(this);"  > ${f.food_file3}</h4>



<h3> 분류 : <input name="f_category" id="f_category" value="${f.category}"></h3>

<h3> 가게이름 : <input name="f_bsnsnm" id="f_bsnsnm" value="${f.bsnsnm}" required  maxlength="50"></h3> 
<h3> 음식종류: <input name="f_bsnscond" id="f_bsnscond" value="${f.bsnscond}" required  maxlength="50"></h3> 
<h3> 전화번호: <input name="f_tel" id="f_tel" value="${f.tel}" required></h3>

<h3 >메뉴 :  <textarea name="f_menu" id="f_menu" rows="4" cols="34" required style="vertical-align:middle;">${food_menu}</textarea></h3>
<h3> 주소 : <textarea name="f_addr" id="f_addr" rows="2" cols="34" required style="vertical-align:middle;">${f.addr}</textarea></h3>


<h3>위도 : <input name="f_lat" id="f_lat" value="${f.lat}"></h3> 
<h3>경도 : <input name="f_lng" id="f_lng" value="${f.lng}"></h3>
<h3> 쉬는날 : <input name="f_rest" id="f_rest" value="${f.rest}"></h3>
<h3> 수용인원 : <input name="f_suyong" id="f_suyong" value="${f.suyong}"></h3>

<hr>
 <input type="hidden" name="f_num" value="${f_num}" />
  <input type="hidden" name="page" value="${page}" />
     

<p></p>

<input type="submit" value="가게정보 수정">
<input type="reset" value="취소" onclick="$('#f_bsnsnm').val('').focus();">
<input type="button" value="목록" onclick="location='admin_Board_list?page=${page}&find_field=${find_field}&find_name=${find_name}';">
<div style="height:50px;"></div>
</form>
</div>








</body>
</html>