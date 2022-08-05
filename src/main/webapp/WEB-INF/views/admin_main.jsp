<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인</title>
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/kiosk/main.css'/>" />
</head>
<body>
<header id="header">
	<div class="header-left">
		<h3>JAVA CAFE</h3>
	</div>
	<div class="header-right">
		<button class="admin_button" type="button" onclick='location.href="<c:url value='/admin_main'/>"'>관리자 페이지로</button>
	</div>
</header>
<div class="category_container admin_main">
	<button type="button" class="category_name" onclick='location.href="<c:url value='/menuItem/add_menuItem'/>"'>메뉴 추가하기</button>
	<button type="button" class="category_name" onclick='location.href="<c:url value='/menuItem/add_category'/>"'>카테고리 추가하기</button>
	<button type="button" class="category_name" onclick='location.href="<c:url value='/kiosk/view_menuItemList'/>"'>키오스크 메인으로</button>
</div>
</body>
</html>