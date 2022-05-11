<%-- 리스트 더보기 했을때 오는 페이지!!!--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../resources/js2/jquery.js"></script>
<script src="../resources/js2/show.js"></script>
<style>
.more{
margin-top:10px;
}
.footer{
margin-top:30px;
}
</style>
<jsp:include page="../include/logo.jsp" />


<div class="recom_top">
  <table>
    <tr>
      <th>조회수</th>
      <td>${hit}</td>
      <td>${Date}</td>
    </tr>
  </table>
  <h1>${eat} 맛집 TOP </h1>
  <h4>${ment }</h4>
</div>



<div class="recom_main">
<c:if test="${!empty Sid}">
  <ul>
  <c:if test="${!empty like_list}"> 
 <c:forEach var="like" items="${like_list}" varStatus="status"> 
    <li class="more_click">
      <div class="recom_timg">
        <img alt="" src="../resources/upload${like.food_file1}">
      </div>
      
      <div class="recom_tbox">
        <div class="recom_rest">
          <a href="../rest/rest1?f_num=${like.f_num}">
             <span class="recom_rest_name">${status.count}.${like.bsnsnm}</span>
             <div class="recom_rest_null" style="color:orange;">${like.grade }</div>
             <span class="recom_rest_addr">${like.addr}</span>
          </a>
        </div>
      </div>  
      
      <div class="recom_right">
        <c:if test="${like.like_state==0}">
      <img name="heart"id="heart" alt="" src="../resources/images/starb.png" width="80" height="80" > 
        </c:if>
       
        <c:if test="${like.like_state==1}">
        <img alt="" src="../resources/images/staro.png" width="80" height="80">
        </c:if>  
        
        <div class="recom_rdown">
          <a href="../rest/rest1?f_num=${like.f_num}">
             <span class="sangshe">상세보기 ></span>
          </a>
        </div>
      </div>
 
    </li>
    </c:forEach>
    </c:if>      
  </ul>
   
 </c:if>


<c:if test="${empty Sid}">
  <ul>
  <c:if test="${!empty food}"> 
 <c:forEach var="f" items="${food}" varStatus="status"> 
    <li class="more_click">
      <div class="recom_timg">
        <img alt="" src="../resources/upload${f.food_file1}">
      </div>
      
      <div class="recom_tbox">
        <div class="recom_rest">
          <a href="../rest/rest1?f_num=${f.f_num}">
             <span class="recom_rest_name">${status.count}.${f.bsnsnm}</span>
             <div class="recom_rest_null" style="color:orange;">${f.grade }</div>
             <span class="recom_rest_addr">${f.addr}</span>
          </a>
        </div>
      </div>  
      
      <div class="recom_right">
        <img alt="" src="../resources/images/starb.png" width="80" height="80">
        
        <div class="recom_rdown">
          <a href="../rest/rest1?f_num=${f.f_num}">
             <span class="sangshe">상세보기 ></span>
          </a>
        </div>
      </div>
 
    </li>
    </c:forEach>
    </c:if>      
  </ul>
   
 </c:if>
 <div class="clear"></div>
</div>

<div class="more">
  <button onclick="more()">▼  더보기  ▼</button>
</div>
<jsp:include page="../include/footer.jsp" />