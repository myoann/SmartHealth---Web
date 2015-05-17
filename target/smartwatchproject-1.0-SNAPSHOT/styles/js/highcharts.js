$(function(){
    
    doDonut("donutB","75 / 100 min");
    doDonut("donutC","15 / 20 km");
    
    doLine("line_cardiaque","Cardiaque");
    doLine("line_historique","Historique");
    doLine("line_nbPas","Nombre de pas");
    doLine("line_poids","Poids");


<<<<<<< HEAD
    doBar("line_dureeActivite","dureeActivite");
})
=======
    doBar("line_dureeActivite","Durée de l'activité");
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
>>>>>>> f09ef9bfc15e5de26cc8bf4eef173afb6ae2207e
