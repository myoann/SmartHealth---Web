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
        <link rel="stylesheet" href="./styles/css/about.css" />
        
        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
    </head>
    <body>
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
        <br><br>
        <fieldset class="about">
            <div class="filter_white2"></div>
            <legend class="icon-quotes-left">  À propos</legend>
            <p>Le site web Smart Health a été réalisé dans le cadre d'un projet universitaire réalisé au sein du Master 1 MIAGE
                à l'Université de Nice Sophia Antipolis.<br>
            Ce projet à été réalisé par Fabrice JAUVAT, Elmahdi KORFED, Thibaut LINARES et Yoann MOISE.<br>
            Vous pouvez consulter l'intégralité du projet (Application Android Mobile, Android Wear, Serveur et Application Web) sur GitHub : <br><br>
            <a href='https://github.com/myoann/SmartHealth---Android-App' target='_blank'>Smarthealth---Android-App</a> et <a href='https://github.com/myoann/SmartHealth---Web-App'  target='_blank'>Smarthealth---Web-App</a>.<br>
            </p>
        </fieldset>
        
        <jsp:include page="./section/_footer.jsp"/>
    </body>
</html>
