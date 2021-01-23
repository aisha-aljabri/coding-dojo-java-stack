<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<body>
<p>user - sameState - anotherState - joinsEvent</p>
	<h1>Welcome, <c:out value="${user.firstName}" /></h1>
	<a href="/logout">Logout</a>
	<h3>Here are some events in your State</h3>
	<table>
	<tr>
	          <th>Name</th>
		      <th>Date</th>
		      <th>Location</th>
		      <th>Host</th>
		      <th>Action</th>
	</tr>
	<c:forEach items="${sameState}" var="event">
	<tr>
	          <td><a href="events/${event.id}">${event.name}</a></td>
	          <td><fmt:formatDate value="${event.date }" type="date" pattern="MMMM dd, yyyy" /></td>
	          <td>${event.city}</td>
	          <td>${event.user.firstName}</td>
	          <td>
	          <c:choose>
	          
	               <c:when test="${event.user.id == user.id }">
	               <a href="/events/${event.id}/edit">Edit</a>
	               <a href="/events/${event.id}/delete">Delete</a>
	               </c:when>
	         
	               <c:otherwise>
	                       <c:choose>               
	                            <c:when test="${event.joindUsers.contains(user) }">
	                                   <p>Joined</p>
	                                   <a href="/join/${event.id}/cancel">Cancel</a>
	                            </c:when>
	                            <c:otherwise>
	                                   <a href="/join/${event.id}/add">join</a>
	                            </c:otherwise>
	                       </c:choose>
	               </c:otherwise>
	          </c:choose></td>
	</tr>
	</c:forEach>
	</table>
	
	
	
	
	<table>
	<tr>
	          <th>Name</th>
		      <th>Date</th>
		      <th>Location</th>
		      <th>Host</th>
		      <th>Action</th>
	</tr>
	<c:forEach items="${anotherState}" var="event">
	<tr>
	          <td><a href="events/${event.id}">${event.name}</a></td>
	          <td><fmt:formatDate value="${event.date }" type="date" pattern="MMMM dd, yyyy" /></td>
	          <td>${event.city}</td>
	          <td>${event.user.firstName}</td>
	          <td>
	          <c:choose>
	          
	               <c:when test="${event.user.id == user.id }">
	               <a href="/events/${event.id}/edit">Edit</a>
	               <a href="/events/${event.id}/delete">Delete</a>
	               </c:when>
	         
	               <c:otherwise>
	                       <c:choose>               
	                            <c:when test="${event.joindUsers.contains(user) }">
	                                   <p>Joined</p>
	                                   <a href="/join/${event.id}/cancel">Cancel</a>
	                            </c:when>
	                            <c:otherwise>
	                                   <a href="/join/${event.id}/add">join</a>
	                            </c:otherwise>
	                       </c:choose>
	               </c:otherwise>
	          </c:choose></td>
	</tr>
	</c:forEach>
	</table>
	
	
	    <form:errors path="event.*"/>
		<form:form action="/event" method="POST" modelAttribute="event">
			
			<p>
				<form:label path="name" >Event Name</form:label>
				<form:input path="name" />
			</p>
			<p>
				<form:label path="date" >Date</form:label>
				<form:input path="date" type="date" />
			</p>
			<p>
				<form:label path="city" >City</form:label>
				<form:input path="city" />
			</p>
			<p>
						<form:label path="state" >State</form:label>
						<form:select  path="state">
							<form:option value="AL">Alabama (AL)</form:option>
							<form:option value="TX">Texas (TX)</form:option>
							<form:option value="AZ">Arizona (AZ)</form:option>
							<form:option value="AR">Arkansas (AR)</form:option>
						</form:select>
			</p>
			<br>
			<div >
				<Button type="submit">Create Event</Button>
			</div>
		</form:form>
</body>
</html>