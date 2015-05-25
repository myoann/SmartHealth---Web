<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/inscription.css" />

        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>
        
    </head>
    <body>
    <header>
        Inscription
    </header>
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

  

    <%-- Add Request --%>
    <c:if test="${requestScope.utilisateur eq null}">
        <form action='<c:out value="${addURL}"></c:out>' method="post" enctype="multipart/form-data">
                <fieldset id="fieldset_new_user">
                    <legend class="icon-user"> Nouvel utilisateur</legend>
                    <table id="tab_new_user">
                        <tr><td class="icon-user"><input type="text" name="name" placeholder="Nom"></td></tr>
                        <%--<tr><td>Photo</td><td><input type="file" name="photo"></td></tr>--%>
                        <tr><td class="icon-user"><input type="email" name="email" placeholder="Email"></td></tr>
                        <tr><td class="icon-user"><input type="password" name="motdepasse" placeholder="Mot de passe"></td></tr>
                        <tr><td class="icon-user"><input type="number" name="taille" placeholder="Taille"></td></tr>
                        <tr><td class="icon-user"><input type="number" name="poids" placeholder="Poids"></td></tr>
                        <tr><td class="icon-user"><input type="text" name="naissance" placeholder="Naissance"></td></tr>
                        <tr><td><button type="submit" class="icon-plus"> S'inscrire</button></td></tr>
                    </table>
                </fieldset>
            </form>
    </c:if>

</body>
</html>