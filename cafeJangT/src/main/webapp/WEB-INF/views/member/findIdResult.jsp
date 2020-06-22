<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="css/blog.css">
<script type="text/javascript">
	function idok() {
		self.close();
	}
</script>
</head>
<body>
	<div id="window-wrap">
		<h3>아이디 찾기 결과</h3>
		<form method=post name=formm style="margin-right: 0"
			action="id_check_form">
			<div style="margin-top: 20px">
      			<c:if test="${message == 1}">
					사용자 아이디 <input type=text name="id" value="${id}" readonly="readonly">
					<script type="text/javascript">
						opener.document.formm.id.value = "";
					</script><br>
             		회원님의 아이디는 ${id} 입니다.
      			</c:if>
				<c:if test="${message==-1}">
	             	가입하지 않은 회원입니다.
      			</c:if>
			</div>
			<br><br>
			<div class="i-button">
				<input type="button" value="확인" class="cancel" onclick="idok()">
				<input type="button" value="뒤로가기" class="submit" onclick="history.go(-1)">
			</div>
		</form>
	</div>
</body>
</html>