
// input을 숫자로 받은경우 길이 제한 
function Number_MaxLength(e){
	if(e.value.length>e.maxLength){
		e.value=e.value.slice(0,e.maxLength);
	}
}


//회원가입 검사
function CheckWrite(){
		
	$id=$.trim($('#id').val());
	// 아이디
	if($id.length==0){
		alert("아이디를 입력해주세요!");
		$('#id').val('').focus();
		return false;
	}

	var idChkVal=$("#idchk").val();
	if(idChkVal =="N"){
		alert("중복확인 버튼을 확인해주세요.");
		$('#id').focus();
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
	
}

// 중복체크
function checkId(){

	$mem_id=$.trim($("#id").val());
	
	if($mem_id.length <4){
		alert("아이디는 4글자 이상 입력하세요!");
		return false;
	};
	
	if($mem_id.length>30){
		alert("최대 30글자 이상만 입력해주세요!");
		return false;
	};
$.ajax({	
	url:"member_idCheck", // 서버 주소 파일명
	type: "POST", //서버로 보내는방식
	data : {id : $mem_id}, //좌측 id 피라미터 이름에 우측 $mem_id변수값을 저장
	dataType:"text", //서버의 실행된 결과값을 사용자로 받아오는 방법
	success: function (re){
		if(re==1){ 
			alert("중복된 아이디입니다!");	
			return false;
		}else {
			
			if(confirm("이 아이디를 사용하시겠습니까?")==1){
				$('#idchk').attr("value","Y");
				$('#id').attr("readOnly",true);
			}else{
				alert('다른 아이디를 입력해주세요!');
			}
			
			
		}
	},
	error:function(request,status,error){
		var msg="ERROR <br><br>";
		msg+= request.status+"<br>"+request.responseText+"<br>"+error;
		console.log(msg);
		alert("에러 발생"+msg);
	}
});

}


// 정보 수정


function EditWrite(){
	
	$pw1=$.trim($('#pw').val());
	if($pw1.length<=0){
		alert("비밀번호를 입력해주세요!");
		$('#pw').val('').focus();
		return false;
	}
	// 비밀번호 최소 길이
	if($pw1.length<=7){
		alert("비밀번호는 최소 8자리 이상으로 생성해주세요!");
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
	
	
	
}








function Del_write(){
	
	if($.trim($('#del_pwd').val())==''){
		alert('비밀번호를 입력해주세요!');
		$('#del_pwd').val('').focus();
		return false;
	}
	if($.trim($('#del_cont').val())==''){
		alert('내용을 입력해주세요!');
		$('#del_cont').val('').focus();
		return false;
	}
	
	var result=confirm('정말 탈퇴하시겠습니까?');
	if(result==false){
			window.close();
	
	}
			
}







