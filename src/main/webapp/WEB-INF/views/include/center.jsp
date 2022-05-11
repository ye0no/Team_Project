<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="../resources/css2/index.css">
</head>
<body>
<!------------------ 메인 (리스트+사진) --------------------->
       <%---- 3 x 2 ----%>   
       <div class="main">
              <section class="top_list">
              <div class = "section">
                 <h2>믿고 보는 맛집 리스트</h2>
                 <h3><a href="#">리스트 더보기</a></h3>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img">
                 <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="대구 가족외식 추천 TOP 20 사진" src="../resources/images/top/daegu.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">대구 가족외식 추천 TOP 20</span>
                         <p class="desc">" 가족과 함께 따뜻한 식사를 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="카이스트 맛집 TOP 20 사진" src="../resources/images/top/kaist.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">카이스트 맛집 TOP 20</span>
                         <p class="desc">" 수재들이 먹는 맛집은 어딜까? "</p>
                       </div>
                       </a>
                     </li>
                     
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="치즈 맛집 TOP 10 사진" src="../resources/images/top/cheese.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">치즈 맛집 TOP 10</span>
                         <p class="desc">" 치즈를 정말 좋아한다면! "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="신촌이대 맛집 TOP 20 사진" src="../resources/images/top/sin2.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">신촌이대 맛집 TOP 20</span>
                         <p class="desc">" 신촌이대에 가면 뭐 먹지 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="안양 한식집 TOP 15 사진" src="../resources/images/top/korea.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">안양 한식집 TOP 15</span>
                         <p class="desc">" 안양에서 한식이 먹고싶다면 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="송파구 가락동 맛집 TOP 15 사진" src="../resources/images/top/songpa.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">송파구 가락동 맛집 TOP 15</span>
                         <p class="desc">" 송파구에 이런 맛집이!? "</p>
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
                 <h3><a href="../list/menu_list.jsp">리스트 더보기</a></h3>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img">
                 <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="파스타 인기 맛집 TOP 30 사진" src="../resources/images/menu/pasta.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">파스타 인기 맛집 TOP 30</span>
                         <p class="desc">" 파스타가 먹고싶은날엔~ "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="스시 인기 맛집 TOP 30 사진" src="../resources/images/menu/sushi.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">스시 인기 맛집 TOP 30</span>
                         <p class="desc">" 스시 먹으려면  여기를 가야지"</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="돼지고기 인기 맛집 TOP 30 사진" src="../resources/images/menu/pig.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">돼지고기 인기 맛집 TOP 30</span>
                         <p class="desc">" 한국인의 소울푸드는 돼지고기가 아닐까?  "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="소고기 인기 맛집 TOP 30 사진" src="../resources/images/menu/cow.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">소고기 인기 맛집 TOP 30</span>
                         <p class="desc">" 소고기가 입에 들어가면 정말 행복해 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="돈까스 인기 맛집 TOP 30 사진" src="../resources/images/menu/donkgas.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">돈까스 인기 맛집 TOP 30</span>
                         <p class="desc">" 돈까스를 소스에 찍어 먹어야지  "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="라멘 인기 맛집 TOP 30 사진" src="../resources/images/menu/ramen.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">라멘 인기 맛집 TOP 30</span>
                         <p class="desc">" 추운 날 따듯한 라멘 한 그릇 "</p>
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
                       <img class="list_img_jpg" alt="강원도 인기 맛집 TOP 10 사진" src="../resources/images/loca/squid.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">강원도 인기 맛집 TOP 10</span>
                         <p class="desc">" 강원도 음식이 맛있다는데 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="경기도 인기 맛집 TOP 10 사진" src="../resources/images/loca/suwon.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">경기도 인기 맛집 TOP 10</span>
                         <p class="desc">" 경기도 맛집이 여기 다 있네 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="제주도 인기 맛집 TOP 10" src="../resources/images/loca/jeju.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">제주도 인기 맛집 TOP 10</span>
                         <p class="desc">" 제주도를 가면 꼭 가야지 "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="부산 인기 맛집 TOP 10" src="../resources/images/loca/busan.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">부산 인기 맛집 TOP 10</span>
                         <p class="desc">" 이곳이 부산 맛집이라 안카나 "</p>
                       </div>
                       </a>
                     </li>
                  </ul>
                  
                  <ul class="list_ul">
                    <li>
                       <img class="list_img_jpg" alt="강남 인기 맛집 TOP 10" src="../resources/images/loca/gangnam.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">강남 인기 맛집 TOP 10</span>
                         <p class="desc">" 맛집하면 강남! 강남하면 맛집! "</p>
                       </div>
                       </a>
                     </li>
                     <li>
                       <img class="list_img_jpg" alt="강북 인기 맛집 TOP 10" src="../resources/images/loca/gangbuk.jpg">
                       <a href="#">
                       <div class="list_img_text">
                         <span class="title">강북 인기 맛집 TOP 10</span>
                         <p class="desc">" 다양한 먹거리는 강북에서 "</p>
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
                 <h3><a href="#">리스트 더보기</a></h3>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img2">
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
              </div>  
          </section>
         </div>
         
         <%--------%>
         
         <div class="main">
              <section class="bakery_list">
              <div class = "section">
                 <h2>카페 추천</h2>
                 <h3><a href="#">리스트 더보기</a></h3>
              </div>
              
              <div class="clear"></div>
              
              <div class="list_img2">
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
                <div class="contain2">
                  <p>
                   <a href="#">
                    <img src="../resources/images/squid.jpg">
                    <span class="t_b">OOO</span><br>
                    <span class="t_s">OO로 OO길 OO</span>
                   </a>
                  </p>
                </div>
              </div>  
          </section>
         </div>