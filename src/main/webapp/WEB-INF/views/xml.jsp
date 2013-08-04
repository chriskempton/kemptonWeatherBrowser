<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %><%@ page session="false" %><%@ page language="java" contentType="application/xml; charset=UTF-8" pageEncoding="UTF-8"%><?xml version="1.0"?>
<c:choose>
<c:when test="${fn:length(error) gt 0}"><error>${error}</error></c:when>
<c:otherwise>
<forecasts>
<c:forEach var="forecast" items="${forecasts}">
	<forecast>
		<date>${forecast.date}</date>
		<high>${forecast.high}</high>
		<low>${forecast.low}</low>
	</forecast>
</c:forEach>
</forecasts>
</c:otherwise>
</c:choose>