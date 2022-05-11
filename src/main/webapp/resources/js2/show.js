$(function(){
	$(".more_click").hide();
	$(".more_click").slice(0, 10).show(); // 최초 페이지만 보이게
	$(".more").click(function(){ // more클래스 클릭시 이벤트 실행
	  $(".more_click:hidden").slice(0, 10).show(); // 숨김 설정된 페이지중 한개를 선택하여 나타냄
	  $(".footer").hide();
	  if($(".more_click:hidden").length ==0){ // 보여질 개수가 없다면 클릭버튼 숨기기
		  $('.more').hide();
		  $(".footer").show();
	  }
	});
});