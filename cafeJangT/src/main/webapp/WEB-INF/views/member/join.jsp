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

</style>
<div class="form-wrap">
	<form id="join" action="join" class="input-group" method="post" name="formm">
		<fieldset class="regist">
			<legend >회원가입</legend>
			<input type="text" class="input-field" placeholder="아이디를 입력하세요" name="id">
			<input type="hidden" name="reid"> <input type="button" value="중복 체크" class="dup" onclick="idcheck()">			
			<input type="password" class="input-field" placeholder="비밀번호를 입력하세요" name="pwd">
			<input type="password" class="input-field" name="pwdCheck" placeholder="비밀번호를 다시 입력하세요">
			<input type="text" class="input-field" name="name" placeholder="이름을 입력하세요">
			<input type="email" class="input-field" name="mail_addr" placeholder="이메일을 입력하세요">
			<input type="text" class="input-field" name="phone" placeholder="전화번호를 입력하세요">
			<br><br>
			<input type="submit" value="회원가입" class="submit" onclick="return go_save()">
			<input type="reset" value="취소" class="cancel">
		</fieldset>
	</form>
</div>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>