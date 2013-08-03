<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>MyWebapp</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
</head>
<body>
<h1><a href="<c:url value="/" />">MyWebapp</a></h1>
<p>Hello World!</p>
<br>
Check out these links:
<br>
<a href="<c:url value="/example/simple/3" />">simple with 3 as input</a>
<br>
<a href="<c:url value="/example/view/5" />">view with 5 as input</a>
<br>
<a href="<c:url value="/example/asynchronous/2147483647" />">asynchronous with INT_MAX as input</a>
</body>
</html>