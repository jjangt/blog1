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
	<form id="login" action="login" class="input-group" method="post" name="formm">
		<fieldset class="log">
			<legend>로그인</legend>
			<input type="text" class="input-field"
				placeholder="아이디를 입력하세요" name="id"> 
			<input type="password" class="input-field" placeholder="비밀번호를 입력하세요" name="pwd">
			<br><br>
			<input type="submit" value="로그인" class="submit">
			<input type="button" value="회원가입" class="cancel" onclick="location='contract'">
			<input type="button" value="회원정보 찾기" class="submit" onclick="find_id_form()"> 
		</fieldset>
	</form>
</div>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>