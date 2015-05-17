<<<<<<< HEAD
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
    <table id="tabProfil" onclick="viewMenu()">
        <tr>
            <td id="tdUsername"><span>${sessionScope.sessionUtilisateur.name}</span></td>
            <td rowspan="2"><img src="${pageContext.request.contextPath}/data/img/avatar.jpg" /></td>
        </tr>
        <tr>
            <td id="tdEmail"><span>${sessionScope.sessionUtilisateur.email}</span></td>
        </tr>
    </table>
	<ul>
        <!-- profil -->
        <li id="menu_profil">Modifier votre profil</li>
	<li class="sub_menu profil_1"><input type="email" placeholder="email" value="${sessionScope.sessionUtilisateur.email}"/></li>
        <li class="sub_menu profil_2"><input type="password" placeholder="password" value="${sessionScope.sessionUtilisateur.motdepasse}"/></li>
        <li class="sub_menu profil_3"><button class="icon-disk"> Enregistrer</button></li>
        <!-- physique -->
		<li id="menu_physique">Modifier vos données physique</li>
        <li class="sub_menu physique_1"><input type="date" placeholder="Non renseignée" value="${sessionScope.sessionUtilisateur.naissance}"/></li>
        <li class="sub_menu physique_2"><input type="text" class="phy_taille" placeholder="Non renseignée" value="${sessionScope.sessionUtilisateur.taille}"/>cm</li>
        <li class="sub_menu physique_3"><input type="text" class="phy_poids" placeholder="Non renseigné" value="${sessionScope.sessionUtilisateur.poids}"/>kg</li>
        <li class="sub_menu physique_4"><button class="icon-disk"> Enregistrer</button></li>
        <!-- objectifs -->
	<li id="menu_objectif">Modifier vos objectifs</li>
        <li class="sub_menu ss_objectif_1_1">${sessionScope.sessionUtilisateur.objectif.titre}</li>
        <li class="sub_menu ss_objectif_1_2">${sessionScope.sessionUtilisateur.objectif.description}</li>
        <li class="sub_menu ss_objectif_1_3">
            <select name="objectif" class="select_objectif">
              <c:forEach var="objectif" items="${objectifs}">
                <option value="${objectif.id}" ${objectif.id == sessionScope.sessionUtilisateur.objectif.id ? 'selected="selected"' : ''}>${objectif.titre}</option>
              </c:forEach>
            </select>
            <button class="edit_objectif icon-pencil"></button>
        </li>
        <li class="sub_menu ss_objectif_1_4"><button class="icon-disk"> Enregistrer</button></li>
	</ul>
        <a class="bt_deconnexion" href="/deconnexion">Deconnexion</a>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="menu">
    <table id="tabProfil" onclick="viewMenu()">
        <tr>
            <td id="tdUsername"><span>${utilisateur.name}</span></td>
            <td rowspan="2"><img src="${pageContext.request.contextPath}/data/img/avatar.jpg" /></td>
        </tr>
        <tr>
            <td id="tdEmail"><span>${utilisateur.email}</span></td>
        </tr>
    </table>
	<ul>
        <!-- profil -->
        
        <c:url value="/editUser" var="editURL"></c:url>
        <li id="menu_profil">Modifier votre profil</li>
        
        <form method="post" action='<c:out value="${editURL}"></c:out>' enctype="multipart/form-data">
            <li class="sub_menu profil_1"><input type="email" name="email" placeholder="email" value="${utilisateur.email}"/></li>
            <li class="sub_menu profil_2"><input type="password" name="motdepasse" placeholder="password" value="${utilisateur.motdepasse}"/></li>
            <input type="hidden" name="id" value="${utilisateur.id}"/>
            <input type="hidden" name="type" value="modifierProfil"/>
            <li class="sub_menu profil_3"><button>Modifier profil</button></li>
        </form>
        <!-- physique -->
		<li id="menu_physique">Modifier vos données physique</li>
                
        <form method="post" action='<c:out value="${editURL}"></c:out>' enctype="multipart/form-data">
            <li class="sub_menu physique_1"><input type="date" name="naissance" placeholder="Non renseignée" value="${utilisateur.naissance}"/></li>
            <li class="sub_menu physique_2"><input type="number" class="phy_taille" name="taille" placeholder="Non renseignée" value="${utilisateur.taille}"/>cm</li>
            <li class="sub_menu physique_3"><input type="number" class="phy_poids" name="poids" placeholder="Non renseigné" value="${utilisateur.poids}"/>kg</li>
            <input type="hidden" name="id" value="${utilisateur.id}"/>
            <input type="hidden" name="type" value="modifierDonnees"/>
            <li class="sub_menu physique_4"><button>Modifier données</button></li>
        </form>
        <!-- objectifs -->
		<li id="menu_objectif">Modifier vos objectifs</li>
                
        <form method="post" action='<c:out value="${editURL}"></c:out>' enctype="multipart/form-data">
            <li class="sub_menu ss_objectif_1_1">${utilisateur.objectif.titre}</li>
            <li class="sub_menu ss_objectif_1_2">${utilisateur.objectif.description}</li>
            <input type="hidden" name="id" value="${utilisateur.id}"/>
            <input type="hidden" name="type" value="modifierObjectif"/>
            <li class="sub_menu ss_objectif_1_3">
                <select name="objectif">
                  <c:forEach var="objectif" items="${objectifs}">
                    <option value="${objectif.id}" ${objectif.id == utilisateur.objectif.id ? 'selected="selected"' : ''}>${objectif.titre}</option>
                  </c:forEach>
                </select>
            </li>
            <li class="sub_menu ss_objectif_1_4"><button>Modifier objectif</button></li>
        </form>
	</ul>
        <c:url value="/deconnexion" var="deconnexion"></c:url>
        <a class="bt_deconnexion" href='<c:out value="${deconnexion}"></c:out>'>Deconnexion</a>
>>>>>>> f09ef9bfc15e5de26cc8bf4eef173afb6ae2207e
</div>