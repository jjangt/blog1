<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
	<h2>자유게시판</h2>
	<h3>자유로운 정보를 공유하는 게시판입니다.</h3>
	<form name="formm" method="post" action="free_board_write">
		<table id="notice">
			<tr>
				<th>제목</th>
				<td colspan="2"><input type="text" name="subject" size="59"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="2"><textarea rows="8" cols="60" name="content"></textarea></td>
			</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="submit" value="등록" class="submit" onclick="return free_go_save()">
			<input type="button"  value="목록보기" class="submit" onclick="location.href='free_board_list'">
			<input type="button" value="메인으로" class="submit" onclick="location.href='index'">
		</div>
	</form>
</article>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>