<table class="display" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th>Activité</th>
            <th>Distance (km)</th>
            <th>Durée (min)</th>
        </tr>
    </thead>

    <tbody>
        <tr>
            <td>Course à pied</td>
            <td>${utilisateur.objectif.courseMetres}</td>
            <td>${utilisateur.objectif.courseTemps}</td>
        </tr>
        <tr>
            <td>Vélo</td>
            <td>${utilisateur.objectif.veloMetres}</td>
            <td>${utilisateur.objectif.veloTemps}</td>
        </tr>
        <tr>
            <td>Marche</td>
            <td>${utilisateur.objectif.marcheMetres}</td>
            <td>${utilisateur.objectif.marcheTemps}</td>
        </tr>
    </tbody>
</table>