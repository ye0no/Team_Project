<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 탈퇴 </title>
<link rel="stylesheet" href="../resources/css2/loginForm.css">

<script src="../resources/js2/jquery.js"></script>
<script src="../resources/js2/memberScript.js"></script>

</head>
<body>
<div>
<h2 class="dm_title" > 회원 탈퇴 </h2>
<form method="post" action="m_Del_ok" onsubmit="return Del_write();">
<table >
<tr>
<th > 회원 ID</th>
<td> <input name="del_id" id="del_id" size="30" value="${Sid}" maxlength="30" readOnly> </td>
</tr>
<tr>
<th> 회원 PW </th>
<td> <input type="password" name="del_pwd" id="del_pwd" size="30" maxlength="30"></td>
</tr>
<tr>
<th> 탈퇴사유 </th>
<td> <textarea rows="10" cols="30" name="del_cont" id="del_cont"></textarea></td>
</tr>
</table>
<div class="del_btn">
<input type="submit" value="탈퇴" >
<input type="reset" value="초기화" onclick="$('#del_pwd').focus();">
</div>

</form>
</div>

</body>
</html>


