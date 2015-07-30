<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List CDI</title>
<style>
body, input { background: #FFFFDD; 
	font-family: verdana; font-size: 24px; font-weight: 300;
}
</style>
</head>
<body>

<center>
<h1>Hello CDI 5</h1>
<c:forEach var="name" items="${list}">
<li><c:out value="${name}"/><br/>
</c:forEach>

</body>
</html>
