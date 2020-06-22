// 폼에 입력이 올바른지 판단한다.
function free_go_save() 
{
	var theForm = document.formm;
	
	if (theForm.subject.value == '') {
		alert('제목을 입력하세요.');
		theForm.subject.focus();
		return false;
	} else if (theForm.content.value == '') {
		alert('내용을 입력하세요.');
		theForm.content.focus();
		return false;
	} else {
		theForm.action = "free_board_write";
		theForm.submit();
	}
}

function free_delete(fseq) {
	var check = confirm('정말 삭제하시겠습니까?');
	if(check) {
		location.href="free_board_delete?fseq="+fseq;
	}
}

function free_go_mod(fseq) {
	var theForm = document.formm;
	theForm.action = "free_board_update_form?fseq="+fseq;
	theForm.submit();
}

function free_go_mod_save() 
{
	var theForm = document.formm;
	
	if (theForm.subject.value == '') {
		alert('제목을 입력하세요.');
		theForm.subject.focus();
		return false;
	} else if (theForm.content.value == '') {
		alert('내용을 입력하세요.');
		theForm.content.focus();
		return false;
	} else {
		alert('게시글을 수정하였습니다.');
		
		theForm.action = "free_board_update";
		theForm.submit();
	}
}

function my_free_delete(fseq) {
	var check = confirm('정말 삭제하시겠습니까?');
	if(check) {
		location.href="my_free_board_delete?fseq="+fseq;
	}
}

function my_free_go_mod(fseq) {
	var theForm = document.formm;
	theForm.action = "my_free_board_update_form?fseq="+fseq;
	theForm.submit();
}

function my_free_go_mod_save() 
{
	var theForm = document.formm;
	
	if (theForm.subject.value == '') {
		alert('제목을 입력하세요.');
		theForm.subject.focus();
		return false;
	} else if (theForm.content.value == '') {
		alert('내용을 입력하세요.');
		theForm.content.focus();
		return false;
	} else {
		alert('게시글을 수정하였습니다.');
		
		theForm.action = "my_free_board_update";
		theForm.submit();
	}
}

function my_free_delete(fseq) {
	var check = confirm('정말 삭제하시겠습니까?');
	if(check) {
		location.href="my_free_board_delete?fseq="+fseq;
	}
}