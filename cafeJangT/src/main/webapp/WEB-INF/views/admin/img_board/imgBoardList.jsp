<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
<h2>스타일 공유</h2>
	<h3>패션스타일 사진과 코디 정보를 공유하는 게시판입니다.</h3>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>번호</th>
				<th>대표사진/제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>		
			<c:choose>
				<c:when test="${empty imgBoardList}">
					<tr>
						<td colspan="5">${message}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${imgBoardList}" var="imgBoardVO">
						<tr>
							<td>${imgBoardVO.ibseq}</td>
							<td>
								<a href="admin_img_board_view?ibseq=${imgBoardVO.ibseq}" style="text-decoration: none; font-weight:bold;" class="img_title">
									<span class="thum">
										<img src="thum_img/${imgBoardVO.thum_img}" alt="썸네일"/>
									</span><br>
									${imgBoardVO.subject}
								</a>
							</td>
							<c:choose>
								<c:when test="${imgBoardVO.useyn == '1'}">
									<td>${imgBoardVO.m_id}</td>
								</c:when>
								<c:otherwise>
									<td>${imgBoardVO.m_id}<span style="color:red;">(탈퇴회원)</span></td>
								</c:otherwise>
							</c:choose>
							<td><fmt:formatDate value="${imgBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
							<td>${imgBoardVO.hit}</td>
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