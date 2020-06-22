<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
<h2>내 자유게시글 목록</h2>
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
			<c:forEach items="${freeBoardList}" var="freeBoardVO">
				<tr>
					<td>${freeBoardVO.fseq}</td>
					<td>
						<a href="free_board_view?fseq=${freeBoardVO.fseq}" style="text-decoration: none; font-weight:bold;" class="img_title">
							${freeBoardVO.subject}
						</a>
					</td>
					<td>${freeBoardVO.m_id}</td>
					<td><fmt:formatDate value="${freeBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
					<td>${freeBoardVO.hit}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="button" value="글쓰기" class="submit"
				onclick="location.href='free_board_write_form'"> <input
				type="button" value="메인으로" class="cancel"
				onclick="location.href='index'">
		</div>
	</form>
</article>
<div class="clear"></div>
<%@ include file="../footer.jsp"%>