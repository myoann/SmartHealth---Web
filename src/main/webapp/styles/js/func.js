var _numIMG=1;
var _speedSilde=3000;
var map;
$(function(){
	//$(document).bind("contextmenu",function(e){	return false; });
	//displaySection();

	setInterval(function(){ chgBG() },_speedSilde);

	// ----- PROFIL -----
	listenMenu("menu_profil",".profil_1,.profil_2,.profil_3");
	// ----- PHYSIQUE -----
	listenMenu("menu_physique",".physique_1,.physique_2,.physique_3,.physique_4");
	// ----- OBJECTIF -----
	listenMenu("menu_objectif",".objectif,.ss_objectif_1_1,.ss_objectif_1_2,.ss_objectif_1_3,.ss_objectif_1_4,.ss_objectif_1_5");
	// ----- PREFERENCE -----
	//listenMenu("menu_preference",".preference_1,.preference_2,.preference_3");

	
	viewMap();

})

function chgBG(){
	if (_numIMG>3) _numIMG=1;
	console.log(_numIMG);
	if (_numIMG==1){
		chgMSG("Votre programme d'entrainement individuel sur votre poignet.","Parfaitement adapté à vos objectifs.");
	} else if (_numIMG==2) {
		chgMSG("Smart Health planifie intelligement de nouveaux objectifs.","Atteignez des sommets.");
	} else if (_numIMG==3) {
		chgMSG("Améliorez vos parcours et allez au-delà de vos limites.","Progressez à votre rythme.");
	} 
	$("img#bg").attr("src","./data/"+_numIMG+".jpg");
	_numIMG++;
}

function chgMSG(_msgA,_msgB){
	$("div#message").find("span#msgA").text(_msgA);
	$("div#message").find("span#msgB").text(_msgB);
}

function listenMenu(_id,_class){
	$("#"+_id).unbind("click").bind("click",function(){
		if ($("#"+_id).hasClass("menu_open")){
			$(_class).slideUp();
		}else{
			$(_class).slideDown();
		}
		$("#"+_id).toggleClass("menu_open");
	})
}

function viewMap(){
	$("button#viewMap").unbind("click").bind("click",function(){
		if ($(this).hasClass("map_open")){
			$("div#map_canvas").slideUp();
			$(this).find("span").html("<br>Afficher la map");
			$(this).find("span").attr("class","icon-arrow-down-3");
			$("div#map_canvas").empty();
			//$("div#map_canvas").removeAttr("src");
		}else{
			$("div#map_canvas").slideDown(500,function(){
				drawMap();
				//put_Marker(43.6961876,7.285362199999999);
			});
			$(this).find("span").html("<br>Cacher la map");
			$(this).find("span").attr("class","icon-arrow-up-3");
			//$("iframe#webmap").attr("src","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d92299.33014380158!2d7.25281705!3d43.70319045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12cdd0106a852d31%3A0x40819a5fd979a70!2sNice!5e0!3m2!1sfr!2sfr!4v1430042770430");
		}
		//console.log(this);
		$(this).toggleClass("map_open");
	})
}
/*
function viewMap(){
	$("button#viewMap").unbind("click").bind("click",function(){
		if ($(this).hasClass("map_open")){
			$("iframe#webmap").slideUp();
			$(this).find("span").html("<br>Afficher la map");
			$(this).find("span").attr("class","icon-arrow-down-3");
			$("iframe#webmap").removeAttr("src");
		}else{
			$("iframe#webmap").slideDown(500,function(){
				drawMap();
				//put_Marker(43.6961876,7.285362199999999);
			});
			$(this).find("span").html("<br>Cacher la map");
			$(this).find("span").attr("class","icon-arrow-up-3");
			$("iframe#webmap").attr("src","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d92299.33014380158!2d7.25281705!3d43.70319045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12cdd0106a852d31%3A0x40819a5fd979a70!2sNice!5e0!3m2!1sfr!2sfr!4v1430042770430");
		}
		console.log(this);
		$(this).toggleClass("map_open");
	})
}
*/

function drawMap() {
	map = new google.maps.Map(document.getElementById("map_canvas"), {
		zoom: 19,
		center: new google.maps.LatLng(48.858565, 2.347198),
		mapTypeId: google.maps.MapTypeId.ROADMAP
	});   
	if (navigator.geolocation)
		var watchId = navigator.geolocation.watchPosition(successCallback,null,{enableHighAccuracy:true});
	else
		alert("Votre navigateur ne prend pas en compte la géolocalisation HTML5");  
}   

function successCallback(position){
	// marker
	map.panTo(new google.maps.LatLng(position.coords.latitude, position.coords.longitude));

	var _url="./save/data.json";
	var flightPlanCoordinates = new Array();
	var _latitudeS=0;
	var _longitudeS=0;
	var _latitudeE=0;
	var _longitudeE=0;
	$.getJSON(_url,function(data){
		//console.log(data);
		$.each(data,function(i,value){
			/*if (i==0){
				_latitudeS=value.latitude;
				_longitudeS=value.longitude;
			}
			if (i==3){
				displayRoute(_latitudeS,_longitudeS,value.latitude,value.longitude);
			}*/
			put_Marker(value.latitude, value.longitude, value.title);
			flightPlanCoordinates.push(new google.maps.LatLng(value.latitude,value.longitude));			
		})
		console.log(flightPlanCoordinates);
		var flightPath = new google.maps.Polyline({
			path: flightPlanCoordinates,
			geodesic: true,
			strokeColor: '#FF0000',
			strokeOpacity: 1.0,
			strokeWeight: 2
		});

		flightPath.setMap(map);
	});

	//put_Marker(position.coords.latitude, position.coords.longitude);
	//put_Marker(43.6980876,7.225362199999999);

	//console.log(position.coords.latitude,position.coords.longitude);

	// trace
	/*var flightPlanCoordinates = [
		new google.maps.LatLng(position.coords.latitude, position.coords.longitude),
		new google.maps.LatLng(43.6980876,7.225362199999999)
	];*/
}

function put_Marker(_latitude,_longitude,_title){
	var marker = new google.maps.Marker({
		position: new google.maps.LatLng(_latitude,_longitude), 
		map: map,
		title: _title
	});
	attachSecretMessage(marker);
}
function attachSecretMessage(marker) {
  var infowindow = new google.maps.InfoWindow({
    content: 'Fabrice'
  });

  google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(marker.get('map'), marker);
  });
}
function displayRoute(_latitudeS,_longitudeS,_latitudeE,_longitudeE) {

    var start = new google.maps.LatLng(_latitudeS, _longitudeS);
    var end = new google.maps.LatLng(_latitudeE, _longitudeE);

    var directionsDisplay = new google.maps.DirectionsRenderer();// also, constructor can get "DirectionsRendererOptions" object
    directionsDisplay.setMap(map); // map should be already initialized.

    var request = {
        origin : start,
        destination : end,
        travelMode : google.maps.TravelMode.DRIVING
    };
    var directionsService = new google.maps.DirectionsService(); 
    directionsService.route(request, function(response, status) {
        if (status == google.maps.DirectionsStatus.OK) {
            directionsDisplay.setDirections(response);
        }
    });
}