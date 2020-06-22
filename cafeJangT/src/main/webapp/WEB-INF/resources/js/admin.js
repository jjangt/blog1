/**
 * 
 */
function admin_check() {
	var check = "1234";
	var theForm = document.formm;
	
	var getCheck = prompt("관리자 인증하세요");
	
	if(check == getCheck) {
		alert("인증에 성공했습니다.");
//		theForm.action = "admin_login_form";
//		theForm.submit();
		document.location.href="admin_login_form";
	} else {
		alert("인증에 실패했습니다.");
	}
	
}

function adminPage_go_mod() {
	var theForm = document.formm;
	theForm.action = "adminPage_update_form";
	theForm.submit();
}

function adminPage_go_mod_save() {
	
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
		theForm.action = "adminPage_update";
		theForm.submit();
		return false;
	}
}

function admin_free_delete(fseq) {
	var check = confirm('게시글을 삭제하시겠습니까?');
	if(check) {
		location.href="admin_free_board_delete?fseq="+fseq;
	}
}

function admin_img_delete(ibseq) {
	var check = confirm('게시글을 삭제하시겠습니까?');
	if(check) {
		location.href="admin_img_board_delete?ibseq="+ibseq;
	}
}

function admin_qna_delete(qseq) {
	var check = confirm('게시글을 삭제하시겠습니까?');
	if(check) {
		location.href="admin_qna_delete?qseq="+qseq;
	}
}

function admin_member_delete(id) {
	var check = confirm('회원을 삭제하시겠습니까?');
	if(check) {
		alert('삭제 완료하였습니다.');
		location.href="admin_member_delete?id="+id;
	}
}

function admin_member_reset(id) {
	var check = confirm('회원을 복구하시겠습니까?');
	if(check) {
		alert('복구 완료하였습니다.')
		location.href="admin_member_reset?id="+id;
	}
}