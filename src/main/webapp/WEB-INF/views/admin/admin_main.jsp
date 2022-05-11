<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title> 관리자 메인 페이지</title>

<%-- 아이콘 사용하기 위한 코드  --%>
<script src="https://kit.fontawesome.com/9376c7b079.js"></script>

<link rel="stylesheet" href="./resources/css2/admin_main.css">
<script src="./resources/js2/jquery.js"></script>
<script src="./resources/js2/admin_main.js"></script>
</head>
<body>


<nav class="navbar">


<div class="navbar_logo">
<a href="admin_main">
              <img alt="로고" src="resources/images/web_logo.jpg" width="150" height="50">
              </a>
</div>

<ul class="navbar_menu" id="navbar_menu">
 <li><a href="../controller/"> 메인 </a> </li>
 <li><a href="admin_Board_list"> 게시판 </a> </li>
 <li><a href="admin_Gongji_list"> 공지사항</a> </li>
 <li><a href="adminMember_List"> 회원관리</a> </li>
 
</ul>

<div class="navbar_admin_logOut" id="navbar_admin_logOut">

<h3> <span style="font-size:18px; color:darkorange;" >관리자</span>님 환영합니다! &nbsp;</h3>
<form method="post" action="admin_logOut">
<input type="submit" value="로그아웃">

</form>

</div>
<a href="#" id="navbar_toggleBtn" class="navbar_toggleBtn"><i class="fa-solid fa-bars"></i></a> 

</nav>

<div id="block" class="block"> </div>

</body>
</html>