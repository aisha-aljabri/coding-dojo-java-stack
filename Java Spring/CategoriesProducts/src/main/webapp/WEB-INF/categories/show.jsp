<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<body>
	<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/">Categories</a></h3>
		</nav>
		<h2>${ category.name }</h2>
		<h3>Products</h3>
		<ul>
		<c:forEach items="${ category.products }" var="product">
			<li>${ product.name }</li>			
		</c:forEach>
		</ul>
		<h3>Add Product</h3>
		<form:form action="/associations/categories" method="POST" modelAttribute="association">
			<form:input type="hidden" path="category" value="${ category.id }"/>
			<div class="form-group">
		        <form:errors path="product"/>
		        <form:select class="form-control" path="product">
		        <c:forEach items="${ notInProducts }" var="nonPro">
		        	<option value=${ nonPro.id }>${ nonPro.name }</option>
		        </c:forEach>
		        </form:select>
		    </div>
		    <button class="btn btn-primary">Add</button>
		</form:form>
	</div>
</body>
</html>