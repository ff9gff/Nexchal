<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- context 경로 -->
<c:set var="path" value="${pageContext.request.contextPath}" />

<c:if test="${sessionScope.userid ne null}">
	<div style="text-align: center;">
		<h2>${sessionScope.username}(${sessionScope.userid})님환영합니다.</h2>
		<a href="${path}/member/list.do">회원관리</a>
		<a href="${path}/board/list.do">게시판</a>
		<a href="../member/logout.do">로그아웃</a>
	</div>
</c:if>

<c:if test="${sessionScope.userid eq null}">
	<div style="text-align: center;">
		<a href="${path}/member/list.do">회원관리</a>
		<a href="${path}/board/list.do">게시판</a>
		<a href="${path}/member/login.do">로그인</a>
	</div>
</c:if>
<hr>
