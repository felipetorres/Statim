var service = new google.maps.DirectionsService();
var renderer;
var renderers = [];
var markers = [];
var mapShow;

function calculateRoute(origin, destination) {
	var request = {
		origin: origin,
		destination: destination,
		travelMode: google.maps.TravelMode.DRIVING	
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

function calculateRouteBetween(points, destination) {
	for(var i=0;i<renderers.length;i++){
		renderers[i].setMap(null);
	}
	for(var i=0;i<points.length;i++){
		calculateRoute(points[i].getPosition(), destination);
	}
}

function create() {
    var mapCanvas = document.getElementById("map-canvas");
    var mapOptions = { zoom: 16,
                       mapTypeId: google.maps.MapTypeId.HYBRID
                     };
    mapShow = new google.maps.Map(mapCanvas, mapOptions);
	var bounds = new google.maps.LatLngBounds();
	var destinationMarkers = [];
	
	google.maps.event.addListener(mapShow, 'click', function(event) {
		var marker = locationMarker(event.latLng, mapShow, destinationMarkers);
		calculateRouteBetween(markers, event.latLng);
		destinationMarkers.push(marker);
	});
	
	return [mapShow, bounds];
}

function locationMarker(location, map, markers) {
	clear(markers)
	var flag = 'images/flag.png'
    var marker = new google.maps.Marker({
        map: map,
        icon: flag,
        animation: google.maps.Animation.DROP,
        position: location
    });
	return marker;
}

function plot(points, mapShow, bounds) {
	for (var i=0;i<points.length;i++) {
		point = new google.maps.LatLng(points[i][0],points[i][1]);
        marker = new google.maps.Marker({
            map: mapShow,
            draggable: false,
            position: point
        });
		bounds.extend(point);
		markers.push(marker);
	};
	
	
	var check = document.getElementById("autoZoom");
	if(!check.checked) { 
		mapShow.fitBounds(bounds);
	}
	return markers;
}

function clear(markers) {
	for (var i=0;i<markers.length;i++) {
        markers[i].setMap(null);
	}; 
}

function acessa(url) {
	$.get(url)
}