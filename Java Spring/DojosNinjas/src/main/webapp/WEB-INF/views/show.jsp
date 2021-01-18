<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
	<div>
		<h1><c:out value="${dojo.name }"/> </h1>
	</div>
	<div>
		<table>
		  <thead>
		    <tr>
		      <th>First Name</th>
		      <th>Last Name</th>
		      <th>Age</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${dojo.ninjas}" var="dojo" >
			    <tr>
			      
			      <td> ${dojo.firstName} </td>
			      <td> ${dojo.lastName} </td>
			      <td> ${dojo.age} </td>
			    </tr>
			</c:forEach>
		   
		</table>		
	</div>
</body>
</html>