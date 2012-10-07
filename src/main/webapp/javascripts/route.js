var service = new google.maps.DirectionsService();
var renderer;
var renderers = [];

function calculateRouteBetween(points, destination) {
	for(var i=0;i<renderers.length;i++){
		renderers[i].setMap(null);
	}
	for(var i=0;i<points.length;i++){
		calculateRoute(points[i].getPosition(), destination);
	}
}

function calculateRoute(origin, destination) {
	var request = {
		origin: origin,
		destination: destination,
		travelMode: google.maps.TravelMode.DRIVING,
		unitSystem: google.maps.UnitSystem.METRIC
	};
	service.route(request, function(response, status) {
		if (status == google.maps.DirectionsStatus.OK) {
			renderer = new google.maps.DirectionsRenderer();
			renderer.suppressMarkers = true;
			renderer.setMap(mapShow);
	    	renderer.setDirections(response);
	    	renderers.push(renderer);
	    }
	});
}