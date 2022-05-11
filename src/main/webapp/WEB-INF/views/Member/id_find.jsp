<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 아이디 찾기</title>
<link rel="stylesheet" href="../resources/css2/user_find.css">
<script src="../resources/js2/jquery.js"></script>
<script src="../resources/js2/memberFind.js"></script>
</head>
<style>
body{
background-image:url('../resources/images/pwd_test3.jpg');
background-repeat:no-repeat;
background-size:cover;
max-height:100%;
}
</style>
<body>
<div class="idck_wrap">
<form method="post" action="id_find_ok" onsubmit="return id_check();">
 <h2 id="id_find_title"> 아이디 찾기</h2>
 <label for="username" class="user_info"> 이름</label>  
<p class="user_info"><input type="text" name="username" id="username" size="30" maxlength="30" tabindex=1;> </p> 
 
<label for="tel1" class="user_info"> 휴대전화 </label> 
<div class="tel">
<p id="tel_idck"><input type="number" name="tel1"id="tel1"  placeholder="ex) 010" maxlength="3" oninput="Number_MaxLength(this);" > -
<input type="number" name="tel2"id="tel2" style="width:66px; height:30px; margin-left:2px;" placeholder="ex) 1234" maxlength="4" oninput="Number_MaxLength(this);" > -
<input type="number" name="tel3"id="tel3" style="width:66px; height:30px; margin-left:2px;" placeholder="ex) 9876" maxlength="4" oninput="Number_MaxLength(this);" > </p>
</div>
 
 <div id="idck_menu">
 <input type="submit" value="아이디 찾기">
 <input type="reset" value="취소" onclick="$('#username').focus();">
 </div>
 </form>
 
 </div>
 
</body>
</html>