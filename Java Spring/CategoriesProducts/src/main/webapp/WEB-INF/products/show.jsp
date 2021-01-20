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
		<h2>${ product.name }</h2>
		<p>${ product.description }</p>
		<h3>Categories</h3>
		<ul>
		<c:forEach items="${ product.categories }" var="cat">
			<li>${ cat.name }</li>			
		</c:forEach>
		</ul>
		<h3>Add Category</h3>
		<form:form action="/associations/products" method="POST" modelAttribute="association">
			<form:input type="hidden" path="product" value="${ product.id }"/>
			<div class="form-group">
		        <form:errors path="category"/>
		        <form:select class="form-control" path="category">
		        <c:forEach items="${ notInCategories }" var="nonCat">
		        	<option value=${ nonCat.id }>${ nonCat.name }</option>
		        </c:forEach>
		        </form:select>
		    </div>
		    <button class="btn btn-primary">Add</button>
		</form:form>
	</div>
</body>
</html>