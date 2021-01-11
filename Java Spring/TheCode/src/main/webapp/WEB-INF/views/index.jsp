<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<c:out value="${error}" escapeXml="false"/>
<h2>What is the code?</h2>
<form method="POST" action="/process">
    <input type="text" name="code">
    <br>
    <button>Try Code</button>
</form>
</body>
</html>