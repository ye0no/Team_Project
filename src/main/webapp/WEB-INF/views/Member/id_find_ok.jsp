<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 아이디 조회</title>
<style>
body{
background-image:url('../resources/images/pwd_test3.jpg');
background-repeat:no-repeat;
background-size:cover;
max-height:100%;
}

.feel{
color:blue;
}
</style>
</head>
<body>
<div id="searchId"> 
<h4> ${user}님의 아이디는  <b class="feel">${id} </b> 입니다. </h4>  
<input type="button"  value="확인" onclick="self.close();">
</div>
</body>
</html>