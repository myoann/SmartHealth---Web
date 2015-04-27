<!doctype html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Smarth Watch</title>
		<link rel="icon" type="image/png" href="./data/logo.ico"/>
		<link rel="stylesheet" href="./styles/css/css.css" />
		<link rel="stylesheet" href="./styles/css/dashBoard.css" />
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.css" />
		<link rel="stylesheet" href="./styles/css/menu.css" />



        <!-- 4> import des fichiers javascript -->
        <script src="./styles/js/jquery-1.11.2.min.js"></script>
        <script src="./styles/js/func.js"></script>
        <script src="http://code.highcharts.com/highcharts.js"></script>
        <script src="http://code.highcharts.com/modules/exporting.js"></script>
        <script src="./styles/js/highcharts-line.js"></script>
        <script src="./styles/js/highcharts-donuts.js"></script>
        <script src="./styles/js/highcharts-bar.js"></script>
        <script src="./styles/js/highcharts.js"></script>
        <script src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function() {
                $('#example').DataTable({

                });
            } );
        </script>
	</head>
<body id="dashBoard">
    <div id="filter_dark" onclick="viewMenu()"></div>

    <?php include("./section/_menu.htm"); ?>
	<?php include("./section/_header.htm"); ?>
    <table id="tabProfil" onclick="viewMenu()">
        <tr>
            <td id="tdUsername"><span>Talisman Joe</span></td>
            <td rowspan="2"><img src="./data/img/avatar.jpg" /></td>
        </tr>
        <tr>
            <td id="tdEmail"><span>talisman.joe@gmail.com</span></td>
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
            <td><span id="score">98%</span><br>objectifs atteints</td>
            <td><div id="line_cardiaque"></div></td>
        </tr>
		<tr>
			<td>activités<br><?php include("./_tabActivites.htm") ?></td>
			<td><div id="line_historique"></div></td>
			<td><div id="line_nbPas"></div></td>
		</tr>
        <tr>
            <td>recommandations<br><?php include("./_tabActivites.htm") ?></td>
            <td><div id="line_dureeActivite"></div></td>
            <td><div id="line_poids"></div></td>
        </tr>
	</table>
</body>
</html>