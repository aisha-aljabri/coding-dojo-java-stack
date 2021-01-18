<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<body>
<a href="dojos/new">Add Dojo</a>
<a href="ninjas/new">Add Ninja</a>
<ul>
<c:forEach items="${dojos}" var="dojo">
    <li><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></li>
</c:forEach> 

</ul>
</body></html>