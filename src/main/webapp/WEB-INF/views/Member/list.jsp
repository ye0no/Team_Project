<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/logo.jsp"/>


    
<script>
function mem_Del(){
	const url="memberDel";
	window.open(url,"회원탈퇴","width=430px,height=490px,scrollbars=yes");
}
</script>
<br>
<div id="mlist_wrap">
<h1 class="mlist_title"> 회원 페이지 조회</h1>
<form method="post" action="mem_edit">
<table id="mem_list">
<tr>
<th class="mem_label"> 아이디 :</th>
<td > <input name="id" id="id" value="${Sid}" readOnly style="color:black;"></td>
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


</table>

<div id="cont_list">
<input type="submit" value="정보 수정하기">
<input type="button" value="계정 탈퇴하기" onclick="mem_Del();">


</div>

</form>
</div>
<br> <br> <br> <br><br>
<jsp:include page="../include/footer.jsp"/>