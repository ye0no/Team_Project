	$(function(){
		$(".review_item").hide();
		$(".review_item").slice(0, 5).show(); // 최초 페이지만 보이게
		$(".review_page").click(function(){ // more클래스 클릭시 이벤트 실행
		  $(".review_item:hidden").slice(0, 5).show(); // 숨김 설정된 페이지중 한개를 선택하여 나타냄
		  if($(".review_item:hidden").length ==0){ // 보여질 개수가 없다면 클릭버튼 숨기기
			  $('.review_page').hide();
		  }
		});
	});
	
	function login(){
    	alert('로그인이 필요한 기능입니다!');
    	location='../Member/login';
    }
    
    function review_check(){
    	if($('input:radio[name=rating]').is(':checked')==false){
    		alert('별점을 체크해주세요!');
    		return false;
    	}
    	
    	if($.trim($('#review_cont').val())==''){
    		alert('리뷰를 남겨주세요!');
    		$('#review_cont').val('').focus();
    		return false;
    	}
    }
    
    // 리뷰 수정
    function edit_check(){
    	
    	if($.trim($('#edit_info').val()) == "") {
    	      alert("내용을 입력해주세요!");
    	      $("#edit_info").val("").focus();
    	      return false;

		}
	}
    
    
    
    
    /* 좋아요 */
    function like_func(){
      var frm_read = $('#frm_read');
      var boardno = $('#boardno').val();
      console.log("boardno" + boardno);
      
      $.ajax({
        url: "../like",
        type: "GET",
        cache: false,
        dataType: "json",
        data: 'boardno=' +boardno,
        success: function(data) {
          var msg = '';
          var like_img = '';
          msg += data.msg;
          alert(msg);
          
          if(data.like_check == 0){
              like_img = "../resources/images/starb.png";
            } else {
              like_img = "../resources/images/staro.png";
            }
          $('#like_img', frm_read).attr('src', like_img);
          $('#like_check').html(data.like_check);

        },
        error: function(request, status, error){
          alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
        }
      });
    }

      function login_need(){
      	alert('로그인이 필요합니다');
      	
     }