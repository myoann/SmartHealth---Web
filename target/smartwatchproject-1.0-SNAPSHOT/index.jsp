<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Smarth Watch</title>
        <link rel="icon" type="image/png" href="./data/logo.ico"/>
        <link rel="stylesheet" href="./styles/css/css.css" />
        <!-- link rel="stylesheet" href="./styles/css/respDesign.css" / -->

        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
    </head>
    <body>
	<img id="bg" src="">
        <header>
            <span id="title">Smart Health</span>
        </header>
	<div id="connexion">
<<<<<<< HEAD
            <button id="logIn"><a href="./connexion">Connexion</a></button>
=======
        <c:url value="/connexion" var="connexion"></c:url>
            <a href='<c:out value="${connexion}"></c:out>'><button id="logIn">Connexion</button></a>
>>>>>>> f09ef9bfc15e5de26cc8bf4eef173afb6ae2207e
		<button id="signUp">S'inscrire</button>
	</div>
	
	<div id="message">
		<span id="msgA"></span>
		<span id="msgB"></span>
		<button>Commencez dès maintenant</button>
	</div>

        
        <jsp:include page="./section/_footer.jsp"/>
</body>
</html>
