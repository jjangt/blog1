/**
 * 
 */
function find_id_form() {
	var url = "find_id_form";
	
	window.open(url, "_blank_1",
				"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=500, " +
				"height=300, top=300, left=300");
}

function findMemberId() {
	var frm = document.findId;
	
	if(frm.name.value == "") {
		alert("이름을 입력해주세요!");
		frm.name.focus();
	} else if(frm.email.value == "") {
		alert("이메일을 입력해주세요!");
		frm.email.focus();
	} else {
		frm.action = "find_id";
		frm.submit();
	}
}

function findPassword() {
	var frm = document.findPW;
	
	if(frm.id.value == "") {
		alert("아이디를 입력해주세요!");
		frm.id.focus();
	} else if(frm.name.value == "") {
		alert("이름을 입력해주세요!");
		frm.name.focus();
	} else if(frm.email.value == "") {
		alert("이메일을 입력해주세요!");
		frm.email.focus();
	} else {
		frm.action = "find_pwd";
		frm.submit();
	}
}