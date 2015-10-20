<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/html/init.jsp"%>

<c:choose>
	<c:when test="${not empty heroes}">
		<ul>
		<c:forEach items="${heroes}" var="hero">
			<li>
				<h1><c:out value="${hero.name}" /></h1>
				<p><c:out value="${hero.description}" /></p>
			</li>
		</c:forEach>
		</ul>
	</c:when>
	<c:otherwise>
		No Heroes, the city is in chaos!
	</c:otherwise>
</c:choose>
