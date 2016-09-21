$(document).ready(function(){

	var counter = 0;
	
function valuecheck(){
	if(document.getElementById('count').value > 8 ) {
		$("#count").addClass("changeRed");
	} else{
		$("#count").removeClass("changeRed");
	}
}

$("#plus").click(function() {
	document.getElementById('count').value=Number(document.getElementById('count').value) + 1;
	valuecheck();
});
$("#minus").click(function() {
	document.getElementById('count').value=Number(document.getElementById('count').value) - 1;
	valuecheck();
});

$("#reset").click(function() {
	document.getElementById('count').value=0;
	valuecheck();
});
});