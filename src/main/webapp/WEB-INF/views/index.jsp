<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.1">
<title></title>
<%-- 아이콘 사용하기 위한 코드  --%>
<script src="https://kit.fontawesome.com/9376c7b079.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet"  href="resources/css2/index.css">
<script src="resources/js2/jquery.js"></script>
<script>

function search_check(){
	if($.trim($('#find_name').val())==''){
		alert('검색어를 입력해주세용!');
		$('#find_name').val('').focus();
		return false;
	}
	
}
</script>
</head>
<body>
<!----------- 상단 (로고+메뉴, 배경이미지+텍스트+검색바) ------------->
     <div class = "header">
       <div class="top_bg">
            <div class="logo_Area">
              <a href="/controller/index">
              <img alt="로고" src="resources/images/web_logo.jpg" width="150" height="50">
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
              <li><a href="/controller/Member/like_view"><i class="fa-solid fa-thumbs-up"></i></a>
             
              <li><a href="/controller/recomTop/Food_list">맛집리스트</a></li>
            </ul>
            
            </c:if>                  
        </div>
        
        
        <div class="top_img">
          <div class="top_text">
            <h1>솔직한 리뷰, 믿을 수 있는 평점!</h1>
            <h1>Web 플레이트</h1>
          </div>
          <div class="box_sh">
          
            <form class="box"  action="search" onsubmit="return search_check();">
            
              <input type="text" name="find_name" id="find_name" value="${find_name}" placeholder="지역,식당 또는 음식" maxlength="50">
              <%-- 뒷부분 나중에 수정 필요  --%>
              <input type="submit" value="검색">
            </form>
          </div>
         </div>
      </div>
             
