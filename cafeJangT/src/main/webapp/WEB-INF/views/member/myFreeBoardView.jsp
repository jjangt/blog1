<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
      <h2>자유게시판</h2>
      <h3>자유로운 정보를 공유하는 게시판입니다.</h3>    
    <form name="formm" method="post">
    <table id="notice">
      <tr>
      	<th>제목</th>
		<td colspan="3">${freeBoardVO.subject}</td>
        <th>작성자</th>
        <td>${freeBoardVO.m_id}</td>
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${freeBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
		<th>글번호</th>
		<td>${freeBoardVO.fseq}</td> 
        <th>조회수</th>
        <td>${freeBoardVO.hit}</td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="5">
        	${freeBoardVO.content}<br><br>
        </td>
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
     	<c:choose>
     		<c:when test="${loginUser.getId() == freeBoardVO.m_id }">
		     	<input type="button" value="수정하기" class="submit" onclick="my_free_go_mod('${freeBoardVO.fseq}')">
		     	<input type="button" value="삭제하기" class="submit" onclick="my_free_delete('${freeBoardVO.fseq}')">
		     	<input type="button"  value="목록보기" class="submit"  onclick="my_free_board()"> 
				<input type="button"  value="메인으로"  class="cancel"  onclick="location.href='index'">
			</c:when>
			<c:otherwise>
				<input type="button"  value="목록보기" class="submit"  onclick="my_free_board()"> 
				<input type="button"  value="메인으로"  class="cancel"  onclick="location.href='index'">
			</c:otherwise>
		</c:choose> 
      </div>
    </form>
    <%@ include file="../reply/free_reply.jsp" %>
  </article>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>