<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/connexion.css" />
    </head>
    <body>
	<img class='bg_connexion' id="bg_connexion" src="http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/09/moto_360-1.jpg">
        <c:url value="/connexion" var="connexion"></c:url>
        <c:url value="/inscription" var="inscription"></c:url>
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
	<div id="connexion">
            <a href='<c:out value="${connexion}"></c:out>'><button id="logIn">Connexion</button></a>
            <a href='<c:out value="${inscription}"></c:out>'><button id="signUp">S'inscrire</button></a>
	</div>
        
<form method="post" action="connexion">
<div id="page_connexion">
                <div class="filter_white"></div>
	<h1>Se connecter</h1>
	<table id="tab_connect">
		<tr><td><input type="email" id="email" name="email"  placeholder="Email" /><span class="erreur">${form.erreurs['email']}</span></td></tr>
		<tr><td><input type="password" id="motdepasse" name="motdepasse"  placeholder="Mot de passe" /><span class="erreur">${form.erreurs['motdepasse']}</span></td></tr>
		<tr><td><button>Connexion</button></td></tr>
	</table>
                <br>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
	<!--div class="barre_vertical"></div>

	<table id="tab_connect_social">
		<tr><td><button class="icon-facebook bt_fb"> Connexion</button></td></tr>
		<tr><td><button class="icon-google bt_google"> Connexion</button></td></tr>
	</table-->
</div>
</form>
        <jsp:include page="./section/_footer.jsp"/>
                
    </body>
</html>