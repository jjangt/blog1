<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%> 
<div class="clear"></div>
<style>
.form-wrap {
	width: 400px;
	height: 600px;
	position: relative;
	margin: 6% auto;
	background: #fff;
	padding: 5px;
	overflow: hidden;
}

#login {
    left: 50px;
}

.input-group {
    top: 20px;
    position: absolute;
    width: 280px;
    transition: .5s;
}

.input-field {
    width: 100%;
    padding: 10px 0;
    margin: 5px 0;
    border: none;
    border-bottom: 1px solid #999;
    outline: none;
    background: transparent;
}

.input-button {
	position:absolute;
	left: 15%;
}
</style>
<div class="form-wrap">
	<form id="mypage" action="mypage_update" class="input-group" method="post" name="formm">
		<fieldset class="regist">
			<legend >정보 수정</legend>
			<input type="text" class="input-field" name="id" value="${memberVO.id}" readonly="readonly">
			<input type="password" class="input-field" placeholder="변경할 비밀번호를 입력하세요" name="pwd">
			<input type="password" class="input-field" name="pwdCheck" placeholder="비밀번호를 다시 입력하세요">
			<input type="text" class="input-field" name="name" value="${memberVO.name}" readonly="readonly">
			<input type="email" class="input-field" name="mail_addr" placeholder="${memberVO.email}" value="${memberVO.email}">
			<input type="text" class="input-field" name="phone" placeholder="${memberVO.phone}" value="${memberVO.phone}">
			<br><br>
			<div class="input-button">
				<input type="submit" value="수정 완료" class="submit" onclick="return mypage_go_mod_save()">
				<input type="reset" value="취소" class="cancel">
				<input type="button" value="뒤로가기" class="submit" onclick="history.go(-1)">
			</div>
		</fieldset>
	</form>
</div>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>