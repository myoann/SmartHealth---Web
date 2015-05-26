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
        <%-- Person Add/Edit logic --%>
        <c:if test="${requestScope.error ne null}">
        <strong style="color: red;"><c:out
                value="${requestScope.error}"></c:out></strong>
        </c:if>
        <c:if test="${requestScope.success ne null}">
        <strong style="color: green;"><c:out
                value="${requestScope.success}"></c:out></strong>
        </c:if>
        <c:url value="/inscription" var="addURL"></c:url>



        <%-- Add Request --%>
        <c:if test="${requestScope.utilisateur eq null}">
            <form action='<c:out value="${addURL}"></c:out>' method="post" enctype="multipart/form-data">
                <div id="page_connexion">
                    <div class="filter_white"></div>
                    <h1>S'inscrire</h1>
                    <span class="slogan">Prêt à vous lancer ? Un nouveau départ s'offre à vous.</span>
                    <table id="tab_connect">
                        <tr>
                            <td colspan="6"><input type="text" name="name" placeholder="Nom d'utilisateur"></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="date" name="naissance" placeholder="Naissance"></td>
                            <td colspan="2"><input type="number" name="taille" placeholder="Taille (cm)"></td>
                            <td colspan="2"><input type="number" name="poids" placeholder="Poids (kg)"></td>
                        </tr>
                            <%--<tr><td>Photo</td><td><input type="file" name="photo"></td></tr>--%>
                        <tr><td colspan="6"><input type="email" name="email" placeholder="Email"></td></tr>
                        <tr>
                            <td colspan="3"><input type="password" name="motdepasse" placeholder="Mot de passe"></td>
                            <td colspan="3"><input type="password" name="motdepasse2" placeholder="Confirmer le mot de passe"></td>
                        </tr>
                        <tr><td colspan="6"><button type="submit"> S'inscrire</button></td></tr>
                    </table>
                </div>
            </form>
        </c:if>

    </body>
</html>