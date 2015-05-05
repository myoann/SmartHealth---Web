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
        <!-- physique -->
		<li id="menu_physique">Modifier vos données physique</li>
        <li class="sub_menu physique_1"><input type="date" placeholder="Non renseignée" value="${sessionScope.sessionUtilisateur.naissance}"/></li>
        <li class="sub_menu physique_2"><input type="text" placeholder="Non renseignée" value="${sessionScope.sessionUtilisateur.taille}cm"/></li>
        <li class="sub_menu physique_3"><input type="text" placeholder="Non renseigné" value="${sessionScope.sessionUtilisateur.poids}kg"/></li>
        <!-- objectifs -->
		<li id="menu_objectif">Modifier vos objectifs</li>
        <li class="sub_menu ss_objectif_1_1">${sessionScope.sessionUtilisateur.objectif.titre}</li>
        <li class="sub_menu ss_objectif_1_2">${sessionScope.sessionUtilisateur.objectif.description}</li>
        <li class="sub_menu ss_objectif_1_3">
            <select name="objectif">
              <c:forEach var="objectif" items="${objectifs}">
                <option value="${objectif.id}" ${objectif.id == sessionScope.sessionUtilisateur.objectif.id ? 'selected="selected"' : ''}>${objectif.titre}</option>
              </c:forEach>
            </select>
        </li>
        <li class="sub_menu ss_objectif_1_4"><button>Modifier objectif</button></li>
	</ul>
</div>