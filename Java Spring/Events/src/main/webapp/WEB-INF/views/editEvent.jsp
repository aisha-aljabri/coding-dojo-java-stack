<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<html>
<body>
<h1>GoT Party</h1>
<h4>Edit Event</h4>
      <form:errors path="event.*"/>
		<form:form action="/events/${event.id}/edit" method="POST" modelAttribute="event">
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
				<Button type="submit">Edit</Button>
			</div>
		</form:form>
</body>
</html>