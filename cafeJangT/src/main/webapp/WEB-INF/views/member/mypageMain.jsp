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

.form-wrap h2 {
	text-align: center;
}

.input-group {
	position: relative;
	left: -35%;
    width: 280px;
	text-align: center;
}

.input-field {
	width: 100%;
	padding: 10px 0;
	margin: 5px 0;
	border-bottom: 1px solid #A593E0;
	outline: none;
	background: transparent;
}
</style>
<div class="form-wrap">
	<h2>마이페이지</h2>
	<div class="input-group">
		<form name="formm" method="post">
			<input type="button" value="정보 수정" class="submit" onclick="mypage_go_mod()"><br><br>
			<input type="button" value="내 스타일공유" class="submit" onclick="my_img_board()"><br><br>
			<input type="button" value="내 자유게시글" class="submit" onclick="my_free_board()"><br><br>
			<input type="button" value="회원탈퇴" class="submit" onclick="member_delete_form()">
		</form>
	</div>
</div>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>