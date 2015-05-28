<%-- 
    Document   : help
    Created on : 28 mai 2015, 15:22:59
    Author     : EK
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>SmartHealth : Help</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/services.css" />
        
    </head>
    <body>
        <img src="http://flatwallpaper.com/wp-content/uploads/2015/03/Blue-Question-Mark-Flat-Minimalist-Wallpaper.jpg" class="bg_connexion" />
       
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
         <br><br>
        <fieldset class="about">
            <div class="filter_white2"></div>
            <legend class="icon-question"> Aide</legend>
            <b><span> Le site est composé des 10 pages web suivante :</span></b>
        <ul>
            <li>Accueil : page principal pour accéder à la connexion ou l'inscription</li>
            <li>Connexion : pour se connecter à l'application web SmartHealth</li>
            <li>Inscription : pour s'inscrire à l'application web SmartHealth</li>
            <li>A propos : pour obtenir des informations sur l'application web SmartHealth</li>
            <li>Services : pour savoir ce qu'il est possible de faire sur l'application web SmartHealth</li>
            <li>Aide : pour se connecter à l'application web SmartHealth</li>
            <li>Contact : pour contacter les développeurs de l'application web SmartHealth</li>
            <li>Dashboard : pour consulter vos données d'activités et vos objectifs</li>
            <li>Gestion des utilisateurs : permet aux administrateurs de gérer les utilisateurs</li>
            <li>Gestion des objectifs : permet aux administrateurs de gérer les objectifs</li>
        </ul>
            <br>
<c:url value="/contact.jsp" var="contact"></c:url>
            Pour plus de renseignement, <a  href='<c:out value="${contact}"></c:out>' target="_blank">veuillez nous contacter</a>
        </fieldset>
        <jsp:include page="./section/_footer.jsp"/>
    </body>
</html>
