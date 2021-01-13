<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
     <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div id="container">

     <div>
         your gold: <p id="gold"><c:out value="${gold}"/></p>
     </div>
     <form action="process" method="post">
          <div class="box">
                    <h3>Farm</h3>
                    <p>(earns 10-20 gold)</p>
                    <button type="submit" name="place" value="farm">Find Gold!</button>
          </div>
          <div class="box">
                        <h3>Cave</h3>
                        <p>(earns 5-10 gold)</p>
                        <button type="submit" name="place" value="cave">Find Gold!</button>

           </div>
           <div class="box">
                        <h3>House People</h3>
                        <p>(earns 2-5 gold)</p>
                        <button type="submit" name="place" value="house">Find Gold!</button>

            </div>
            <div class="box">
                        <h3>Casino</h3>
                        <p>(earns/takes 0-50 gold)</p>
                        
                        <button type="submit" name="place" value="casino">Find Gold!</button>

            </div>
     </form>
     <div>
         <p>activities:</p>
         <div id="activities">
              <c:forEach items="${activities}" var="item">
                 <c:out value="${item}"  />
                 <br>
              </c:forEach>      
         </div>
     </div>
     </div>
     
</body></html>