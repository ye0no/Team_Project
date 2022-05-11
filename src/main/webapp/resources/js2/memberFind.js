
function id_check(){
	if($.trim($('#username').val())==''){
		alert('이름 입력해주세용!');
		$('#username').val('').focus();
		return false;
	}
	if($.trim($('#tel1').val())==''){
		alert('전화번호를 입력하세요!');
		$('#tel1').val('').focus();
		return false;
	}
	if($.trim($('#tel2').val())==''){
		alert('전화번호를 입력하세요!');
		$('#tel2').val('').focus();
		return false;
	}
	if($.trim($('#tel3').val())==''){
		alert('전화번호를 입력하세요!');
		$('#tel3').val('').focus();
		return false;
	}
	
}

// 비번찾기
function pwd_check(){
	if($.trim($('#username').val())==''){
		alert('이름 입력해주세용!');
		$('#username').val('').focus();
		return false;
	}
	if($.trim($('#userID').val())==''){
		alert('아이디를 입력해주세용!');
		$('#userID').val('').focus();
		return false;
	}
}

// input 숫자 길이 제한
function Number_MaxLength(e){
	if(e.value.length>e.maxLength){
		e.value=e.value.slice(0,e.maxLength);
	}
}
