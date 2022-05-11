<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Web PLATE LOGIN </title>
<link rel="stylesheet" href="../resources/css2/index.css">
<link rel="stylesheet" href="../resources/css2/loginForm.css">
<script src="../resources/js2/jquery.js"> </script>
<script src="../resources/js2/memberScript.js"></script>


</head>
<body>
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
              <li><a href="#">맛집리스트</a></li>
            </ul> 
            </c:if>
            
             <c:if test="${!empty Sid}">
              <ul class="nav">              
              <li><a href="/controller/Member/list">MY PAGE </a></li>
              <li><a href="/controller/Member/logOut">로그아웃</a></li>                 
              
              <li><a href="#">맛집리스트</a></li>
            </ul>
            
            </c:if>
            
                  
</div>
        
<div class="block"></div> <%-- 로고 고정밑에 부분 띄워짐 판정이라 div박스로 그 부분 채워버림 --%>
        
 <div class="clear"></div>




<form method="post" action="mem_edit_Ok" onsubmit="return EditWrite();">
<div class="UserId">
<label for="id" class="loginForm"> 아이디 </label> 
</div>

<div class="e_Box2">
<input type="text" name="id" id="id" placeholder="ID" maxlength="30" value="${m.id}" readOnly> 

</div>


<div class="UserPw">
<label for="pw" class="loginForm">비밀번호 </label>
</div>

<div class="Box1">
<input type="password" name="pw" id="pw" placeholder="Password" maxlength="30">

</div>

<div class="UserPw2">
<label for="pw2" class="loginForm">비밀번호 확인 </label>
</div>

<div class="Box1">
<input type="password" name="pw2" id="pw2" placeholder="Password 확인" maxlength="30">
</div>




<div class="User_name">
<label for="name" class="loginForm"> 이름 </label> 
</div>
<div class="Box1">
<input type="text" name="name" id="name" placeholder="Name" value="${m.name }"> 
</div>

<div class="User_year">
<label for="jumin1" class="loginForm"> 생년월일</label>
</div>
<div class="Box9">
<input type="number" name="jumin1"id="jumin1" placeholder="ex) 1998" maxlength="4" oninput="Number_MaxLength(this);" value="${m.jumin1}"  >
<select name="jumin2" id="jumin2" style="width:85px; height:45px; margin-top:10px; text-align:center;">
<c:forEach var="month" items="${arr}"  begin="0" end="11">
<option value="${month}" <c:if test="${m.jumin2.equals(month)}">${'selected'}</c:if>> ${month} </option>
</c:forEach>
</select>

<div class="Box5">
<select name="jumin3" id="jumin3" style="width:85px; height:45px; margin-top:10px;
text-align:center; ">
<c:forEach var="day" items="${arr}" >
<option value="${day}" <c:if test="${m.jumin3==day}">${'selected'}</c:if>> ${day} </option>
</c:forEach>
</select>
</div> 
</div>

<div class="User_gender">
<label class="loginForm"> 성별</label>
</div>

<div class="Box8">
<input type="radio" name="gender" id="m" value="남자"  <c:if test="${fn:contains(m.gender,'남자')}">checked </c:if> style="margin-right:10px; "> 남자
<input type="radio" name="gender" id="w" value="여자" <c:if test="${fn:contains(m.gender,'여자')}">checked </c:if> style="margin-left:40px; margin-right:10px;  "> 여자

</div>

<div class="User_mail">
<label for="email" class="loginForm"> 이메일</label>
</div>
<div class="Box3">
<input type="text" name="email"id="email" placeholder="ex) abc3491@gmail.com" size="39" value="${m.email}">  
 
</div>

<div class="User_phone">
<label for="tel" class="loginForm"> 휴대전화 </label>
</div>

<div class="Box10">
<input type="number" id="tel" name="tel"  placeholder=" - 빼고 번호 입력"  maxlength="11" oninput="Number_MaxLength(this);" value="${m.tel}" >
</div>

<div class="Box7">
<input type="submit" value="수정하기 " > 
<input type="reset" value="초기화" onclick="$('#pw').focus();">
</div>
</form>
<jsp:include page="../include/footer.jsp"/>




</body>
</html>