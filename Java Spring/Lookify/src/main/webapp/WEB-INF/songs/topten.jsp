<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<div>
		<div>
			<h2>Top Ten Songs:</h2>
			<a href="/dashboard"><h2>Dashboard</h2></a>
		</div>
		<ul>
			<c:forEach items="${songs}" var="song">
				<li>
					<h2><c:out value="${song.rating}"/> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/></h2>
				</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>