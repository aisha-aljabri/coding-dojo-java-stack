<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<body>
      <div id="container">
      <h1>${event.name}</h1>
      <p>Host: ${event.user.firstName} ${event.user.lastName}</p>
      <p>Date: ${event.date}</p>
      <p>Location: ${event.city} ${event.state}</p>
      <p>people who are attending this event:</p>
      <table>
            <tr>
                <th>Name</th>
                <th>Location</th>
            </tr>
            <c:forEach items="${event.joindUsers}" var="user">
            <tr>
                <td>${user.firstName} ${user.lastName}</td>
                <td>${user.city}, ${user.state}</td>
            </tr>
            </c:forEach>
      </table>
      
      <div id="comments">
           <c:forEach items="${event.comments}" var="comment">
                 <p>${comment.user.firstName} ${comment.user.lastName}: ${comment.text}</p>
                 <p>*****************************************</p>
           </c:forEach>
      </div>
      
      <form:form action="/events/${event.id}" method="post" modelAttribute="comment">
            <form:label path="text">Add Comment:</form:label>
		    <form:textarea path="text"/>
		    <form:errors path="text" />

			<input type="submit" value="Add Comment" />
      </form:form>
                
      </div>
</body>
</html>