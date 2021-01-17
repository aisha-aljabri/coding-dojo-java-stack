<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<div>
		<div>
			<a href="/dashboard"><h2">Dashboard</h2></a>
		</div>
		<h2>Title:  <c:out value="${song.title}"/></h2>
		<h2>Artist:  <c:out value="${song.artist}"/></h2>
		<h2>Rating (1-10):  <c:out value="${song.rating}"/></h2>
		<a href="/delete/${song.id}"><h2>Delete</h2></a>
	</div>
</body>
</html>