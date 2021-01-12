<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <div class="container">
		<h2>Submitted Info</h2>
		<h3>Name: <c:out value="${name}"/> </h3>
		<h3>Dojo Location: <c:out value="${location}"/> </h3>
		<h3>Favorite Language: <c:out value="${language}"/> </h3>
		<h3>Comment: <c:out value="${comment}"/> </h3>
	</div>
    
</body>
</html>