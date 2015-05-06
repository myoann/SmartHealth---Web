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
        
<form method="post" action="connexion">
<div id="page_connexion">
	<h1>Se connecter</h1>
	<table id="tab_connect">
		<tr><td><input type="email" id="email" name="email"  placeholder="Email" /><span class="erreur">${form.erreurs['email']}</span></td></tr>
		<tr><td><input type="password" id="motdepasse" name="motdepasse"  placeholder="Mot de passe" /><span class="erreur">${form.erreurs['motdepasse']}</span></td></tr>
		<tr><td><button>Connexion</button></td></tr>
	</table>
	
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
	<div class="barre_vertical"></div>

	<table id="tab_connect_social">
		<tr><td><button class="icon-facebook bt_fb"> Connexion</button></td></tr>
		<tr><td><button class="icon-google bt_google"> Connexion</button></td></tr>
	</table>
</div>
</form>
        
        <!--form method="post" action="connexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c :out value="$ {utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">$ {form.erreurs['email']}</span>
                

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">$ {form.erreurs['motdepasse']}</span>


                <input type="submit" value="Connexion" class="sansLabel" />
                
                
                <p class="$ {empty form.erreurs ? 'succes' : 'erreur'}">$ {form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c :if test="$ {!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : $ {sessionScope.sessionUtilisateur.email}</p>
                </c :if>
            </fieldset>
        </form -->
                
    </body>
</html>