<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<div class="clear"></div>
<article>
	<h2>스타일 공유</h2>
	<h3>패션 스타일 사진과 코디 정보를 공유한는 게시판입니다.</h3>
	<form name="formm" method="post" action="img_board_update" enctype="multipart/form-data">
	<input type="hidden" name="ibseq" value="${imgBoardVO.ibseq}">
	<input type="hidden" name="m_id" value="${imgBoardVO.m_id}">	
		<table id="notice">
			<tr>
				<th>제목</th>
				<td colspan="2"><input type="text" name="subject" size="59" value="${imgBoardVO.subject}"></td>
			</tr>
			<tr>
				<th>대표사진</th>
				<td colspan="2">
					<input type="file" name="thum_img1" value="${imgBoardVO.thum_img}">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="2"><textarea rows="8" cols="60" name="content">${imgBoardVO.content}</textarea></td>
			</tr>
			<tr>
				<th rowspan="5">이미지1</th>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="image11" value="${imgBoardVO.image1}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image1_name" placeholder="상품명 입력" value="${imgBoardVO.image1_name}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image1_brand" placeholder="브랜드명 입력" value="${imgBoardVO.image1_brand}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image1_price" onKeyUp='NumFormat(this)' placeholder="가격 입력" value="${imgBoardVO.image1_price}"/></td>
			</tr>
			<tr>
				<th rowspan="5">이미지2</th>
			</tr>
			<tr>
				<td><input type="file" name="image22" value="${imgBoardVO.image2}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image2_name" placeholder="상품명 입력" value="${imgBoardVO.image2_name}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image2_brand" placeholder="브랜드명 입력" value="${imgBoardVO.image2_brand}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image2_price" onKeyUp='NumFormat(this)' placeholder="가격 입력" value="${imgBoardVO.image2_price}"/></td>
			</tr>
			<tr>
				<th rowspan="5">이미지3</th>
			</tr>
			<tr>
				<td><input type="file" name="image33" value="${imgBoardVO.image3}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image3_name" placeholder="상품명 입력" value="${imgBoardVO.image3_name}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image3_brand" placeholder="브랜드명 입력" value="${imgBoardVO.image2_brand}"/></td>
			</tr>
			<tr>
				<td><input type="text" name="image3_price" onKeyUp='NumFormat(this)' placeholder="가격 입력" value="${imgBoardVO.image3_price}"/></td>
			</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float: right">
			<input type="submit" value="수정 완료" class="submit" onclick="return img_go_mod_save()">
			<input type="button"  value="목록보기" class="submit" onclick="location.href='img_board_list'">
			<input type="button" value="메인으로" class="submit" onclick="location.href='index'">
		</div>
	</form>
</article>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>