window.onload=function(){
	var btn=document.getElementById('navbar_toggleBtn');
	var menu=document.getElementById("navbar_menu");
	var logout=document.getElementById("navbar_admin_logOut");
	var block=document.getElementById("block");
	
	//  클릭시 작동
	btn.onclick=function(){
		menu.style.display="flex";
		logout.style.display="block";
		block.style="height:400px;";
	}
	// 더블 클릭시 작동
	btn.ondblclick=function(){
		menu.style="@media screen and (max-width: 768px){display='none'}";
		logout.style="@media screen and (max-width: 768px){display='none'}";
		block.style="height:100px;";
	}
	
	
}



/* 회원 정보 수정  페이지*/
//input을 숫자로 받은경우 길이 제한 
function Number_MaxLength(e){
	if(e.value.length>e.maxLength){
		e.value=e.value.slice(0,e.maxLength);
	}
}

// 회원정보 수정
function Check_memAdmin(){
		
	$id=$.trim($('#id').val());
	// 아이디
	if($id.length==0){
		alert("아이디를 입력해주세요!");
		$('#id').val('').focus();
		return false;
	}


	
	$pw1=$.trim($('#pw').val());
	// 비밀번호 최소 길이
	if($pw1.length<=7){
		alert("비밀번호는 최소 8자리 이상으로 생성해주세요!");
		$('#pw').val('').focus();
		return false;
	}
	if($pw1 == $id){
		alert("아이디와 비밀번호는 서로 달라야합니다!");
		$('#pw').val('').focus();
		return false;
	}
	

	$pw2=$.trim($('#pw2').val());
	// 비밀번호 일치여부
	if($pw1 != $pw2){
		alert("비밀번호가 틀립니다.");
		$('#pw2').val('').focus();
		return false;
	}
	
	$name=$.trim($('#name').val());
	if($name.length==0){
		alert("이름을 입력해주세요!");
		$('#name').val('').focus();
		return false;
	}
	
	$jumin=$.trim($('#jumin1').val());
	if($jumin.length<=3){
		alert("출생년도 4자리를 입력해주세요!");
		$('#jumin1').val('').focus();
		return false;
	}
	
	$email=$.trim($('#email').val());
	if($email.length==0){
		alert("이메일을 입력해주세요!");
		$('#email').val('').focus();
		return false;
	}
	
	// 이메일 유효검사
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if($email == '' || !re.test($email)){
		alert("올바른 이메일 주소를 입력하세요");
		return false;
	}
	
	
	$tel=$.trim($('#tel').val());
	if($tel.length<=10){
		alert("휴대전화를 입력해주세요!");
		$('#tel').val('').focus();
		return false;
	}
	
	$state=$.trim($('#mem_state').val());
	if($mem_state.length==0){
		alert("계정상태를 입력해주세요!");
		$('#mem_state').val('').focus();
		return false;
	}	
	
	
	
}

/* 회원 정보 수정  페이지*/

/*  공지사항 글쓰기 */
function check_gongji(){
	if($.trim($('#title').val())==''){
		alert('제목을 입력해주세요!');
		$('#title').val('').focus();
		return false;
	}
	if($.trim($('#gongji_cont').val())==''){
		alert('글내용을 입력해주세요!');
		$('#gongji_cont').val('').focus();
		return false;
	}	
	
}




