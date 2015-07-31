<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List CDI</title>
<style>
body { background: #FFFFDD; 
	font-family: verdana; font-size: 24px; font-weight: 300;
}
h3 { font-family: verdana; font-size: 24px; font-weight: 300; }
input { font-family: verdana; font-size: 24px; font-weight: 300;
}
</style>
</head>

<body>
	
<center>
<h3>List CDI</h3>
<form method="post"" action="HelloCDI">
Name: <input type="text" name="str" value="Jack"><br/><br/>
<input type="submit"" value="Send">
</form>

</body>
</html>
