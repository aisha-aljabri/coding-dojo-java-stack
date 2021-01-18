<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<html>
<body>
<h1>New Ninja</h1>
<form:form action="/ninja"  method="post" modelAttribute="ninja">
    <p>
       <form:label path="dojo">Dojo: </form:label>
	   <form:select  path="dojo">
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo}"> ${dojo.name} </form:option>
				</c:forEach>
	   </form:select>
    </p>
    <p>
       <form:label path="firstName">First Name:</form:label>
	   <form:input path="firstName"/>
	   <form:errors path="firstName"/>
    </p>
    <p>
       <form:label path="lastName">Last Name:</form:label>
	   <form:input path="lastName"/>
	   <form:errors path="lastName"/>
    </p>
    <p>
       <form:label path="age">Age:</form:label>
	   <form:input path="age"/>
	   <form:errors path="age"/>
    </p>
    <input type="submit" value="create"/>	 
</form:form>
</body>
</html>