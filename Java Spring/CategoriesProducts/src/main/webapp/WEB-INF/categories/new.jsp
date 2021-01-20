<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<body class="pl-4">
	<h3 class="display-3"><small><u>New Category</u></small></h3>
	<br>
	<form:form action="/category" method="POST" modelAttribute="category">
	
		<p><form:errors path="name" cssClass="alert alert-danger"/></p>
		<p><form:label cssClass="h4 font-weight-normal" path="name">Name</form:label></p>
		<p> <form:input cssClass="form-control col-4" path="name" /> </p>
		<br>
		<button type="submit" class="btn btn-info">Add Category</button>
		
	</form:form>
	

</body>
</body>
</html>