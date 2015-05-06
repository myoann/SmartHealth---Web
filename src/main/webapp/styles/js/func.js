var _numIMG=1;
var _speedSilde=3000;
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


var _view=true;
function viewMenu(){
	console.log(_view);
	var _nb=0;
	if (!_view){
		$("div#filter_dark").fadeOut();
		_nb=-263;
	}else{
		$("div#filter_dark").show();
		_nb=0;
	}
	$("div#menu").css({
		right:_nb+"px"
	})
	_view=!_view;
}

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
			$("iframe#webmap").slideUp();
			$(this).find("span").html("<br>Afficher la map");
			$(this).find("span").attr("class","icon-arrow-down-3");
			$("iframe#webmap").removeAttr("src");
		}else{
			$("iframe#webmap").slideDown();
			$(this).find("span").html("<br>Cacher la map");
			$(this).find("span").attr("class","icon-arrow-up-3");
			$("iframe#webmap").attr("src","https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d92299.33014380158!2d7.25281705!3d43.70319045!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12cdd0106a852d31%3A0x40819a5fd979a70!2sNice!5e0!3m2!1sfr!2sfr!4v1430042770430");
		}
		console.log(this);
		$(this).toggleClass("map_open");
	})
}