<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<div id="container">
	<div id="top">
		<a href="/languages"><h1>Dashboard</h1></a>
	</div>
		<h1><c:out value="${language.name}"/></h1>
		<h1><c:out value="${language.creator}"/></h1>
		<h1><c:out value="${language.version}"/></h1>
		<a href="/languages/${language.id}/edit"><h1>Edit</h1></a>
		<a href="/languages/${language.id}/delete"><h1>Delete</h1></a>
	</div>
</body>
</html>