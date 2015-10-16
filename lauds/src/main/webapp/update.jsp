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

<h3>Update DB</h3>


<form method=post action="save">
<input type=hidden value="${id}" name="id">
Name: <input type=text value="${name}" name="name"><br/>
Place:  <input type=text value="${place}" name="place"><br/>
<input type=submit value="Update">
</form>

<br/><br/>

<form method=post action="delete">
<input type=hidden value="${id}" name="id">
<input type=submit value="Delete">
</form>


</body>  
</html>  
  
