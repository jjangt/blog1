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
				<th>작성자</th>
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
							<td>
								<a href="admin_qna_view?qseq=${qnaVO.qseq}" style="text-decoration: none; font-weight:bold;">
									${qnaVO.subject}
								</a>
							</td>
							<c:choose>
								<c:when test="${qnaVO.useyn == '1'}">	
									<td>${qnaVO.m_id}</td>
								</c:when>
								<c:otherwise>
									<td>${qnaVO.m_id}<span style="color:red;">(탈퇴회원)</span></td>
								</c:otherwise>
							</c:choose>
							<td><fmt:formatDate value="${qnaVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="메인으로" class="cancel" onclick="location.href='admin_main'">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../../footer.jsp"%>