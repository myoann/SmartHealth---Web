var _numIMG=1;
var _speedSilde=3000;
$(function(){
	//$(document).bind("contextmenu",function(e){	return false; });
	//displaySection();

	setInterval(function(){ chgBG() },_speedSilde);
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