<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/inscription.css" />
    </head>
    <body>
        <c:url value="/connexion" var="connexion"></c:url>
        <c:url value="/inscription" var="inscription"></c:url>
	<img class='bg_connexion bg_inscription' id="bg_connexion" src="http://img0.gtsstatic.com/wallpapers/80eb2b7d8ad1afb094af7aefa1511202_large.jpeg">
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
        
	<div id="connexion">
            <a href='<c:out value="${connexion}"></c:out>'><button id="logIn">Connexion</button></a>
            <a href='<c:out value="${inscription}"></c:out>'><button id="signUp">S'inscrire</button></a>
	</div>
        
        <form method="post" action="inscription">
            <div id="page_connexion">
                <div class="filter_white"></div>
                <h1>S'inscrire</h1>
                <span class="slogan">Prêt à vous lancer ? Un nouveau départ s'offre à vous.</span>
                <table id="tab_connect">
                    <tr>
                        <td colspan="6"><input type="text" name="name" placeholder="Nom d'utilisateur" value="${requestScope.utilisateur.name}"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="date" name="naissance" placeholder="Naissance" value="${requestScope.utilisateur.naissance}"></td>
                        <td colspan="2"><input type="number" name="taille" placeholder="Taille (cm)" value="${requestScope.utilisateur.taille}"></td>
                        <td colspan="2"><input type="number" name="poids" placeholder="Poids (kg)" value="${requestScope.utilisateur.poids}"></td>
                    </tr>
                    <%--<tr><td>Photo</td><td><input type="file" name="photo"></td></tr>--%>
                    <tr><td colspan="6"><input type="email" name="email" placeholder="Email" value="${requestScope.utilisateur.email}"></td></tr>
                    <tr>
                        <td colspan="3"><input type="password" name="motdepasse" placeholder="Mot de passe" value="${requestScope.utilisateur.motdepasse}"></td>
                        <td colspan="3"><input type="password" name="motdepasse2" placeholder="Confirmer le mot de passe" value="${requestScope.utilisateur.motdepasse}"></td>
                    </tr>
                    <tr><td colspan="6"><button type="submit"> S'inscrire</button></td></tr>
                    <c:if test="${requestScope.error ne null}">
                        <tr><td colspan="6">
                        <strong style="color: red;"><c:out
                                value="${requestScope.error}"></c:out></strong>
                        </td></tr>
                    </c:if>
                </table>
            </div>
        </form>

        <jsp:include page="./section/_footer.jsp"/>
    </body>
</html>