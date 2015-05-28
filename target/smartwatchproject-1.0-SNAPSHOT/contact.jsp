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
        <link rel="stylesheet" href="./styles/css/contact.css" />
        
        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
    </head>
    <body>
        <img src="http://static1.squarespace.com/static/52730713e4b0669c62d51849/5483b3bae4b0fce53703634a/54494237e4b0618875f34203/1430607541811/?format=1500w" class="bg_connexion"/>
       
        <header class='header_accueil'>
            <div id="filter"></div>
            <a href="index.jsp"><span id="title">Smart Health</span></a>
        </header>
         <br><br>
         
        <table>
            <tr>
                <td><div id="filter"></div>
                    <img src="https://fbcdn-profile-a.akamaihd.net/hprofile-ak-xta1/v/t1.0-1/10478946_10204405680120010_4189912159077054952_n.jpg?oh=8672a53ae70f05ee5f94ffd3b0e79579&oe=560D7D20&__gda__=1442217738_b70ef0f91c32895abb9c7b535bc63b0c">
                    <span>JAUVAT Fabrice</span>
                    <span><a href="mailto:fjauvat@gmail.com">fjauvat@gmail.com</a></span>
                </td>
                <td>
                    <img src="https://scontent.xx.fbcdn.net/hphotos-xfp1/v/t1.0-9/10610626_437743833050690_7250454562023290789_n.jpg?oh=de172ad17ee896fa11b89b9127d0e4a2&oe=55F6FC10">
                    <span>KORFED Elmahdi</span>
                    <span><a href="mailto:elmahdi.korfed@gmail.com">elmahdi.korfed@gmail.com</a></span>
                </td>
                <td>
                    <img src="https://scontent.xx.fbcdn.net/hphotos-prn2/v/t1.0-9/223007_2311511153210_4532946_n.jpg?oh=a746f88097effea9655702912a94e3d6&oe=55FADDFA">
                    <span>LINARES Thibaut</span>
                    <span><a href="mailto:thibaut.linares@gmail.com">thibaut.linares@gmail.com</a></span>
                </td>
                <td>
                    <img src="https://avatars0.githubusercontent.com/u/5923702?v=3&s=460">
                    <span>MOISE Yoann</span>
                    <span><a href="mailto:moise.yoann@gmail.com">moise.yoann@gmail.com</a></span>
                </td>
            </tr>
        </table>
        
        <jsp:include page="./section/_footer.jsp"/>
    </body>
</html>
