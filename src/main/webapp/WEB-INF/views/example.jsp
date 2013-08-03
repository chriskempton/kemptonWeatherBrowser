<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>example view</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
</head>
<body>
<h1><a href="<c:url value="/" />">Back to MyWebapp</a></h1>
<p>This is a view!</p>
Your input was "${input}"
<br>
The result from "interestingComputation" is "${interestingComputation}"

</body>
</html>