<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <jsp:include page="./section/_header.jsp"/>
	<div id="connexion">
		<button id="logIn">Connexion</button>
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