<!------------------ 메인 (리스트+사진) --------------------->
       <%---- 3 x 2 ----%>   
       <div class="main">
              <section class="top_list">
              <div class = "section">
                 <h2>믿고 보는 맛집 리스트</h2>
                 <%--<h3><a href="/controller/list/top_list">리스트 더보기</a></h3> --%>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img">
                 <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="한식 맛집 TOP 30 사진" src="resources/images/food/jungol.jpg">
                       <a href="/controller/recomTop/reTop15?cond=1">
                       <div class="list_img_text">
                         <span class="title">한식 맛집 TOP 30</span>
                         <p class="desc">" 가족과 함께 따뜻한 식사를 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="중식 맛집 TOP 18 사진" src="resources/images/food/jjajang.jpg">
                       <a href="/controller/recomTop/reTop15?cond=2">
                       <div class="list_img_text">
                         <span class="title">중식 맛집 TOP 18</span>
                         <p class="desc">" 오늘 짜장면 어때? "</p>
                       </div>
                       </a>
                     </li>
                     
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="일식 맛집 TOP 16 사진" src="resources/images/food/ilsik.jpg">
                       <a href="/controller/recomTop/reTop15?cond=3">
                       <div class="list_img_text">
                         <span class="title">일식 맛집 TOP 16</span>
                         <p class="desc">" 회를 정말 좋아한다면? "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="양식 맛집 TOP 12 사진" src="resources/images/top/sin2.jpg">
                       <a href="/controller/recomTop/reTop15?cond=4">
                       <div class="list_img_text">
                         <span class="title">양식 맛집 TOP 12</span>
                         <p class="desc">" 용산 가면 뭐 먹지 ?"</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">                    
                     <li>
                       <img class="list_img_jpg" alt="외국 음식 맛집 TOP 8 사진" src="resources/images/food/foreign.jpg">
                       <a href="/controller/recomTop/reTop15?cond=5">
                       <div class="list_img_text">
                         <span class="title">외국 음식 맛집 TOP 8 </span>
                         <p class="desc">" 여기에 이런 맛집이? "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="디저트 맛집 TOP 사진" src="resources/images/food/desert.jpg">
                       <a href="/controller/recomTop/reTop15?cond=6">
                       <div class="list_img_text">
                         <span class="title">디저트 맛집 TOP 2</span>
                         <p class="desc">" 디저트가 땡긴다면? 요기어때? "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
              </div>
          </section>
         </div>
         
         <%-------------------------%>
         <div class="main">
              <section class="menu_list">
              <div class = "section">
                 <h2>메뉴별 맛집 리스트</h2>
                 <h3><a href="/controller/list/menu_list">리스트 더보기</a></h3>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img">
                 <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="국수 인기 맛집 TOP 사진" src="resources/images/menu/noodle.jpg">
                       <a href="recomTop/reTop30?menu=1">
                       <div class="list_img_text">
                         <span class="title">국수 인기 맛집 TOP </span>
                         <p class="desc">" 국수가 땡기는 날엔~ "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="스시 인기 맛집 TOP 사진" src="resources/images/menu/sushi.jpg">
                       <a href="recomTop/reTop30?menu=2">
                       <div class="list_img_text">
                         <span class="title">스시 인기 맛집 TOP </span>
                         <p class="desc">" 스시 먹으려면  여기를 가야지"</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="돼지고기 인기 맛집 TOP 사진" src="resources/images/menu/pig.jpg">
                       <a href="recomTop/reTop30?menu=3">
                       <div class="list_img_text">
                         <span class="title">돼지고기 인기 맛집 TOP </span>
                         <p class="desc">" 한국인의 소울푸드는 돼지고기가 아닐까?  "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="소고기 인기 맛집 TOP 사진" src="resources/images/menu/cow.jpg">
                       <a href="recomTop/reTop30?menu=4">
                       <div class="list_img_text">
                         <span class="title">소고기 인기 맛집 TOP </span>
                         <p class="desc">" 소고기가 입에 들어가면 정말 행복해 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="스테이크 인기 맛집 TOP  사진" src="resources/images/menu/stake.jpg">
                       <a href="recomTop/reTop30?menu=5">
                       <div class="list_img_text">
                         <span class="title">스테이크 인기 맛집 TOP </span>
                         <p class="desc">" 스테이크 썰어서 먹어볼까?  "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="정식 인기 맛집 TOP 사진" src="resources/images/menu/jungsik.jpg">
                       <a href="recomTop/reTop30?menu=6">
                       <div class="list_img_text">
                         <span class="title">정식 인기 맛집 TOP </span>
                         <p class="desc">" 2022 정식 맛집이 궁금하다면 주목! "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
              </div>
          </section>
         </div>
         
         <%-------------------------%>
         <div class="main">
              <section class="loca_list">
              <div class = "section">
                 <h2>지역별 인기 맛집</h2>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img">
                 <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="안산 인기 맛집 TOP 30 사진" src="resources/images/loca/squid.jpg">
                       <a href="/controller/recomTop/reTop10?addr=1">
                       <div class="list_img_text">
                         <span class="title">안산 인기 맛집 TOP 30</span>
                         <p class="desc">" 안산 음식 구경해 볼래? "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="횡성 인기 맛집 TOP 10 사진" src="resources/images/loca/suwon.jpg">
                       <a href="/controller/recomTop/reTop10?addr=2">
                       <div class="list_img_text">
                         <span class="title">횡성 인기 맛집 TOP 20</span>
                         <p class="desc">" 횡성 찐맛집 여기 다 있네! "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="용산 인기 맛집 TOP 10" src="resources/images/loca/gangbuk.jpg">
                       <a href="/controller/recomTop/reTop10?addr=3">
                       <div class="list_img_text">
                         <span class="title">용산 인기 맛집 TOP 30</span>
                         <p class="desc">" 다양한 먹거리는 용산에서 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="춘천 인기 맛집 TOP 10" src="resources/images/loca/busan.jpg">
                       <a href="/controller/recomTop/reTop10?addr=4">
                       <div class="list_img_text">
                         <span class="title">춘천 인기 맛집 TOP 10</span>
                         <p class="desc">" 춘천을 가면  여긴 꼭 가야지 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="대구 인기 맛집 TOP 10" src="resources/images/loca/gangnam.jpg">
                       <a href="/controller/recomTop/reTop10?addr=5">
                       <div class="list_img_text">
                         <span class="title">대구 인기 맛집 TOP 30</span>
                         <p class="desc">" 맛집하면 대구! 대구하면 맛집! "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                     
                       <img class="list_img_jpg" alt="부산 인기 맛집 TOP " src="resources/images/loca/jeju.jpg">
                       <a href="/controller/recomTop/reTop10?addr=6">
                       <div class="list_img_text">
                         <span class="title">부산 인기 맛집 TOP 30</span>
                         <p class="desc">" 이곳이 부산 맛집이라 안카나 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
              </div>
          </section>
         </div>
         
         
         <%---- 4 x 2 ----%>
         <div class="main">
              <section class="bakery_list">
              <div class = "section">
                 <h2>돼지고기 맛집 추천</h2>
                 <%-- <h3><a href="#">리스트 더보기</a></h3> --%>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img2">
              
                
                    <c:if test="${!empty pig8}">
                    <c:forEach var="f" items="${pig8}"> 
                <div class="contain2">
                  <p>
                  
                   <a href="/controller/rest/rest1?f_num=${f.f_num}">
                    <img src="resources/upload${f.food_file1}">
                    <span class="t_b">${f.bsnsnm}</span>
                    <span class="t_p">${f.grade }</span> <br>                    
                    <span class="t_s">${f.addr}</span>
                   </a>                   
                  </p>   
                </div>
                               
                  </c:forEach>
                  </c:if>                                
                
                </div>  
          </section>
         </div>
         
         <%--------%>
         
         <div class="main">
              <section class="bakery_list">
              <div class = "section">
                 <h2>평점 맛집 추천</h2>
                 <%-- <h3><a href="#">리스트 더보기</a></h3> --%>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img2">
                <c:if test="${!empty sashimi8}">
                <c:forEach var="s" items="${sashimi8}"> 
                <div class="contain2">
                  <p>
                   <a href="/controller/rest/rest1?f_num=${s.f_num}">
                     <img src="resources/upload${s.food_file1}">
                    <span class="t_b">${s.bsnsnm}</span><br>
                    <span class="t_p">${s.grade }</span> <br>
                    <span class="t_s">${s.addr }</span>
                   </a>
                  </p>
                </div>
                 </c:forEach>
                  </c:if>    
           
              </div>  
          </section>
         </div>
        
