$(function(){

    doDonut("donutA","6 000 / 10 000 pas");
    doDonut("donutB","75 / 100 min");
    doDonut("donutC","15 / 20 km");
    
    doLine("line_cardiaque","cardiaque");
    doLine("line_historique","historique");
    doLine("line_nbPas","nb pas");
    doLine("line_poids","poids");


    doBar("line_dureeActivite","dureeActivite");
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