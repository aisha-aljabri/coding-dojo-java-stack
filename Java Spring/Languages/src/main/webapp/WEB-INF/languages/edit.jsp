<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<body>
	<div id="container">
	<div id="top">
		<a href="/languages"><h1>Dashboard</h1></a>
		<a href="/languages/${language.id}/delete"><h1>Delete</h1></a>
	</div>
		<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		    <input type="hidden" name="_method" value="put">
			    <p>
			        <form:label path="name">Name</form:label>
			        <form:input path="name"/>
			        <form:errors path="name"/>

			    </p>
			    <p>
			        <form:label path="creator">Creator</form:label>
			        <form:input path="creator"/>
    				<form:errors  path="creator"/>
			    </p>
			    <p>
			        <form:label path="version">Version</form:label>
			        <form:input path="version"/>
     		 		<form:errors path="version"/>
			    </p>
		    <input id="btn" type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>