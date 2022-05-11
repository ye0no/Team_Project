<%@ page contentType="text/html; charset=UTF-8"%>
<script  src="../resources/js2/jquery.js"></script>
<script>
$(function(){
	$(".list_uli").hide();
	$(".list_uli").slice(0, 1).show(); // 최초 페이지만 보이게
	$(".more").click(function(){ // more클래스 클릭시 이벤트 실행
	  $("div:hidden").slice(0, 1).show(); // 숨김 설정된 페이지중 한개를 선택하여 나타냄
	
	
	
	});
});

</script>

<jsp:include page="../include/logo.jsp" />

  <div class="list_layout">
    <div class="list_head">
       <p>메뉴별 맛집 리스트</p>
    </div>
   
   <div class="list_mbox">
     <%-- 메뉴 리스트 더보기 페이지 기본 --%>
     <div class="list_uli">
       <ul class="l_ul1">
         <li>
           <img class="l_img" alt="국수 인기 맛집 TOP 사진" src="../resources/images/menu/noodle.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=1" class="l_img_text">
             <div class="tit_de">
               <span class="tit"> 국수 인기 맛집 TOP </span>
               <p class="de">" 국수가 땡기는 날엔~ "</p>
             </div>
             
           </a>
         </li>
         <li>
           <img class="l_img" alt="돼지고기 인기 맛집 TOP 사진" src="../resources/images/menu/pig.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=3" class="l_img_text">
             <div class="tit_de">
               <span class="tit">돼지고기 인기 맛집 TOP </span>
               <p class="de">" 한국인의 소울푸드는 돼지고기가 아닐까?  "</p>
             </div>
           </a>
         </li>
         
       </ul>
      
       <ul class="l_ul2">
         <li>
           <img class="l_img" alt="스시 인기 맛집 TOP 사진" src="../resources/images/menu/sushi.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=2" class="l_img_text">
             <div class="tit_de">
               <span class="tit">스시 인기 맛집 TOP </span>
               <p class="de">" 스시 먹으려면  여기를 가야지 "</p>
             </div>
           </a>
         </li>
         <li>
           <img class="l_img" alt="소고기 인기 맛집 TOP 사진" src="../resources/images/menu/cow.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=4" class="l_img_text">
             <div class="tit_de">
               <span class="tit">소고기 인기 맛집 TOP </span>
               <p class="de">" 소고기가 입에 들어가면 정말 행복해  "</p>
             </div>
           </a>
         </li>
         <li>
           
         
       </ul> 
     </div>
     
     
     <div class="clear"></div>
     
     <%-- 더보기 눌렀을때 나오는페이지 2 --%>
     
     <%-- 메뉴 리스트 더보기 페이지 기본 --%>
     <div class="list_uli">
       <ul class="l_ul1">
         <li>
           <img class="l_img" alt="스테이크 인기 맛집 TOP  사진" src="../resources/images/menu/stake.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=5" class="l_img_text">
             <div class="tit_de">
               <span class="tit">스테이크 인기 맛집 TOP</span>
               <p class="de">" 스테이크 썰어서 먹어볼까? "</p>
             </div>
           </a>
         </li>
         <li>
           <img class="l_img" alt="정식 인기 맛집 TOP 사진" src="../resources/images/menu/jungsik.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=7" class="l_img_text">
             <div class="tit_de">
               <span class="tit">정식 인기 맛집 TOP</span>
               <p class="de">" 2022 정식 맛집이 궁금하다면 주목! "</p>
             </div>
           </a>
         </li>
         
       </ul>
      
       <ul class="l_ul2">
         <li>
           <img class="l_img" alt="닭요리 추천 TOP OO 사진" src="../resources/images/food/chicken.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=6" class="l_img_text">
             <div class="tit_de">
               <span class="tit">닭요리 인기 맛집 TOP</span>
               <p class="de">" 치킨말고 오늘은 이 닭 어때...? "</p>
             </div>
           </a>
         </li>
         <li>
           <img class="l_img" alt="햄버거 추천 TOP 사진" src="../resources/images/food/hamber01.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=8" class="l_img_text">
             <div class="tit_de">
               <span class="tit">햄버거 인기 맛집 TOP </span>
               <p class="de">" 출출할땐 햄버어억 ~~~ "</p>
             </div>
           </a>
         </li>
         <li>
           
         
       </ul> 
     
          
          
     <%-- 더보기 눌렀을때 나오는 페이지 2 end --%>
     
      
      <div class="clear"></div>
      
           <div class="list_uli">
       <ul class="l_ul1">
         <li>
           <img class="l_img" alt="OO OOOO 추천 TOP OO 사진" src="../resources/images/food/sheep.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=9" class="l_img_text">
             <div class="tit_de">
               <span class="tit">양고기 인기 맛집 TOP </span>
               <p class="de">" 맥주가 떙길땐? 양고기지~ "</p>
             </div>
           </a>
         </li>
         <li>
           <img class="l_img" alt="OO OOOO 추천 TOP OO 사진" src="../resources/images/food/bossam2.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=10" class="l_img_text">
             <div class="tit_de">
               <span class="tit">보쌈 인기 맛집 TOP</span>
               <p class="de">" 오늘은 어떤 고기를 싸먹어볼까? "</p>
             </div>
           </a>
         </li>
         
       </ul>
      
       <ul class="l_ul2">
         <li>
           <img class="l_img" alt="짜장면 인기 TOP  사진" src="../resources/images/food/jjajang.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=11" class="l_img_text">
             <div class="tit_de">
               <span class="tit">짜장면 인기 맛집 TOP </span>
               <p class="de">" 오늘은 내가 중국집 요리사~ "</p>
             </div>
           </a>
         </li>
         <li>
           <img class="l_img" alt="낙지 인기 TOP 사진" src="../resources/images/food/nakji.jpg" width="550" height="250">
           <a href="../recomTop/reTop20?menu=12" class="l_img_text">
             <div class="tit_de">
               <span class="tit">낙지 인기 맛집 TOP </span>
               <p class="de">" 쫄깃쫄깃하고 싱싱한 낙지맛 "</p>
             </div>
           </a>
         </li>
         <li>
                    
       </ul> 
     </div>     
     
     <div class="clear"></div>
     
     </div>
     </div>
     <div class="null"></div>
     
     <div class="more">
       <button onclick="more()">▼  더보기  ▼</button>
     </div>
   </div>
<div class="clear"></div>

<jsp:include page="../include/footer.jsp" />