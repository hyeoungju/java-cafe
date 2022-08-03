<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페 키오스크</title>
</head>
<body>
<h3>관리자 메인</h3>
<button type="button" onclick='location.href="<c:url value='/menuItem/add_menuItem'/>"'>메뉴 추가하기</button>
<button type="button" onclick='location.href="<c:url value='/menuItem/add_category'/>"'>카테고리 추가하기</button>
</body>
</html>