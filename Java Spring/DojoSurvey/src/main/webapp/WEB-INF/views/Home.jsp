<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
      <form action="process" method="post">
			<div>
	    		<label>Your Name</label><br>
	  			<input type="text" name="name">
			</div>
			<br>
			<div>
			    <label>Dojo Location</label><br>
			    <select name="location">
			    	<option value="Burbank">Burbank</option>
			    	<option value="San Jose">San Jose</option>
			    </select>
			</div>
			<br>
			<div>
			    <label>Favorite Language</label><br>
			    <select name="language">
			    	<option value="Python">Python</option>
			    	<option value="Java">Java</option>
			    </select>
			</div>
			<br>
			<div>
			   	 <label>Comment (Optional)</label><br>
			  <textarea cols="30" rows="10" name="comment"></textarea>
			</div>
			<br>
			<br>
			<button type="submit">Submit</button>
		</form>
</body></html>