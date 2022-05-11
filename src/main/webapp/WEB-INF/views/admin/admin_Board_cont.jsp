<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="admin_main.jsp"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>  </title>
<link rel="stylesheet" href="./resources/css2/admin_board.css">
<script src="./resources/js2/review.js"></script>
<script src="https://kit.fontawesome.com/9376c7b079.js"></script>

</head>
<body>
<div class="block2"> </div>
<%-- 전체 배치 --%>
<div id="board_wrap_cont">


<%-- 사진 배치  --%>
<div class="board_batch1">
<img id="food_img01" src="./resources/upload${f.food_file1}" alt="1">
<img id="food_img01" src="./resources/upload${f.food_file2}" alt="2">
<img id="food_img01" src="./resources/upload${f.food_file3}" alt="3">
</div>

<div id="board_rest_content">
<div> <span id="board_bsnsnm"> ${f.bsnsnm} </span>
<div id="batch2">

<span> <i class="fa-solid fa-eye"></i></span>
<span> ${f.viewcnt}</span>
</div>
</div>
<hr>

<div id="board_cont_font">
<div>
<span> 등록순서  : </span>
<span> ${f.f_num}</span>
</div>


<div>
<span> 분류  : </span>
<span> ${f.category}</span>
</div>


<div>
<span> 평점 :</span>
<span> ${f.grade}</span>
</div>




<div >
<span> 음식의 종류 :</span>
<span> ${f.bsnscond}</span>
</div>

<div>

<table> 
<tr>
<td rowspan="5" style="vertical-align:top;"> 메뉴 : </td>
<td> ${food_menu }</td>
</tr>
</table>

</div>

<div>
<span> 연락처 :  </span>
<span> ${f.tel}</span>
</div>

<div>
<span> 주소  : </span>
<span> ${f.addr}</span>
</div>

<c:if test="${!empty f.rest}">
<div>
<span> 휴무일  : </span>
<span> ${f.rest}</span>
</div>
</c:if>



<c:if test="${!empty f.suyong}">
<div>
<span> 수용인원  : </span>
<span> ${f.suyong}</span>
</div>
</c:if>


<div>
<span> 위도  : </span>
<span> ${f.lat}</span>
</div>

<div>
<span> 경도  : </span>
<span> ${f.lng}</span>
</div>
  
</div>

</div>




<!-- 지도를 표시할 div 입니다 -->
<div id="map" style="width:35%;height:350px; z-index:0; "></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=	4a9ef0ef123875d2c771898ba8e90d94"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
mapOption = { 
    center: new kakao.maps.LatLng("${f.lat}", "${f.lng}"), // 지도의 중심좌표
    level: 2 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);


//마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng("${f.lat}", "${f.lng}"); 

//마커를 생성합니다
var marker = new kakao.maps.Marker({
position: markerPosition
});

//마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

//아래 코드는 지도 위의 마커를 제거하는 코드입니다
//marker.setMap(null);   

var iwContent = '<div style="padding:21px;">"${f.bsnsnm}" <br><a href="https://map.kakao.com/link/map/${f.bsnsnm},${f.lat},${f.lng}" style="color:blue" target="_blank">큰지도보기</a> <a href="https://map.kakao.com/link/to/${f.bsnsnm},${f.lat},${f.lng}" style="color:blue" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
     iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    content : iwContent,
    removable : iwRemoveable
});

// 마커에 클릭이벤트를 등록합니다
kakao.maps.event.addListener(marker, 'click', function() {
      // 마커 위에 인포윈도우를 표시합니다
      infowindow.open(map, marker);  
});
</script>


<div class="clear"> </div>


<div class="food_switch">
<input type="button" value="수정하기" onclick="location='admin_Board_Edit?f_num=${f_num}&page=${page}';"> &nbsp;
<input type="button" value="전체목록" onclick="location='admin_Board_list?f_num=${f_num}&page=${page}';">
</div>




</div>
<%-- 리뷰 배치 --%>


<div class="rest_down" style="height: -webkit-fill-available;">
<header class="down_header">
<h2 class="down_title">리뷰</h2>
<ul class="point_filter">
<li class="point_item"><button class="point_button" value="">전체 평점<span class="point_count"> ( ${point} )</span></button></li>
</ul>
</header>
<ul class="review_list">
<c:if test="${empty rlist}">
<li class="review_item">
<a class="review_box">
<div class="review_user">
<div class="profile_wrap">
</div>
<span class="review_username" style="text-align: center; color: #000000; font-weight: 600;"><%-- 리뷰 유저 이름 --%></span>
</div>
<div class="review_content" style="width: 80%;">
<div class="review_wrap2">
<p class="review_text" style="font-size: 20px; line-height: 1.8; color: #000000; font-weight: bold;">
<%-- 작성한 리뷰 --%>작성된 리뷰가 없습니다.
</p>
<span class="review_date" style="font-size: 16px; line-height: 3; color: #C8C8C8;"><%-- 리뷰 작성 시간 --%></span>
</div>
</div>
<div class="point_rating">
</div>
</a>
<div class="edit_button">
</div>
</li>
</c:if>
<c:if test="${!empty rlist}">
 <c:forEach var="r" items="${rlist}" varStatus="status">
<li class="review_item">
<a class="review_box">
<div class="review_user">
<div class="profile_wrap">
<img src="./resources/images/like.jpg" width="100" height="100"/>
</div>
<c:if test="${!empty r.mem_id}">
<span class="review_username" style="text-align: center; color: #000000; font-weight: 600;"><%-- 리뷰 유저 이름 --%>${r.mem_id}</span>
</c:if>
<c:if test="${r.mem_id==null}">
<span class="review_username" style="text-align: center; color: #000000; font-weight: 600;"> 탈퇴한 회원</span>
</c:if>
</div>
<div class="review_content" style="width: 80%;">
<div class="review_wrap2">
<p class="review_text" style="font-size: 20px; line-height: 1.8; color: #000000; font-weight: bold;">
<%-- 작성한 리뷰 --%>${r.r_cont}
</p>
<span class="review_date" style="font-size: 16px; line-height: 3; color: #C8C8C8;"><%-- 리뷰 작성 시간 --%>${r.regdate}</span>
</div>
</div>
<div class="point_rating">
<img src="./resources/images/like.jpg" width="60" height="60" style="margin-top: 55px; margin-left: 20px;"/>
</div>
</a>
<div class="edit_button">

<button class="review_del" onclick="if(confirm('이 리뷰를 삭제하시겠습니까?')==true){

location='admin_review_del?rno=${r.rno}&f_num=${r.f_num}&page=${page}';}
else{
return;}">삭제</button>
</div>
</li>
</c:forEach>
</c:if>
</ul>
<c:if test="${listcount > 5}">
<div class="review_page" role="button" onclick="review_page()" style="margin: 0 50% 0 45%;">더보기</div>
</c:if>
</div>



</body>
</html>