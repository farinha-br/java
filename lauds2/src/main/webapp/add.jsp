<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="java.util.*" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
  <head>  
  <title>Add People</title> 
  <style>
  body { margin-left: 50px; font-family: georgia, sans-serif; }
  </style>  
  </head>  
  
<body>  

<h3>Add People</h3>

<form method=post action="dao">
<input type=hidden value="insert" name="action">
Name: <input type=text value="" name="name" size=50 maxlength=50><br/>
Place:  <input type=text value="" name="place" size=50 maxlength=50><br/>
<input type=submit value=" Add ">
</form>

<br/><br/>


</body>  
</html>  
  
