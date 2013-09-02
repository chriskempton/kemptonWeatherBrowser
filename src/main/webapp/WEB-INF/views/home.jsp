<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Kempton Weather Browser</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
</head>
<body>
<h1><a href="<c:url value="/" />">Kempton Weather Browser</a></h1>
<br>
Get the next 7 days' temperature forecasts...
<br>
<a href="<c:url value="/forecasts/json/48103" />">as a JSON array</a>
<br>
<a href="<c:url value="/output/htmltable/48103" />">as an HTML table</a>
<br>
<a href="<c:url value="/output/xml/48103" />">as an XML document</a>
</body>
</html>