<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%> 
<div class="clear"></div>
<style>
.form-wrap {
	width: 400px;
	height: 300px;
	position: relative;
	margin: 6% auto;
	background: #fff;
	padding: 5px;
	overflow: hidden;
}

#delete {
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
	<form id="delete" class="input-group" method="post" name="formm">
		<fieldset class="log">
			<legend>회원탈퇴</legend>
			<input type="text" class="input-field" name="id" value="${loginUserId}" readonly="readonly"> 
			<input type="password" class="input-field" placeholder="비밀번호를 입력하세요" name="pwd">
			<input type="hidden" name="pwdCheck" value="${loginUserPwd}">
			<br><br>
			<input type="submit" value="탈퇴 완료" class="ad_submit" onclick="return member_delete()"/>
			<input type="button" value="뒤로가기" class="ad_submit" onclick="history.go(-1)">
		</fieldset>
	</form>
</div>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>