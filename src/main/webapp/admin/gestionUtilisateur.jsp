<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Persons Manage Page</title>
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
    <c:url value="/addUser" var="addURL"></c:url>
    <c:url value="/editUser" var="editURL"></c:url>
 
    <%-- Edit Request --%>
    <c:if test="${requestScope.utilisateur ne null}">
        <form action='<c:out value="${editURL}"></c:out>' method="post">
            ID: <input type="text" value="${requestScope.utilisateur.id}"
                readonly="readonly" name="id"><br> Name: <input
                type="text" value="${requestScope.utilisateur.name}" name="name"><br>
            Country: <input type="text" value="${requestScope.utilisateur.country}"
                name="country"><br>
            Mot de passe <input type="text" value="${requestScope.utilisateur.motdepasse}"
                name="motdepasse"><br>
            Taille <input type="text" value="${requestScope.utilisateur.taille}"
                name="taille"><br>
            Poids <input type="text" value="${requestScope.utilisateur.poids}"
                name="poids"><br>
            Naissance <input type="text" value="${requestScope.utilisateur.naissance}"
                name="naissance"><br>
            Email <input type="text" value="${requestScope.utilisateur.email}"
                name="email"><br> <input type="submit"
                value="Edit Person">
        </form>
    </c:if>
 
    <%-- Add Request --%>
    <c:if test="${requestScope.utilisateur eq null}">
        <form action='<c:out value="${addURL}"></c:out>' method="post">
            Name: <input type="text" name="name"><br> Country: <input
                type="text" name="country"><br> Email : <input
                type="text" name="email"><br> Mot de passe: <input
                type="text" name="motdepasse"><br>  Taille: <input
                type="text" name="taille"><br>  Poids: <input
                type="text" name="poids"><br>  Naissance: <input
                type="text" name="naissance"><br> <input type="submit"
                value="Add Person">
        </form>
    </c:if>
 
    <%-- Persons List Logic --%>
    <c:if test="${not empty requestScope.utilisateurs}">
        <table>
            <tbody>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Country</th>
                    <th>Nombre de pas</th>
                    <th>Taille</th>
                    <th>Poids</th>
                    <th>Naissance</th>
                    <th>Email</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${requestScope.utilisateurs}" var="utilisateur">
                    <c:url value="/editUser" var="editURL">
                        <c:param name="id" value="${utilisateur.id}"></c:param>
                    </c:url>
                    <c:url value="/deleteUser" var="deleteURL">
                        <c:param name="id" value="${utilisateur.id}"></c:param>
                    </c:url>
                    <tr>
                        <td><c:out value="${utilisateur.id}"></c:out></td>
                        <td><c:out value="${utilisateur.name}"></c:out></td>
                        <td><c:out value="${utilisateur.country}"></c:out></td>
                        <td><c:forEach items="${utilisateur.nombrePas}" var="entry">
                                Key = ${entry.key}, value = ${entry.value}<br>
                            </c:forEach></td>
                        <td><c:out value="${utilisateur.taille}"></c:out></td>
                        <td><c:out value="${utilisateur.poids}"></c:out></td>
                        <td><c:out value="${utilisateur.naissance}"></c:out></td>
                        <td><c:out value="${utilisateur.email}"></c:out></td>
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