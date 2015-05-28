<%-- 
    Document   : about
    Created on : 28 mai 2015, 12:01:39
    Author     : EK
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Smarth Watch</title>
        <link rel="icon" type="image/png" href="./data/logo.ico"/>
        <link rel="stylesheet" href="./styles/css/css.css" />
        <link rel="stylesheet" href="./styles/css/services.css" />

        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
    </head>
    <body>
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
        <!--img src="http://demo.atomlabs.me/atomkiosk/wp-content/uploads/2014/02/Mail1-1024x1024.png" class="bg_connexion"/-->
        <br><br>
        <fieldset class="about">
            <div class="filter_white2"></div>
            <legend class="icon-rocket"> Services</legend>
            <b><span class="icon-user"> Utilisateur</span></b>
            <ul>
                <li>Permettre à l’utilisateur de s’inscrire</li>
                <li>Permettre à l’utilisateur de se connecter</li>
                <li>Permettre à l’utilisateur de modifier ses données de profil</li>
                <li>Permettre à l’utilisateur de visualiser le nombre de pas effectué</li>
                <li>Permettre à l’utilisateur de visualiser sa fréquence cardiaque</li>
                <li>Permettre à l’utilisateur de visualiser son parcours via une maps intégrée </li>
            </ul>
            <br>
            <b><span class="icon-user-4"> Administrateur</span></b>
            <ul>
                <li>Permettre à l’administrateur de gérer un compte utilisateur (ajouter/modifier/rechercher/supprimer)</li>
                <li>Permettre à l’administrateur de gérer des objectifs (ajouter/modifier/rechercher/supprimer)</li>
            </ul>
            
        </fieldset>
        <jsp:include page="./section/_footer.jsp"/>
    </body>
</html>
