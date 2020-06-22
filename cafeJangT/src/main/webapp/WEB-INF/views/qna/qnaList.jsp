<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
	<h2>1:1 문의 게시판</h2>
	<h3>질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일</th>
			</tr>
			<c:choose>
				<c:when test="${empty qnaList}">
					<tr>
						<td colspan="5">${message}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${qnaList}" var="qnaVO">
						<tr>
							<td>${qnaVO.qseq}</td>
							<td><a href="qna_view?qseq=${qnaVO.qseq}" style="text-decoration: none; font-weight:bold;">
									${qnaVO.subject}</a></td>
							<td><fmt:formatDate value="${qnaVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="1:1 질문하기" class="submit"
				onclick="location.href='qna_write_form'"> <input
				type="button" value="메인으로" class="cancel"
				onclick="location.href='index'">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>