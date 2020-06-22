<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
	<h2>1:1 문의 게시판</h2>
	<h3>질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
	<form name="formm" method="post">
		<table id="notice">
			<tr>
				<th>제목</th>
				<td>${qnaVO.subject}</td>
				<th>작성자</th>
				<td>${qnaVO.m_id}</td>
			</tr>
			<tr>
				<th>등록일</th>
				<td><fmt:formatDate value="${qnaVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
				<th>글번호</th>
				<td>${qnaVO.qseq}</td>
			</tr>
			<tr>
				<th>질문내용</th>
				<td colspan="3">${qnaVO.content}
			</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="수정하기" class="submit" onclick="qna_go_mod('${qnaVO.qseq}')">
			<input type="button" value="삭제하기" class="submit" onclick="qna_delete('${qnaVO.qseq}')">
			<input type="button" value="목록보기" class="submit" onclick="location.href='qna_list'"> 
			<input type="button" value="메인으로" class="cancel" onclick="location.href='index'">
		</div>
	</form>
	<%@ include file="../reply/qna_reply.jsp" %>
</article>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>