<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>

<!-- 부트스트랩 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/blog.css">
<script type="text/javascript" src="js/findIdAndPassword.js"></script>  
<script type="text/javascript" src="js/qna.js"></script>  
<script type="text/javascript" src="js/img_board.js"></script>  
<script type="text/javascript" src="js/free_board.js"></script>  
<script type="text/javascript" src="js/member.js"></script>
<script type="text/javascript" src="js/admin.js"></script>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<Script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></Script>
<script src="<c:url value="js/bootstrap.min.js"/>"></script>
<script type="text/javascript">
	function logout() {
		alert("로그아웃 되었습니다.");
		document.location.href="admin_logout";
	}
	
	function userLogout() {
		alert("관리자 로그아웃 되었습니다.");
		document.location.href="userPage";
	}
</script>
</head>
<body>
	<div id="wrap">
		<!-- 헤더파일 들어가는 곳 시작 -->
		<header>
			<nav id="top_menu">
				<ul>
					<c:choose>
						<c:when test="${empty sessionScope.adminUser}">
							<li>								
								<a style="width: 100px;" href="userPage">사용자</a>&nbsp;|
								<a style="width: 100px;" href="admin_login_form">관리자로그인</a>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="adminPage_view">	
									<b style="color: #04B45F;">
										${sessionScope.adminUser.name}(${sessionScope.adminUser.id})
									</b>
								</a>
									<b>님</b>&nbsp;|
								<a style="width: 100px;" href="userPage" onclick="userLogout()">사용자페이지</a>&nbsp;|
								<a href="admin_logout" onclick="logout()">로그아웃</a>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</nav>
			
			<!-- 로고 들어가는 곳 시작 -->
			<div id="logo">
				<a href="admin_main"> 
				<img src="images/logo.png" , width="180" height="100" alt="관리자페이지" />
				</a>
			</div>
			<!-- 로고 들어가는 곳 끝 -->
			
			<nav id="category_menu">
				<ul>
					<li><a href="admin_main">관리자홈</a></li>
					<li><a href="admin_img_board_list">스타일공유</a></li>
					<li><a href="admin_free_board_list">자유게시판</a></li>
					<li><a href="admin_qna_list">Q&A</a></li>
					<li><a href="admin_member_list">회원리스트</a></li>
				</ul>
			</nav>
			
			<div class="clear"></div>
		</header>