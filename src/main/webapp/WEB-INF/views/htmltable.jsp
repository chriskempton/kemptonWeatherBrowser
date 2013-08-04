<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Temperatures</title>
	<link href="<c:url value="/resources/table.css" />" rel="stylesheet"  type="text/css" />		
</head>
<body>
<h1><a href="<c:url value="/" />">Back to Kempton Weather Browser</a></h1>
<h1>For ZIP code ${input}</h1>
<c:choose>
<c:when test="${fn:length(error) gt 0}">${error}</c:when>
<c:otherwise>
<table id="forecasts">
	<tr>
		<th>Date</th>
		<th>High</th>
		<th>Low</th>
	</tr>
<c:forEach var="forecast" items="${forecasts}">
	<tr>
		<td>${forecast.date}</td>
		<td>${forecast.high}</td>
		<td>${forecast.low}</td>
	</tr>
</c:forEach>
</table>
</c:otherwise>
</c:choose>
</body>
</html>