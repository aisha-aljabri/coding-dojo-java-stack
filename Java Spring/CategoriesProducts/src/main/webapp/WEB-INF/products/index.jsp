<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/">Categories</a></h3>
		</nav>
		<h2>All Products</h2>
		<ul>
		<c:forEach items="${ products }" var="prod">
			<li><a href="products/${ prod.id }">${ prod.name }</a></li>		
		</c:forEach>
		</ul>
		
		<h2>All Categories</h2>
		<ul>
		<c:forEach items="${ categories }" var="cat">
			<li><a href="categories/${ cat.id }">${ cat.name }</a></li>		
		</c:forEach>
		</ul>
	</div>
</body>
</html>