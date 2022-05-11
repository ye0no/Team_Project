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
<style>
h2{
text-align:center;}
table{
margin:auto;
width:1000px;
}
table,td,th{
border-collapse:collapse;
border:1px solid black;}

td{
text-align:center;
}
.gongji_cnt{
text-align:right;
margin-right:50px;
background-color:#FFC681;
}

.gongji_batch1{
margin-top:10px;
text-align:center;

}

.gongji_batch_field{
text-align:center;
margin-top:15px;
}

.gongji_total_list{
text-align:right;
margin-right:375px;
margin-top:15px;}


.gongji_batch_field input[type=submit]{
width:40px;
margin-left:5px;
padding:5px;
background-color:darkorange;
border:0px;
color:white;
border-radius:15px;
}

.gongji_batch_field input[type=submit]:hover{
cursor:pointer;
}
</style>

</head>
<body>

<form method="get" action="admin_Gongji_list" >
<div>
<h2> 공지사항 페이지</h2>



<table >
<tr>
 <th colspan="6" class="gongji_cnt"> 공지사항 개수 : ${listcount} 개 </th>
</tr>

<tr> 
 <th> 번호 </th>
 <th> 작성자 </th>
 <th> 제목 </th>
 <th> 조회수 </th> 
 <th> 등록날짜 </th>
 <th> 수정 / 삭제 </th>
</tr>

<c:if test="${!empty glist}">
<c:forEach var="g" items="${glist}" varStatus="status">
<tr>
<td> ${status.count }</td>
<td>  ${g.writer}</td>
<td> <a href="admin_gongji_info?gongji_no=${g.gongji_no}&page=${page}">${g.title } </a></td>
<td> ${g.hit} </td>

<td> ${fn:substring(g.gongji_register,0,10)}</td>
<td class="button1"> 
<input type="button" value="수정" onclick="location='admin_Gongji_Edit?gongji_no=${g.gongji_no}&page=${page}';">
/ <input type="button" value="삭제" onclick="if(confirm('이 계정을 삭제하시겠습니까?')==true){
	location='admin_Gongji_Del?gongji_no=${g.gongji_no}&page=${page}';}
	else{
	return;}">
</td>
</tr>
</c:forEach>
</c:if>


<c:if test="${empty glist}">
<tr>
 <th colspan="6"> 검색 목록에 없습니다!</th> 
</tr>
</c:if>

</table>



<%-- 페이징 --%>
<div class="gongji_batch1">
<%-- 검색 전 페이징 --%>
<c:if test="${(empty find_field)&&(empty find_name) }">
 <c:if test="${page<=1}">
 [이전]&nbsp;
 </c:if>
  
  <c:if test="${page>1}">
  <a href="admin_Gongji_list?page=${page-1}">[이전]</a>
  </c:if>
  
  <%-- 현재 쪽번호 출력 --%>
  <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
  
  <c:if test="${a ==page }">
  <%-- 현재 페이지 선택 --%>
  <${a}>
  </c:if>
  
  <c:if test="${a !=page }">
  <a href="admin_Gongji_list?page=${a}">[${a}]</a> &nbsp;
  </c:if>
   
    
  </c:forEach>
  
  <c:if test="${page>=maxpage }">
  [다음]
  </c:if>
  
  <c:if test="${page<maxpage}">
  <a href="admin_Gongji_list?page=${page+1}"> [다음]</a>
  </c:if>  
 </c:if>
 
 <%-- 검색 후 페이징 --%>
 <c:if test="${(!empty find_field) || (!empty find_name)}">
 <c:if test="${page<=1}">
 [이전]&nbsp;
 </c:if>
 
 <c:if test="${page>1}">
 <a href="admin_Gongji_list?page=${page-1}&find_field=${find_field}&find_name=${find_name}"> [이전]</a>
 </c:if>
 
 <%-- 현재 쪽번호 출력 --%>
 <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
  <c:if test="${a ==page }">
  
  <%-- 현 페이지 선택시 --%>
  
  <${a}>
  </c:if>
  
  <c:if test="${a !=page}">
  
  <%-- 현페이지 선택이 안되었다면 --%>
  
  <a href="admin_Gongji_list?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a> &nbsp;
  </c:if> 
 
 </c:forEach>
 
 <c:if test="${page>=maxpage }">
 [다음]
 </c:if>


 <c:if test="${page<maxpage}">
 
 <a href="admin_Gongji_list?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
 
 </c:if> 
 
 </c:if>

</div>

<%-- 검색후 전체 목록으로 돌아가는 기능 --%>
<div class="gongji_total_list">
<c:if test="${(!empty find_field) && (!empty find_name)}">
 <input type="button" value="전체목록" onclick="location='admin_Gongji_list?page=${page}';">

</c:if>

<input type="button" value="글쓰기" onclick="location ='admin_Gongji_insert?page=${page}';">
</div>


<div class="gongji_batch_field">
<select name="find_field">

<option value="all" <c:if test="${find_field=='all'}"> ${'selected'}</c:if>> 전체 </option>
<option value="title" <c:if test="${find_field=='title'}"> ${'selected'}</c:if>> 제목 </option>
<option value="gongji_cont" <c:if test="${find_field=='gongji_cont'}">${'selected'}</c:if>> 글내용 </option>   
</select>

<input name="find_name" id="find_name" size="20" value="${find_name}"> <input type="submit" value="검색">

</div>


</div>
</form>

</body>
</html>