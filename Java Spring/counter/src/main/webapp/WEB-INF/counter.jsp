<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<p>you have visited <a href="http://localhost:8080/">http://localhost:8080 </a> <c:out value="${counter}"/> times </p>
	<a href="http://localhost:8080/">test another visit?</a>
</body>
</html>