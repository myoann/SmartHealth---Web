<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/about.jsp" var="about"></c:url>
<c:url value="/contact.jsp" var="contact"></c:url>
<c:url value="/services.jsp" var="services"></c:url>
<c:url value="/help.jsp" var="help"></c:url>

<footer>
	<div id="filter"></div>
	<ul>
            <li><a href='<c:out value="${help}"></c:out>'>Aide</a></li>
            <li><a href='<c:out value="${contact}"></c:out>'>Contact</a></li>
            <li><a href='<c:out value="${services}"></c:out>'>Services</a></li>
            <li><a href='<c:out value="${about}"></c:out>'>A propos</a></li>
	</ul>
</footer>