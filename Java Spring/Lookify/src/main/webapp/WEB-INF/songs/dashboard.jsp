<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
	<Div class="container">
		<div >
			<a href="/songs/new">Add New</a>
			<a href="/search/topTen">Top Songs</a>
			<div>
				<form action="/search" method="post">
			    	<input type="search" name="artist">
					<input type="submit" value="Search Artists">
				</form>
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