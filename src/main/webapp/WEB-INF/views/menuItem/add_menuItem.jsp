<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 등록하기</title>
</head>
<body>
	<h3>메뉴 등록하기</h3>
	<form:form method="post" modelAttribute="menuItem">
	<label>카테고리 선택</label>
	<form:select path="categoryId">
	<option value="unknown">--선택--</option>
		<form:options 	itemValue="cId"
						itemLabel="cName"
						items="${categoryProviderList}"/>
	</form:select><br>
	
	<label>메뉴 이름</label>
	<form:input path="menuName"/><br>
	<label>메뉴 가격</label>
	<form:input path="menuPrice"/><br>
	<label>메뉴 이미지</label>
	<form:input path="menuImgUrl"/><br>
	<label>메뉴 수량</label>
	<form:input path="menuQuantity"/><br>
	<input type="submit" value="등록하기"/>
</form:form>
</body>
</html>