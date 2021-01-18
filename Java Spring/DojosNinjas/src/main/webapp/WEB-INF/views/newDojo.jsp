<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<html>
<body>
<h1>New Dojo</h1>
<form:form action="/dojo" method="post" modelAttribute="dojo">
    <p>
         <form:label path="name">Name: </form:label>
         <form:input path="name" />
         <form:errors path="name" />
    </p>
    <input type="submit" value="create"/>
</form:form>
</body>
</html>