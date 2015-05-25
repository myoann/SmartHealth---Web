<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Smarth Watch</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/data/logo.ico"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/css.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/dashBoard.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/css/menu.css" />

        <!-- 4> import des fichiers javascript -->
        <script src="${pageContext.request.contextPath}/styles/js/jquery-1.11.2.min.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/func.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
        <script src="http://code.highcharts.com/modules/exporting.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-line.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-donuts.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-bar.js"></script>
       
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#example').DataTable({

                });
                doDonut("donutA","${nombrePas}","${utilisateur.objectif.nombrePas}","pas");
                doDonut("donutB","${nombreMinutes}","${utilisateur.objectif.minutes}","minutes");
                doDonut("donutC","${nombreMetres}","${utilisateur.objectif.metres}","mètres");
                
                doLine("line_nbPas","Nombre de pas","${activiteJour}","${pasParJour}","Nombre de pas");
                doLine("line_cardiaque","Distance","${activiteJour}","${metresParJour}","Mètres");
                doLine("line_historique","Minutes","${activiteJour}","${minutesParJour}","Minutes");
                doLine("line_poids","Fréquence Cardiaque","${activiteJour}","${freqCardiaque}","Fréquence Cardiaque");

                doBar("line_dureeActivite","Durée de l'activité",${utilisateur.objectif.marcheTemps},${utilisateur.objectif.courseTemps},${utilisateur.objectif.veloTemps},${dureeMarche},${dureeCourse},${dureeVelo});
                
                viewMap("${latitude}","${longitude}");
            } );
        </script>
	</head>
<body id="dashBoard">
    <div id="filter_dark" onclick=""></div>

    <jsp:include page="./_menu.jsp"/>
    <jsp:include page="../section/_header.jsp"/>
    <table id="tabProfil" onclick="viewMenu()">
        <tr>
            <td id="tdUsername"><span>${utilisateur.name}</span></td>
            <td rowspan="2"><img src="${pageContext.request.contextPath}/data/img/avatar.jpg" /></td>
        </tr>
        <tr>
            <td id="tdEmail"><span>${utilisateur.email}</span></td>
        </tr>
    </table>
    <div id="displayMap">
        <div id="map_canvas"></div>
        <button id="viewMap"><span class="icon-arrow-down-3"><br>Afficher la map</span></button>       
    </div>

	<table id="tab_dashBoard">
		<tr>
			<td class="tdPart">Objectifs du jour</td>
			<td class="tdPart">Performances</td>
			<td class="tdPart">Fréquences</td>
		</tr>
        <tr>
            <td id="donuts"><div id="donutA"></div><div id="donutB"></div><div id="donutC"></div></td>
            <td><span id="score">${objectifPerCent}%</span><br>objectifs atteints</td>
            <td><div id="line_cardiaque"></div></td>
        </tr>
        <tr>
                <td>Activités recommandées<br><jsp:include page="./_tabActivites.jsp"/></td>
                <td><div id="line_historique"></div></td>
                <td><div id="line_nbPas"></div></td>
        </tr>
        <tr>
            <td></td>
            <td><div id="line_dureeActivite"></div></td>
            <td><div id="line_poids"></div></td>
        </tr>
	</table>
        <iframe id='iframe_calendar' frameborder=0 class='off' src="${pageContext.request.contextPath}/styles/js/fullcalendar-2.3.1/calendar.jsp"></iframe>
</body>
</html>
