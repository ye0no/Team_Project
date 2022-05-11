<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="admin_main.jsp" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" href="./resources/css2/admin_member_list.css">

</head>
<body>

<%-- 회원 검색 --%>
<form method="get" action="adminMember_List">
<div>
<h2> 회원 관리 페이지 </h2>

<div class="admem_batch1"> 

<table >
<tr>
<th colspan="7" id="admem_cnt"> 회원수: ${listcount} 명</th>
</tr>
<tr>
<th>아이디 </th>
<th>회원이름 </th>
<th>성별 </th>
<th>연락처 </th>
<th>계정상태 </th>
<th>등록날짜 </th>
<th>수정/삭제 </th>
</tr>
<c:if test="${!empty mlist}">
<c:forEach var="m" items="${mlist}">
<tr id="admem_batch3">
<td> ${m.id } </td>
<td> <a href="admin_member_info?id=${m.id}&page=${page}">  ${m.name }  </a></td>
<td> ${m.gender}</td>
<td> ${fn:substring(m.tel,0,3)}-${fn:substring(m.tel,3,7)}-${fn:substring(m.tel,7,11)}</td>
<td><c:if test="${m.mem_state==1}">회원 </c:if>
<c:if test="${m.mem_state==0}">탈퇴</c:if> </td>
<td> ${fn:substring(m.mem_date,0,10)}</td>
<td> 
<input type="button" value="수정" onclick="location='admin_member_Edit?id=${m.id}&page=${page}';">&nbsp;/&nbsp;<input type="button" value="탈퇴"
onclick="if(confirm('이 계정을 삭제하시겠습니까?')==true){
	location='admin_member_del?id=${m.id}&page=${page}';}
	else{
	return;
}">
</td>
</tr>

</c:forEach>
</c:if>

<c:if test="${empty mlist}">
<tr>
 <th colspan="7"> 계정이 존재하지 않습니다!</th> 
</tr>
</c:if>

</table>

<%-- 페이징 --%>
<div>
<%-- 검색 전 페이징 --%>
<c:if test="${(empty find_field)&&(empty find_name) }">
 <c:if test="${page<=1}">
 [이전]&nbsp;
 </c:if>
  
  <c:if test="${page>1}">
  <a href="adminMember_List?page=${page-1}">[이전]</a>
  </c:if>
  
  <%-- 현재 쪽번호 출력 --%>
  <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
  
  <c:if test="${a ==page }">
  <%-- 현재 페이지 선택 --%>
  <${a}>
  </c:if>
  
  <c:if test="${a !=page }">
  <a href="adminMember_List?page=${a}">[${a}]</a> &nbsp;
  </c:if>
   
    
  </c:forEach>
  
  <c:if test="${page>=maxpage }">
  [다음]
  </c:if>
  
  <c:if test="${page<maxpage}">
  <a href="adminMember_List?page=${page+1}"> [다음]</a>
  </c:if>  
 </c:if>
 
 <%-- 검색 후 페이징 --%>
 <c:if test="${(!empty find_field) || (!empty find_name)}">
 <c:if test="${page<=1}">
 [이전]&nbsp;
 </c:if>
 
 <c:if test="${page>1}">
 <a href="adminMember_List?page=${page-1}&find_field=${find_field}&find_name=${find_name}"> [이전]</a>
 </c:if>
 
 <%-- 현재 쪽번호 출력 --%>
 <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
  <c:if test="${a ==page }">
  
  <%-- 현 페이지 선택시 --%>
  
  <${a}>
  </c:if>
  
  <c:if test="${a !=page}">
  
  <%-- 현페이지 선택이 안되었다면 --%>
  
  <a href="adminMember_List?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a> &nbsp;
  </c:if> 
 
 </c:forEach>
 
 <c:if test="${page>=maxpage }">
 [다음]
 </c:if>


 <c:if test="${page<maxpage}">
 
 <a href="adminMember_List?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
 
 </c:if> 
 
 </c:if>

</div>

<%-- 검색후 전체 목록으로 돌아가는 기능 --%>
<div class="admem_total_list">
<c:if test="${(!empty find_field) && (!empty find_name)}">
 <input type="button" value="전체회원" onclick="location='adminMember_List?page=${page}';">

</c:if>

</div>




<div class="admem_batch_field">
<select name="find_field">
<option value="id" <c:if test="${find_field=='id'}"> ${'selected'}</c:if>> 아이디 </option>
<option value="name" <c:if test="${find_field=='name'}">${'selected'}</c:if>> 회원이름 </option>   
</select>

<input name="find_name" id="find_name" size="20" value="${find_name}"> <input type="submit" value="검색">

</div>

</div>
</div>
</form>



</body>
</html>