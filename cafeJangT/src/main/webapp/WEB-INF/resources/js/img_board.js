function NumFormat(t) // 원 단위, 찍어주기
{
	s = t.value;
	s = s.replace(/\D/g, '');
	l = s.length - 3;
	while (l > 0) {
		s = s.substr(0, l) + ',' + s.substr(l);
		l -= 3;
	}
	t.value = s;
	return t;
}

// 폼에 입력이 올바른지 판단한다.
// productWrite.jsp에서 사용한다.
function img_go_save() 
{
	var theForm = document.formm;
	if (theForm.subject.value == '') {
		alert('제목을 입력하세요.');
		theForm.subject.focus();
		return false;
	} else if (theForm.thum_img1.value == '') {
		alert('대표이미지의 첨부파일을 선택하세요.');
		theForm.thum_img1.focus();
		return false;
	} else if (theForm.content.value == '') {
		alert('내용을 입력하세요.');
		theForm.content.focus();
		return false;
	} else if (theForm.image11.value == '') {
		alert('이미지 1의 첨부파일을 선택하세요');
		theForm.image11.focus();
		return false;
	} else if (theForm.image1_name.value == '') {
		alert('이미지 1의 상품명을 입력하세요');
		theForm.image1_name.focus();
		return false;
	} else if (theForm.image1_brand.value == '') {
		alert('이미지 1의 브랜드명을 입력하세요');
		theForm.image1_brand.focus();
		return false;
	} else if (theForm.image1_price.value == '') {
		alert('이미지 1의 가격을 입력하세요');
		theForm.image1_price.focus();
		return false;
	} else if (theForm.image22.value == '') {
		alert('이미지 2의 첨부파일을 선택하세요');
		theForm.image22.focus();
		return false;
	} else if (theForm.image2_name.value == '') {
		alert('이미지 2의 상품명을 입력하세요');
		theForm.image2_name.focus();
		return false;
	} else if (theForm.image2_brand.value == '') {
		alert('이미지 2의 브랜드명을 입력하세요');
		theForm.image2_brand.focus();
		return false;
	} else if (theForm.image2_price.value == '') {
		alert('이미지 2의 가격을 입력하세요');
		theForm.image2_price.focus();
		return false;
	} else if (theForm.image33.value == '') {
		alert('이미지 3의 첨부파일을 선택하세요');
		theForm.image33.focus();
		return false;
	} else if (theForm.image3_name.value == '') {
		alert('이미지 3의 상품명을 입력하세요');
		theForm.image3_name.focus();
		return false;
	} else if (theForm.image3_brand.value == '') {
		alert('이미지 3의 브랜드명을 입력하세요');
		theForm.image3_brand.focus();
		return false;
	} else if (theForm.image3_price.value == '') {
		alert('이미지 3의 가격을 입력하세요');
		theForm.image3_price.focus();
		return false;
	} else {
		alert('게시글을 등록하였습니다.');
		
		theForm.encoding = "multipart/form-data";
		theForm.image1_price.value = removeComma(theForm.image1_price);
		theForm.image2_price.value = removeComma(theForm.image2_price);
		theForm.image3_price.value = removeComma(theForm.image3_price);
		
		theForm.action = "img_board_write";
		theForm.submit();
	}
}

function removeComma(input) // ,을 빼고 값을 다시 넣어준다.
{
	return input.value.replace(/,/gi, "");
}

function img_go_mod(ibseq) {
	var theForm = document.formm;
	theForm.action = "img_board_update_form?ibseq="+ibseq;
	theForm.submit();
}

function img_go_mod_save() 
{
	var theForm = document.formm;
	
	if (theForm.subject.value == '') {
		alert('제목을 입력하세요.');
		theForm.subject.focus();
		return false;
	} else if (theForm.thum_img1.value == '') {
		alert('대표이미지의 첨부파일을 선택하세요.');
		theForm.thum_img1.focus();
		return false;
	} else if (theForm.content.value == '') {
		alert('내용을 입력하세요.');
		theForm.content.focus();
		return false;
	} else if (theForm.image11.value == '') {
		alert('이미지 1의 첨부파일을 선택하세요');
		theForm.image11.focus();
		return false;
	} else if (theForm.image1_name.value == '') {
		alert('이미지 1의 상품명을 입력하세요');
		theForm.image1_name.focus();
		return false;
	} else if (theForm.image1_brand.value == '') {
		alert('이미지 1의 브랜드명을 입력하세요');
		theForm.image1_brand.focus();
		return false;
	} else if (theForm.image1_price.value == '') {
		alert('이미지 1의 가격을 입력하세요');
		theForm.image1_price.focus();
		return false;
	} else if (theForm.image22.value == '') {
		alert('이미지 2의 첨부파일을 선택하세요');
		theForm.image22.focus();
		return false;
	} else if (theForm.image2_name.value == '') {
		alert('이미지 2의 상품명을 입력하세요');
		theForm.image2_name.focus();
		return false;
	} else if (theForm.image2_brand.value == '') {
		alert('이미지 2의 브랜드명을 입력하세요');
		theForm.image2_brand.focus();
		return false;
	} else if (theForm.image2_price.value == '') {
		alert('이미지 2의 가격을 입력하세요');
		theForm.image2_price.focus();
		return false;
	} else if (theForm.image33.value == '') {
		alert('이미지 3의 첨부파일을 선택하세요');
		theForm.image33.focus();
		return false;
	} else if (theForm.image3_name.value == '') {
		alert('이미지 3의 상품명을 입력하세요');
		theForm.image3_name.focus();
		return false;
	} else if (theForm.image3_brand.value == '') {
		alert('이미지 3의 브랜드명을 입력하세요');
		theForm.image3_brand.focus();
		return false;
	} else if (theForm.image3_price.value == '') {
		alert('이미지 3의 가격을 입력하세요');
		theForm.image3_price.focus();
		return false;
	} else {
		alert('게시글을 수정하였습니다.');
		
		theForm.encoding = "multipart/form-data";
		theForm.image1_price.value = removeComma(theForm.image1_price);
		theForm.image2_price.value = removeComma(theForm.image2_price);
		theForm.image3_price.value = removeComma(theForm.image3_price);
		
		theForm.action = "img_board_update";
		theForm.submit();
	}
}

function img_delete(ibseq) {
	var check = confirm('정말 삭제하시겠습니까?');
	if(check) {
		location.href="img_board_delete?ibseq="+ibseq;
	}
}