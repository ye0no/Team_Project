<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="admin_main.jsp" />
<link rel="stylesheet" href="./resources/css2/admin_member_info.css">

   

<br>
<div id="mlist_wrap">
<h1 class="mlist_title"> 회원 페이지 조회</h1>
<form method="post" action="admin_member_Edit">
<table id="mem_list">
<tr>
<th class="mem_label"> 아이디 :</th>
<td > <input name="id" id="id" value="${m.id}" readOnly style="color:black;"></td>
</tr>

<tr>
 <th class="mem_label"> 이름 :</th>
 <td> <input name="name" id="name" value="${m.name}" readOnly style="color:black;"></td>
</tr>

<tr>
<th class="mem_label"> 생년월일 : </th>
<td> <input name="birth" id="birth" value="${jumin}" readOnly style="color:black;" > </td>
</tr>

<tr>
<th class="mem_label"> 성별 :</th>
<td> <input name="gender" id="gender" value="${m.gender}" readOnly style="color:black;"></td>
</tr>

<tr>
<th class="mem_label"> 이메일 : </th>
<td> <input name="email" id="email" value="${m.email}" readOnly style="color:black;"></td>
</tr>

<tr>
<th class="mem_label"> 휴대전화  : </th>
<td> <input name="tel" id="tel" value="${tel}" readOnly style="color:black;"></td>
</tr>

<tr>
<th class="mem_label"> 계정상태  : </th>
<td> <input name="mem_state" id="mem_state" value="${m.mem_state}" readOnly style="color:black;"></td>
</tr>

</table>

<div>
<span class="mem_dellabel"> 탈퇴사유  : </span>
<span> <textarea id="mem_delcont" name="mem_delcont"  rows="8" cols="38" readonly style="color:black;">${m.mem_delcont}</textarea>
</span> 
</div>

<div id="cont_list">
<input type="submit" value="정보 수정하기">
<input type="button" value="전체목록" onclick="location='adminMember_List?page=${page}&id=${m.id}';">


</div>

</form>
</div>
<br> <br> <br> <br><br>