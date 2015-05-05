<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Objectifs Manage Page</title>
<style>
table,th,td {
    border: 1px solid black;
}
</style>
</head>
<body>
    <%-- Person Add/Edit logic --%>
    <c:if test="${requestScope.error ne null}">
        <strong style="color: red;"><c:out
                value="${requestScope.error}"></c:out></strong>
    </c:if>
    <c:if test="${requestScope.success ne null}">
        <strong style="color: green;"><c:out
                value="${requestScope.success}"></c:out></strong>
    </c:if>
    <c:url value="/addObjectif" var="addURL"></c:url>
    <c:url value="/editObjectif" var="editURL"></c:url>
 
    <%-- Edit Request --%>
    <c:if test="${requestScope.objectif ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            ID: <input type="text" value="${requestScope.objectif.id}"
                readonly="readonly" name="id"><br> 
            Titre: <input type="text" value="${requestScope.objectif.titre}" 
                name="titre"><br>
            Description: <input type="text" value="${requestScope.objectif.description}" 
                name="description"><br>
            Nombre de pas: <input type="text" value="${requestScope.objectif.nombrePas}" 
                name="nombrePas"><br>
            Minutes: <input type="text" value="${requestScope.objectif.minutes}"
                name="minutes"><br>
            Mètres: <input type="text" value="${requestScope.objectif.metres}"
                name="metres"><br>
            Mètres à faire en vélo: <input type="text" value="${requestScope.objectif.veloMetres}"
                name="veloMetres"><br>
            Temps à faire en vélo: <input type="text" value="${requestScope.objectif.veloTemps}"
                name="veloTemps"><br>
            Mètres à faire en marchant: <input type="text" value="${requestScope.objectif.marcheMetres}"
                name="marcheMetres"><br>
            Temps à faire en marchant: <input type="text" value="${requestScope.objectif.marcheTemps}"
                name="marcheTemps"><br>
            Mètres à faire en courant: <input type="text" value="${requestScope.objectif.courseMetres}"
                name="courseMetres"><br>
            Temps à faire en courant: <input type="text" value="${requestScope.objectif.courseTemps}"
                name="courseTemps"><br> <input type="submit"
                value="Edit Objectif">
        </form>
    </c:if>
 
    <%-- Add Request --%>
    <c:if test="${requestScope.objectif eq null}">
        <form action='<c:out value="${addURL}"></c:out>' method="post">
                Titre: <input type="text" name="titre"><br> Description: <input
                type="text" name="description"><br> Nombre de Pas : <input
                type="text" name="nombrePas"><br> Minutes: <input
                type="text" name="minutes"><br> Mètres: <input
                type="text" name="metres"><br> Mètres à faire en vélo: <input
                type="text" name="veloMetres"><br> Temps à faire en vélo: <input
                type="text" name="veloTemps"><br> Mètres à faire en marchant: <input
                type="text" name="marcheMetres"><br> Temps à faire en marchant: <input
                type="text" name="marcheTemps"><br> Mètres à faire en courant: <input
                type="text" name="courseMetres"><br> Temps à faire en courant: <input
                type="text" name="courseTemps"><br> <input type="submit"
                value="Add Person">
        </form>
    </c:if>
 
    <%-- Persons List Logic --%>
    <c:if test="${not empty requestScope.objectifs}">
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Titre</th>
                    <th>Description</th>
                    <th>Nombre de pas</th>
                    <th>Minutes</th>
                    <th>Metres</th>
                    <th>Mètres à faire en vélo</th>
                    <th>Temps à faire en vélo</th>
                    <th>Mètres à faire en marchant</th>
                    <th>Temps à faire en marchant</th>
                    <th>Temps à faire en courant</th>
                    <th>Temps à faire en courant</th>
                </tr>
                <c:forEach items="${requestScope.objectifs}" var="objectif">
                    <c:url value="/editObjectif" var="editURL">
                        <c:param name="id" value="${objectif.id}"></c:param>
                    </c:url>
                    <c:url value="/deleteObjectif" var="deleteURL">
                        <c:param name="id" value="${objectif.id}"></c:param>
                    </c:url>
                    <tr>
                        <td><c:out value="${objectif.id}"></c:out></td>
                        <td><c:out value="${objectif.titre}"></c:out></td>
                        <td><c:out value="${objectif.description}"></c:out></td>
                        <td><c:out value="${objectif.nombrePas}"></c:out></td>
                        <td><c:out value="${objectif.minutes}"></c:out></td>
                        <td><c:out value="${objectif.metres}"></c:out></td>
                        <td><c:out value="${objectif.veloMetres}"></c:out></td>
                        <td><c:out value="${objectif.veloTemps}"></c:out></td>
                        <td><c:out value="${objectif.marcheMetres}"></c:out></td>
                        <td><c:out value="${objectif.marcheTemps}"></c:out></td>
                        <td><c:out value="${objectif.courseMetres}"></c:out></td>
                        <td><c:out value="${objectif.courseTemps}"></c:out></td>
                        <td><a
                            href='<c:out value="${editURL}" escapeXml="true"></c:out>'>Edit</a></td>
                        <td><a
                            href='<c:out value="${deleteURL}" escapeXml="true"></c:out>'>Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</body>
</html>