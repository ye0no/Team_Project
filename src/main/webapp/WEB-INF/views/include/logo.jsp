<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="https://kit.fontawesome.com/9376c7b079.js"></script>
<script src="../resources/js2/jquery.js"></script>

<link rel="stylesheet" type="text/css" href="../resources/css2/index.css">
<link rel="stylesheet" type="text/css" href="../resources/css2/list.css">
<link rel="stylesheet" type="text/css" href="../resources/css2/rest.css">
<link rel="stylesheet" type="text/css" href="../resources/css2/login.css">
<link rel="stylesheet" type="text/css" href="../resources/css2/recom.css">



</head>
<body>
<!----------- 상단 (로고+메뉴, 배경이미지+텍스트+검색바) ------------->
       <div class="top_bg">
            <div class="logo_Area">
              <a href="/controller/">
              <img alt="로고" src="../resources/images/web_logo.jpg" width="150" height="50">
              </a>
            </div>
            
            <c:if test="${empty Sid}">
              <ul class="nav">
              <li><a href="/controller/Member/login">로그인</a></li>
              <li><a href="/controller/Member/loginForm">회원가입</a></li>              
              <li><a href="/controller/recomTop/Food_list">맛집리스트</a></li>
            </ul> 
            </c:if>
            
             <c:if test="${!empty Sid}">
              <ul class="nav">              
              <li><a href="/controller/Member/list">MY PAGE </a></li>
              <li><a href="/controller/Member/logOut">로그아웃</a></li>                 
              <li><a href="/controller/Member/like_view"><i class="fa-solid fa-thumbs-up" style="color:black;"></i></a>
                           
              <li><a href="/controller/recomTop/Food_list">맛집리스트</a></li>
            </ul>
            
            </c:if>
                  
        </div>
        
        <div class="head_box"></div> <%-- 로고 고정밑에 부분 띄워짐 판정이라 div박스로 그 부분 채워버림 --%>
        
        <div class="clear"></div>