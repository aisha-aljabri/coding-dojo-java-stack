<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<Div>
		<div>
			<h2>Songs by artist: <c:out value="${artist}"/></h2>
			<div>
				<form action="/search" method="post">
			    	<input type="search" name="artist">
					<input type="submit" value="Search Artists">
				</form>
				<a href="/dashboard"><h2>Dashboard</h2></a>
			</div>
		</div>
		<table>
		    <thead>
		        <tr>
		            <th>Title</th>
		            <th>Rating</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${songs}" var="song">
		        <tr>
		            <td><a href="songs/${song.id}"><c:out value="${song.title}"/></a></td>
		            <td><c:out value="${song.rating}"/></td>
		            <td><a href="/delete/${song.id}">Delete</a></td>
		        </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</Div>
</body>
</html>