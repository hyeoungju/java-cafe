<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴등록 성공</title>
</head>
<body>
<h3>메뉴가 등록되었습니다.</h3>
<label>메뉴 카테고리 : </label> ${categoryName} <br>
<label>메뉴 이름 : </label> ${menuItemCommand.menuName} <br>
<label>메뉴 가격 : </label> ${menuItemCommand.menuPrice} <br>
<label>메뉴 수량 : </label> ${menuItemCommand.menuQuantity} <br>
<button type="button" onclick='location.href="<c:url value='/menuItem/add_menuItem'/>"'>뒤로가기</button>
</body>
</html>