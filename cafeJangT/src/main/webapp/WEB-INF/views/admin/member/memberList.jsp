<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>

<article>
<h2>회원리스트</h2>
	<h3>회원 관리 페이지입니다.</h3>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>회원등록일</th>
				<th>회원관리</th>
				<th>상태</th>
			</tr>
			<c:choose>
				<c:when test="${empty memberList}">
					<tr>
						<td colspan="5">${message}</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${memberList}" var="memberVO">
						<tr>
							<td>${memberVO.id}</td>
							<td>${memberVO.name}</td>
							<td>${memberVO.email}</td>
							<td>${memberVO.phone}</td>
							<td><fmt:formatDate value="${memberVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
							<c:choose>
								<c:when test="${memberVO.useyn == '1'}">
									<td>
										<a href='javascript:void(0)' onclick="admin_member_delete('${memberVO.id}')" class="btn btn-danger">삭제</a>
									</td>
									<td style="color:blue;">정상회원</td>
								</c:when>
								<c:otherwise>
									<td>
										<a href='javascript:void(0)' onclick="admin_member_reset('${memberVO.id}')" class="btn btn-info">복구</a>
									</td>
									<td style="color:red;">탈퇴회원</td>
								</c:otherwise>
							</c:choose>
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