<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
	<h2>1:1 문의 게시판</h2>
	<h3>질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
	<form name="formm" method="post" action="qna_update">
		<fieldset class="qna_reg">
				<legend>문의 작성</legend>
				<label>제목</label> 
				<input type="text" name="subject" size="59" value="${qnaVO.subject}"><br>
				<label>내용</label>
				<textarea rows="8" cols="60" name="content">${qnaVO.content}</textarea>
				<br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="submit" value="수정 완료" class="submit" onclick="return qna_go_mod_save()">
			<input type="button"  value="목록보기" class="submit" onclick="location.href='qna_list'">
			<input type="button" value="메인으로" class="submit" onclick="location.href='index'">
		</div>
		
		<input type="hidden" name="qseq" value="${qnaVO.qseq}">
	</form>
</article>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>