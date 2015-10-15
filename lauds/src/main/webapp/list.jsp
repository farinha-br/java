<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
  <head>  
  <title>Show All</title>  
    <style>
  body { margin-left: 50px; font-family: georgia, sans-serif; }
  </style>
  </head>  
  
<body>  

<h3>List DB</h3> &nbsp; <a href="list">Show All</a>
<form method=post action="search">
<input type=text name="search_name" size=30 maxlength=30><input type=submit value="Search">
</form>
<hr/>
<a href="add.jsp">Add People</a><br/>

<table border=1> 
    <c:forEach items="${folks}" var="people"> 
        <tr> 
            <td><a href="upd?id=${people.id}">${people.name}</a></td> 
            <td>${people.place}</td> 
        </tr> 
    </c:forEach> 
</table> 

</body>  
</html>  
  
