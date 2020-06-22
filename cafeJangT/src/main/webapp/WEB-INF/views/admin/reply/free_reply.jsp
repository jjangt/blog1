<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- link rel="stylesheet" href="css/bootstrap.min.css"> -->
</head>
<body>
<div class="container">
    <form id="commentForm" name="commentForm" method="post">
    <br><br>
        <div>
            <div>
                <span><h3>댓글</h3></span> <span id="cCnt"></span>
            </div>
            <div>
                <table class="table">                    
                    <tr>
                        <td>
                            <textarea style="width: 650px" rows="3" cols="30" id="content" name="content" placeholder="댓글을 입력하세요"></textarea>
                            <br>
                            <div>
                                <a href='javascript:void(0)' onClick="return admin_save_comment('${freeBoardVO.fseq }')" class="btn pull-right btn-success">등록</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <input type="hidden" id="fseq" name="fseq" value="${freeBoardVO.fseq }" />        
    </form>
</div>
<div class="container">
    <form id="commentListForm" name="commentListForm" method="post">
        <div id="commentList">
        </div>
    </form>
</div>
<script>
/*
 * 상품평 등록
 */
function admin_save_comment(fseq) {
	if(document.commentForm.content.value=='') {
		alert('댓글의 내용을 입력해주세요.');
		document.commentForm.content.focus();
		return false;
	} else {
		alert('댓글을 등록하였습니다.');
		
		$.ajax({
			type: 'POST',
			url: 'admin_save_comment',
			data: $("#commentForm").serialize(),
			success: function(data) {
				if(data="success") {	// 댓글 등록 성공
					getAdminCommentList();	// 댓글 목록 요청 함수 호출
					$("#content").val("");
				}
			},		
			error: function(request, status, error) {
				alert("error: " + error);
			}
		});
		return false;
	}
}
/*
 * 초기 로딩 시 댓글 목록 불러오기
 */
$(function() {
	getAdminCommentList();
});

/*
 * 댓글 목록 불러오기
 */
function getAdminCommentList() {
	$.ajax({
		type: 'GET',
		url: 'admin_comment_list',
		dataType: "json",
		data: $("#commentForm").serialize(),
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		success: function(data) {
			var html = "";
			var cCnt = data.length;
			
			if(data.length > 0) {
				for(i=0; i<data.length; i++) {
					if(data[i].a_id != null) {
						html += "<div>";
						html += "<div id=\"comment_item\" style=\"color:blue;\"> <strong>작성자: " + data[i].a_id+"(관리자)</strong>&nbsp;"
						html += "&nbsp;<span id=\"write_date\">" + adminDisplayTime(data[i].regdate) + "</span><br>"
						
						html += data[i].content+"<br></div>"
						html += "</div><br><br>";
					} else {
						html += "<div>";
						if(data[i].useyn == '1') {
							html += "<div id=\"comment_item\"> <strong>작성자: " + data[i].m_id+"</strong>&nbsp;"
						} else if(data[i].useyn == '0'){
							html += "<div id=\"comment_item\"> <strong>작성자: " + data[i].m_id+"<span style=\"color:red;\">(탈퇴회원)</span></strong>&nbsp;"							
						}
						html += "&nbsp;<span id=\"write_date\">" + adminDisplayTime(data[i].regdate) + "</span><br>"
						
						html += data[i].content+"<br></div>"
						html += "</div><br><br>";
					}
				}
			} else {
				html += "<div>";
				html += "<div><h6>등록된 댓글이 없습니다.</h6></div>";
				html += "</div>";
			}
			
			$("#cCnt").html(cCnt);	// 댓글의 갯수
			
			$("#commentList").html(html);
		},
		error: function(request, status, error) {
			alert("댓글 목록을 조회하지 못했습니다.");
		}
	});
}

function adminDisplayTime(timeValue) {
	var today = new Date();
	
	// 24시간 이내인지 계산하기 위함
	var gap = today.getTime() - timeValue;
	
	var dateObj = new Date(timeValue);
	var str = "";
	
	// 24시간 이내일 경우 시,분,초만 표시
	if (gap < (1000 * 60 * 60 * 24)) {
		var hh = dateObj.getHours();
		var mi = dateObj.getMinutes();
		var ss = dateObj.getSeconds();
		
		return [ (hh>9 ? '' : '0') + hh, ':', (mi>9 ? '' : '0') + mi, ':',
				(ss>9 ? '' : '0') + ss].join('');
	} else {
		var yy = dateObj.getFullYear();
		var mm = dateObj.getMonth() + 1;
		var dd = dateObj.getDate();
		
		return [ yy, '/', (mm>9 ? '':'0') + mm, '/',
				(dd>9 ? '':'0') + dd].join('');
	}
}

</script>
</body>
</html>
