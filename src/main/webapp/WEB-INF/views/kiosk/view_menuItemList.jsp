<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카페키오스크 메인 화면</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link href="<c:url value='/resources/css/default.css'/>" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/kiosk/main.css'/>" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
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

<div class="category_container">
<c:forEach var="category" items="${categoryList}">
	<div class="category_name_box">
	<button type="button" class="category_name" value="${category.cid}">${category.name}</button>
	</div>
</c:forEach>
</div>

<div class="menu_container">
<ul class="menuItem_ul">
	<c:forEach var="menuItem" items="${menuItem }">
		<li class="menuItem">
            <a class="modal-btn" data-toggle="modal" data-target="#exampleModal" >
               <img src="/java-cafe/resources/menuImg/${menuItem.menuImgName}">
               <p class="menu_text">${menuItem.menuName}</p>
               <p class="menu_text">${menuItem.menuPrice }원</p>
            </a>
         </li>
	</c:forEach>
</ul>
</div>

<%-- <div class="cart_container">
	<div class="menu-content">
	<h5 class="cart_title">장바구니</h5>
	<div class="menu_img">
		<img src='<c:url value="/resources/menuImg/${menuItem.menuImgName}"/>'>
	</div>
	<div class="menu_detail">
		<span>가격 : </span>
		<span class="menu_price">${menuItem.menuPrice}원</span>
	</div>
	<label>구매 수량</label>
	<input type="number" class="buyCount" name="buyCount" value="1"/><br>
	<button type="button" class="plus_btn default_button">+</button>
	<button type="button" class="minus_btn default_button">-</button>
</div> --%>


<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<div class="cart-container">
	<h5 class="cart_title">장바구니</h5><br>
	<c:forEach var="cart" items="${cartList}">
         <div class="cart_content">
            <div class="close close1"></div>
            <img src="/java-cafe/resources/menuImg/${cart.menuImgName}" style="width: 150px; height: 150px;">
            <div class="cart_content_text">
               <span class="cart_menuName">${cart.menuItemName}</span><br>
               <span class="cart_menuPrice">${cart.menuPrice * cart.purchaseQuantity}원</span><br>
               <span class="cart_buyCount">${cart.purchaseQuantity}개</span><br>
            </div>
         </div>
      </c:forEach><br>
      <div class="cart_button">
	<button type="button"class="incart default_button" value="카트에 담기">결제하기</button>
      <span class="total_price"></span>
      </div>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value='/resources/js/main.js'/>"></script>
   
   
</body>
</html>