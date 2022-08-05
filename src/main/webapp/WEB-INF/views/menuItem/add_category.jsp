<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리 추가</title>
</head>
<body>
<h3>카테고리 추가</h3>
<form:form method="post" modelAttribute="Category">
	<label>카테고리 이름</label>
	<form:input path="name"/>
	<input type="submit" value="등록하기">
</form:form>
<button type="button" onclick='location.href="<c:url value='/admin_main'/>"'>메인으로</button>
</body>
</html>