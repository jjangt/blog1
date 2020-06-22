<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
      <h2>스타일 공유</h2>
      <h3>패션 스타일 사진과 코디 정보를 공유한는 게시판입니다.</h3>    
    <form name="formm" method="post">
    <table id="notice">
      <tr>
      	<th>제목</th>
		<td>${imgBoardVO.subject}</td>
        <th>작성자</th>
        <c:choose>
			<c:when test="${imgBoardVO.useyn == '1'}">
				<td>${imgBoardVO.m_id}</td>
			</c:when>
			<c:otherwise>
				<td>${imgBoardVO.m_id}<span style="color:red;">(탈퇴회원)</span></td>
			</c:otherwise>
		</c:choose>
      </tr>
      <tr>
        <th>등록일</th>
        <td> <fmt:formatDate value="${imgBoardVO.regdate}" type="date" pattern="yyyy.MM.dd HH:mm:ss"/></td>
		<th>글번호</th>
		<td>${imgBoardVO.ibseq}</td> 
        <th>조회수</th>
        <td>${imgBoardVO.hit}</td>
      </tr>
      <tr>
        <th>내용</th>
        <td colspan="5">
        	<span class="thum_main">
        		<img src="thum_img/${imgBoardVO.thum_img}"/>
        		<p>착용 이미지</p>
        	</span><br>
        	${imgBoardVO.content}<br><br>
        	<div class="hr-sect">착용 의류</div>
        	<div class="img_detail">
	        	<table>
	        		<tr>
	        			<td><img src="img_board/${imgBoardVO.image1}"/></td>
	        		</tr>
	        		<tr>
	        			<th>상품명</th>
	        			<td>${imgBoardVO.image1_name}</td>
	        		</tr>
	        		<tr>
	        			<th>브랜드명</th>
	        			<td>${imgBoardVO.image1_brand}</td>
	        		</tr>
	        		<tr>
	        			<th>가격</th>
	        			<td><fmt:formatNumber value="${imgBoardVO.image1_price}"/> 원</td>
	        		</tr>
	        	</table>
        	</div>
        	<div class="img_detail">
	        	<table>
	        		<tr>
	        			<td><img src="img_board/${imgBoardVO.image2}"/></td>
	        		</tr>
	        		<tr>
	        			<th>상품명</th>
	        			<td>${imgBoardVO.image2_name}</td>
	        		</tr>
	        		<tr>
	        			<th>브랜드명</th>
	        			<td>${imgBoardVO.image2_brand}</td>
	        		</tr>
	        		<tr>
	        			<th>가격</th>
	        			<td><fmt:formatNumber value="${imgBoardVO.image2_price}"/> 원</td>
	        		</tr>
	        	</table>
        	</div>
        	<div class="img_detail">
	        	<table>
	        		<tr>
	        			<td><img src="img_board/${imgBoardVO.image3}"/></td>
	        		</tr>
	        		<tr>
	        			<th>상품명</th>
	        			<td>${imgBoardVO.image3_name}</td>
	        		</tr>
	        		<tr>
	        			<th>브랜드명</th>
	        			<td>${imgBoardVO.image3_brand}</td>
	        		</tr>
	        		<tr>
	        			<th>가격</th>
	        			<td><fmt:formatNumber value="${imgBoardVO.image3_price}"/> 원</td>
	        		</tr>
	        	</table>
        	</div>
        </td>
      </tr>
    </table>
    <div class="clear"></div>
     <div id="buttons" style="float:right">
		<input type="button" value="삭제하기" class="submit" onclick="admin_img_delete('${imgBoardVO.ibseq}')">
     	<input type="button"  value="목록보기" class="submit"  onclick="location.href='admin_img_board_list'"> 
		<input type="button"  value="메인으로"  class="cancel"  onclick="location.href='admin_main'"> 
      </div>
    </form>
    <%@ include file="../reply/img_reply.jsp" %>
  </article>
<div class="clear"></div>
<%@ include file="../../footer.jsp"%>