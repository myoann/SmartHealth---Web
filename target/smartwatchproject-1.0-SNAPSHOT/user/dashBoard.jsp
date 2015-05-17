<<<<<<< HEAD
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
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&signed_in=true"></script>
        <script src="${pageContext.request.contextPath}/styles/js/func.js"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
        <script src="http://code.highcharts.com/modules/exporting.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-line.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-donuts.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-bar.js"></script>
        
        <script src="${pageContext.request.contextPath}/styles/js/highcharts.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#example').DataTable({

                });
                doDonut("donutA","${nombrePas} / 10 000 pas");
            } );
        </script>
	</head>
<body id="dashBoard">
    <div id="filter_dark" onclick="viewMenu()"></div>

    <jsp:include page="./_menu.jsp"/>
    <jsp:include page="../section/_header.jsp"/>
    <table id="tabProfil" onclick="viewMenu()">
        <tr>
            <td id="tdUsername"><span>${sessionScope.sessionUtilisateur.name}</span></td>
            <td rowspan="2"><img src="${pageContext.request.contextPath}/data/img/avatar.jpg" /></td>
        </tr>
        <tr>
            <td id="tdEmail"><span>${sessionScope.sessionUtilisateur.email}</span></td>
        </tr>
    </table>
    <div id="displayMap">
        <div id="map_canvas"></div>
        <!--iframe id="webmap" src="" width="800" height="600" frameborder="0" style="border:0"></iframe-->
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
            <td><span id="score">98%</span><br>objectifs atteints</td>
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
</body>
</html>
=======
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
        <script src="http://code.highcharts.com/highcharts.js"></script>
        <script src="http://code.highcharts.com/modules/exporting.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-line.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-donuts.js"></script>
        <script src="${pageContext.request.contextPath}/styles/js/highcharts-bar.js"></script>
        
        <script src="${pageContext.request.contextPath}/styles/js/highcharts.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#example').DataTable({

                });
                doDonut("donutA","${nombrePas}","${utilisateur.objectif.nombrePas}","pas");
                doDonut("donutB","${nombreMinutes}","${utilisateur.objectif.minutes}","minutes");
                doDonut("donutC","${nombreMetres}","${utilisateur.objectif.metres}","mètres");
            } );
        </script>
	</head>
<body id="dashBoard">
    <div id="filter_dark" onclick="viewMenu()"></div>

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
        <iframe id="webmap" src="" width="800" height="600" frameborder="0" style="border:0"></iframe>
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
            <td><span id="score">35%</span><br>objectifs atteints</td>
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
</body>
</html>
>>>>>>> f09ef9bfc15e5de26cc8bf4eef173afb6ae2207e
