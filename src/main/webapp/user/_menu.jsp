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
		<li id="menu_physique">Modifier vos donnÈes physique</li>
        <li class="sub_menu physique_1"><input type="date" placeholder="date" value=""/></li>
        <li class="sub_menu physique_2"><input type="text" placeholder="text" value="1m80"/></li>
        <li class="sub_menu physique_3"><input type="text" placeholder="poids" value="75kg"/></li>
        <!-- objectifs -->
		<li id="menu_objectif">Modifier vos objectifs</li>
        <li class="sub_menu objectif">
            <select>
                <option>Course ‡ pied</option>
                <option>VÈlo</option>
                <option>Marche</option>
            </select>
        </li>
        <li class="sub_menu ss_objectif_1_1"><input type="date" placeholder="date" value="26/04/2015"/></li>
        <li class="sub_menu ss_objectif_1_2"><input type="text" placeholder="dÈbut" value="6h"/></li>
        <li class="sub_menu ss_objectif_1_3"><input type="text" placeholder="distance (km)" value="10"/></li>
        <li class="sub_menu ss_objectif_1_4"><input type="text" placeholder="durÈe (min)" value="55"/></li>
        <li class="sub_menu ss_objectif_1_5"><button>Nouvel objectif</button></li>

        <!-- pr√©f√©rences -->
		<!-- li id="menu_preference">Modifier vos pr√©f√©rences</li>
        <li class="sub_menu preference_1">Ajouter un objetcif</li>
        <li class="sub_menu preference_2">V√©lo</li>
        <li class="sub_menu preference_3">March</li -->
	</ul>
</div>