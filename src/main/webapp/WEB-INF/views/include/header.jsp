<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"  href="../resources/css2/index.css">
<link rel="stylesheet"  href="../resources/css2/list.css">
</head>
<body>
<div class = "header">
       <div class="top_bg">
            <div class="logo_Area">
              <a href="/controller/index">
              <img alt="로고" src="../resources/images/web_logo.jpg" width="150" height="50">
              </a>
            </div>
            <ul class="nav">
              <li><a href="/controller/Member/login">로그인</a></li>
              <li><a href="/controller/Member/loginForm">회원가입</a></li>
              <li><a href="#">맛집리스트</a></li>
            </ul>       
        </div>
        
        <div class="top_img">
          <div class="top_text">
            <h1>솔직한 리뷰, 믿을 수 있는 평점!</h1>
            <h1>Web 플레이트</h1>
          </div>
          <div class="box_sh">
            <form class="box" method="post" action="search">
              <input type="text" placeholder="지역,식당 또는 음식" maxlength="50">
              <%-- 뒷부분 나중에 수정 필요  --%>
              <input type="submit" value="검색">
            </form>
          </div>
        </div>
</div>

<div class="clear"></div>