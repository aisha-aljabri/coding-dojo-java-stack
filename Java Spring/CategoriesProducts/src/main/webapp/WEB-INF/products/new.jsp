<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<body class="pl-4">
	<h3 class="display-3"><small><u>New Product</u></small></h3>
	<br>
	
	<form:form action="/product" method="POST" modelAttribute="product">
	
		<p><form:errors path="name" cssClass="alert alert-danger"/></p>
		<p><form:label cssClass="h4 font-weight-normal" path="name">Name</form:label></p>
		<p> <form:input cssClass="form-control col-4" path="name" /> </p>
		
		<p><form:errors path="description" cssClass="alert alert-danger"/></p>
		<p><form:label cssClass="h4 font-weight-normal" path="description">Description</form:label></p>
		<p> <form:textarea cssClass="form-control col-4" path="description" /> </p>
		
		<p><form:errors path="price" cssClass="alert alert-danger"/></p>
		<p><form:label cssClass="h4 font-weight-normal" path="price">price</form:label></p>
		<p> <form:input cssClass="form-control col-4" path="price" /> </p>
		<br>
		<button type="submit" class="btn btn-info">Add Product</button>
		
	</form:form>
</body>
</html>