<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 비번 찾기</title>
<script src="../resources/js2/jquery.js"></script>
<link rel="stylesheet" href="../resources/css2/pwd_find.css">
<script src="../resources/js2/memberFind.js"></script>
<style>
body{
background-image:url('../resources/images/pwd_test3.jpg');
background-repeat:no-repeat;
background-size:cover;
max-height:100%;
}
</style>

</head>
<body>
<div class="pwd_wrap">
<form method="post" action="pwd_find_ok" onsubmit="return pwd_check();">
 <h2 id="pwd_find_title"style="text-align:center;"> 비번 찾기</h2>
 <label for="username" class="user_info"> 이름</label>  
<p class="user_info"><input type="text" name="username" id="username" size="30" maxlength="30" tabindex=1;> </p> 
 
<label for="userID" class="user_info"> 아이디 </label> 
 <p class="user_info"> <input type="text" name="userID" id="userID" size="30" maxlength="30" tabindex=2> </p>
 
 <input type="submit" value="비번 찾기">
 <input type="reset" value="취소" onclick="$('#username').focus();">
 </form>
 
 </div>
 
</body>
</html>