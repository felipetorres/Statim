var mapShow;

function createMap() {
    var mapCanvas = document.getElementById("map-canvas");
    var mapOptions = { zoom: 16,
                       mapTypeId: google.maps.MapTypeId.HYBRID
                     };
    mapShow = new google.maps.Map(mapCanvas, mapOptions);
	var bounds = new google.maps.LatLngBounds();
	var destinationMarkers = [];
	
	$("#gerarRotas").click(function(){
		var endereco = $("#endereco").val();
		if (endereco != "") {
			plotFlagAtAddress(endereco, mapShow, destinationMarkers);
			calculateRouteBetween(markers, endereco);
		}
	});
	
	return [mapShow, bounds];
}

function clear(markers) {
	for (var i=0;i<markers.length;i++) {
        markers[i].setMap(null);
	}; 
}


$("#localizar").click(function(){
	$.get('map/clear')
	$.get('ping/felipe.gtorres@gmail.com')
});