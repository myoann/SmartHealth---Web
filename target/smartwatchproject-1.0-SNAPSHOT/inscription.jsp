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

        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>

    </head>
    <body>
        <form method="post" action="inscription">
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

    </body>
</html>