<!----------------------- 하단 시작 ------------------------->
         <div class="footer">
           <div class="foot_box">
             <div class="foot_logo">
               <a href="/controller/index">
               <img alt="로고" src="resources/images/logoW_ex.png">
               </a>
             </div>
             
             <div class="foot_ul" id="foot_ul1">
               <ul>
                 <li><a href="Terms_of_Use">이용약관</a></li>
                 <li><a href="NonMember">비회원 이용자 이용약관</a></li>
                 <li><a href="Terms_of_Use">개인정보처리방침</a></li>
               </ul>
             </div>
             <div class="foot_ul" id="foot_ul2">
               <ul>               
                 <li><a href="AboutUS">사이트 소개</a></li>
                 <li><a href="Inquire">고객센터</a></li>
                 <li><a href="board">공지사항</a></li>
               </ul>
             </div>
           </div>
           
           <div class="clear"></div>
           
           <div id="foot_down">
            주소 &nbsp;:&nbsp; 서울특별시 OO구 OOOO로 OOO &nbsp; &nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; E-mail &nbsp;:&nbsp; webplate@webplate.com &nbsp; &nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; Tel &nbsp;:&nbsp; 02) 123 - 4567 &nbsp; &nbsp; &nbsp; |&nbsp; &nbsp; &nbsp; Fax &nbsp;:&nbsp; 02 - 1234 - 5678<br>
            <br>All contents CopyRight ⓒ 2022 WebPlate Inc. all rights reserved
           </div>
         </div> 
</body>
</html>