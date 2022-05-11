<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
    
<jsp:include page="admin_main.jsp"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" href="./resources/css2/admin_board_list.css">

</head>
<body>



<form method="get" action="admin_Board_list">

<div>
</div>

<table >
<caption> 게시판 목록  </caption>
<tr>
 <th colspan="6" class="food_cnt"> 식당 정보 :${listcount} 개 </th>
</tr>
<tr>
<th width="3%"> 번호</th>
<th width="7%" > 사진 </th>
<th width="14%"> 식당이름 </th>
<th width="5%"> 조회수 </th>
<th width="5%"> 평점 </th>
<th width="5%"> 내용 수정 </th>
</tr>
<c:if test="${!empty flist}">
 <c:forEach var="f" items="${flist}" varStatus="status">

 <tr>
  <td align="center">${status.count } </td>   <%--1부터 시작해서 증가 --%>  
  <td><img src="./resources/upload${f.food_file1}"  style=" width:100%; height:30%; text-align:center;"></td>
  <td id="fd_menu" align="center"> <a href="admin_Board_cont?f_num=${f.f_num}&page=${page}"> ${f.bsnsnm}  </a> </td>
  <td align="center">${f.viewcnt} </td>
  <td align="center">${f.grade} </td>
  
  <td align="center"> <input type="button" value="수정" onclick="location='admin_Board_Edit?f_num=${f.f_num}&page=${page}&find_name=${find_name}&find_field=${find_field}';"> </td>
 </tr>

 </c:forEach>
</c:if>

<c:if test="${empty flist}">
 <tr>
  <th colspan="6"> 목록이 없습니다. </th>
 </tr>
</c:if>
</table>

<%--페이징  --%>
<div class="food_paging">

<c:if test="${(empty find_field) &&(empty find_name)}">
 <c:if test="${page<=1}">
 [이전]&nbsp;
  </c:if>
 
 <c:if  test="${page>1}">
  <a href="admin_Board_list?page=${page-1}"> [이전]</a> &nbsp;
  </c:if>
  
  
  <%-- 현재 쪽번호 출력  --%>
  <c:forEach var="a" begin="${startpage}" end="${endpage}" step="1">
   <c:if test="${a==page}">
   <%-- 현재 페이지 선택되었다면 --%>
   <${a}>
   
   </c:if>  
       
   <c:if test="${a !=page}">
   <%--현재 페이지 선택 안되었다면 --%>
   <a href="admin_Board_list?page=${a}">[${a}]</a>&nbsp;
    </c:if>   

  </c:forEach>
  
  <c:if test="${page>=maxpage}">  
  [다음]
  </c:if>
  
  <c:if test="${page<maxpage}">
  <a href="admin_Board_list?page=${page+1}">[다음]</a>    
 </c:if> 
 </c:if>
 
 <%-- 검색 후 페이징 --%>
 <c:if test="${(!empty find_field) || (!empty find_name)}" >
  <c:if test="${page<=1}">
  [이전] &nbsp;
  </c:if>
  
  
  <c:if test="${page>1}">
  <a href="admin_Board_list?page=${page-1} &find_field=${find_field} &find_name=${find_name}">[이전] </a> &nbsp;
  </c:if>
  
  <%-- 현재 쪽번호 출력 --%>
  <c:forEach var="a" begin="${startpage}" end="${endpage }" step="1">
   <c:if test="${a==page}">
   <${a}>
   </c:if>
   
   <c:if test="${a !=page}">
   <a href="admin_Board_list?page=${a}&find_field=${find_field}&find_name=${find_name}">[${a}]</a> &nbsp;
   </c:if>
  </c:forEach>
  
  <c:if test="${page >=maxpage}">
  [다음]
  </c:if>
  
  <c:if test="${page<maxpage}">
  <a href="admin_Board_list?page=${page+1}&find_field=${find_field}&find_name=${find_name}">[다음]</a>
</c:if>
 
 </c:if>
</div>

<div id="Board_total_list">
<c:if test="${(!empty find_field)&&(!empty find_name)}">
 <input type="button" value="전체목록"
 onclick="location='admin_Board_list?page=${page}';">

</c:if>

</div>


<%-- 검색 폼추가 --%>

<div class="food_info_select">
<select name="find_field" class="food_select_choose">
<option value="all"<c:if test="${find_field=='all'}">${'selected'}</c:if>> 전체 </option>
<option value="bsnsnm" <c:if test="${find_field=='bsnsnm'}"> ${'selected'}</c:if>>식당이름</option>
<option value="menu"<c:if test="${find_field=='menu'}">${'selected'}</c:if>>메뉴 </option>
<option value="addr"<c:if test="${find_field=='addr'}">${'selected'}</c:if>>지역</option>  

</select>

<input name="find_name" id="find_name" size="30" value="${find_name}">
<input type="submit" value="검색">
</div>


</form>

</body>
</html>