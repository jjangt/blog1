<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
<h2>내가 쓴 글(스타일 공유)</h2>
	<h3>패션스타일 사진과 코디 정보를 공유하는 게시판입니다.</h3>
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
				<c:when test="${empty myImgBoardList}">
					<tr>
						<td colspan="5">${message}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${myImgBoardList}" var="imgBoardVO">
						<tr>
							<td>${imgBoardVO.ibseq}</td>
							<td>
								<a href="my_img_board_view?ibseq=${imgBoardVO.ibseq}" style="text-decoration: none; font-weight:bold;" class="img_title">
									${imgBoardVO.subject}
								</a>
							</td>
							<td>${imgBoardVO.m_id}</td>
							<td><fmt:formatDate value="${imgBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
							<td>${imgBoardVO.hit}</td>
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