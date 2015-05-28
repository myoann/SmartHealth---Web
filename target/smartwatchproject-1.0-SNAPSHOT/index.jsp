<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Smarth Health</title>
        <link rel="icon" type="image/png" href="./data/logo.ico"/>
        <link rel="stylesheet" href="./styles/css/css.css" />
        <!-- link rel="stylesheet" href="./styles/css/respDesign.css" / -->

        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
    </head>
    <body>
        <c:url value="/connexion" var="connexion"></c:url>
        <c:url value="/inscription" var="inscription"></c:url>
        <!-- img de background : animation de transition avec changement des slogans -->
	<img class='bg' id="bg_1" src="./data/1.jpg">
	<img class='bg' id="bg_2" src="./data/2.jpg">
	<img class='bg' id="bg_3" src="./data/3.jpg">
        
        
        <header class='header_accueil'>
            <div id="filter"></div>
            <span id="title">Smart Health</span>
        </header>
        
	<div id="connexion">
            <a href='<c:out value="${connexion}"></c:out>'><button id="logIn">Connexion</button></a>
            <a href='<c:out value="${inscription}"></c:out>'><button id="signUp">S'inscrire</button></a>
	</div>
	
	<div id="message">
		<span id="msgA"></span>
		<span id="msgB"></span>
		<a href='<c:out value="${inscription}"></c:out>'><button>Commencez dès maintenant</button></a>
	</div>
        
        <jsp:include page="./section/_footer.jsp"/>
</body>
</html>
