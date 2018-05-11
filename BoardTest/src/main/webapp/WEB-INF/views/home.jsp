<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>

</head>
<body>
	<%@ include file="include/member_header.jsp"%>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="member/list.do">회원목록</a>
	<a href="board/list.do">게시판</a>
	<c:if test="${sessionScope.userid eq null}">
			<a href="member/login.do">로그인</a>
	</c:if>
	<c:if test="${sessionScope.userid ne null}">
			<h2>${sessionScope.username}(${sessionScope.userid})님환영합니다.</h2>
			<a href="member/logout.do">로그아웃</a>
	</c:if>


</body>
</html>
