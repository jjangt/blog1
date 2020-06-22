/**
 * 
 */
function qna_go_save() {
	
	var theForm = document.formm;
	
	if(theForm.subject.value=="") {
		alert("제목을 입력해 주세요");
		theForm.subject.focus();
		return false;
	} else if(theForm.content.value=="") {
		alert("내용을 입력해 주세요");
		theForm.content.focus();
		return false;
	} else {
		theFrom.action = "qna_write";
		theForm.submit();
	}
}

function qna_delete(qseq) {
	var check = confirm('정말 삭제하시겠습니까?');
	if(check) {
		location.href="qna_delete?qseq="+qseq;
	}
}

function qna_go_mod(qseq) {
	var theForm = document.formm;
	theForm.action = "qna_update_form?qseq="+qseq;
	theForm.submit();
}

function qna_go_mod_save() 
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
		
		theForm.action = "qna_update";
		theForm.submit();
	}
}