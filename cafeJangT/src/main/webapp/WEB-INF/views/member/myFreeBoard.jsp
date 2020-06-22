<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
<h2>내가 쓴 글(자유게시판)</h2>
	<h3>자유로운 정보를 공유하는 게시판입니다.</h3>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<c:choose>
				<c:when test="${empty myFreeBoardList}">
					<tr>
						<td colspan="5">${message}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${myFreeBoardList}" var="freeBoardVO">
						<tr>
							<td>${freeBoardVO.fseq}</td>
							<td>
								<a href="my_free_board_view?fseq=${freeBoardVO.fseq}" style="text-decoration: none; font-weight:bold;" class="img_title">
									${freeBoardVO.subject}
								</a>
							</td>
							<td>${freeBoardVO.m_id}</td>
							<td><fmt:formatDate value="${freeBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
							<td>${freeBoardVO.hit}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
		<input	type="button" value="메인으로" class="cancel" onclick="location.href='index'">
		<input	type="button" value="뒤로가기" class="cancel" onclick="history.go(-1)">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>