/**
 * 
 */
function go_next() {
	if (document.formm.okon1[0].checked == true) {
		document.formm.action = "join_form";	// 요청 문자열
		document.formm.submit();                // POST 방식 요청
	} else if (document.formm.okon1[1].checked == true) {
		alert("약관에 동의하셔야 합니다!");
	}
}

function idcheck() {
	if (document.formm.id.value == "") {
		alert("아이디를 입력해 주세요!");
		document.formm.id.focus();
		return;
	}
	
	// 중복된 아이디를 확인하는 윈도우를 띄운다.
	var url="id_check_form?id=" + document.formm.id.value;
	
	window.open(url, "_blank_1", 
			"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=330, height=200");
}

function idok() {
	document.formm.action = "id_check_confirmed";	// 요청 문자열
	document.formm.submit();
}

/*
 * 회원 정보 입력 확인 및 가입 처리
 */
function go_save() {
	
	if (document.formm.id.value=="") {
		alert("아이디를 입력해 주세요");
		document.formm.id.focus();
		return false;
	} else if (document.formm.id.value != document.formm.reid.value) {
		alert("아이디 중복확인을 실행해주세요");
		document.formm.id.focus();
		return false;
	} else if (document.formm.pwd.value=="") {
		alert("비밀번호를 입력해 주세요");
		document.formm.pwd.focus();
		return false;
	} else if (document.formm.pwdCheck.value=="") {
		alert("비밀번호 확인을 입력해 주세요");
		document.formm.pwdCheck.focus();
		return false;
	} else if (document.formm.pwd.value != document.formm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다");
		document.formm.pwd.focus();
		return false;
	} else if (document.formm.name.value=="") {
		alert("이름을 입력해 주세요");
		document.formm.name.focus();
		return false;
	} else if (document.formm.mail_addr.value=="") {
		alert("이메일을 입력해 주세요");
		document.formm.mail_addr.focus();
		return false;
	} else {	// 모든 항목이 입력되었으면 회원가입을 요청
		document.formm.action = "join";
		document.formm.submit();
	}
}

function mypage_go_mod() {
	var theForm = document.formm;
	theForm.action = "mypage_update_form";
	theForm.submit();
}

function mypage_go_mod_save() {
	
	var theForm = document.formm;
	
	if(theForm.pwd.value=="") {
		alert("변경할 비밀번호를 입력해 주세요");
		theForm.pwd.focus();
		return false;
	} else if(theForm.pwdCheck.value==""){
		alert("비밀번호 확인을 입력해 주세요");
		theForm.pwdCheck.focus();
		return false;
	} else if(theForm.pwd.value != theForm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다");
		theForm.pwd.focus();
		return false;
	} else {
		alert("정보가 수정되었습니다.");
		theForm.action = "mypage_update";
		theForm.submit();
		return false;
	}
}

function my_free_board() {
	var theForm = document.formm;
	theForm.action = "my_free_board_list";
	theForm.submit();
}

function my_img_board() {
	var theForm = document.formm;
	theForm.action = "my_img_board_list";
	theForm.submit();
}

function member_delete_form() {
	var theForm = document.formm;
	theForm.action = "member_delete_form";
	theForm.submit();
}

function member_delete() {
	var theForm = document.formm;
	
	if(theForm.pwdCheck.value == theForm.pwd.value) {
		var check = confirm('정말 탈퇴하시겠습니까?');
		if(check){
			alert('탈퇴가 완료되었습니다.');
			theForm.action = "member_delete";
			theForm.submit();
		}
		return false;
	} else {
		alert('비밀번호가 일치하지 않습니다.');
		theForm.pwd.focus();
		return false;
	}
}





