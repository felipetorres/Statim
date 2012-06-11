function create() {
    var mapCanvas = document.getElementById("map-canvas");
    var mapOptions = { zoom: 16,
                       mapTypeId: google.maps.MapTypeId.HYBRID
                     };
    var mapShow = new google.maps.Map(mapCanvas, mapOptions);
	var bounds = new google.maps.LatLngBounds();
	
	google.maps.event.addListener(mapShow, 'click', function(event) {
		locationMarker(event.latLng, mapShow);
	});
	
	return [mapShow, bounds];
}

function locationMarker(location, map) {
    var marker = new google.maps.Marker({
        map: map,
        position: location
    });
}

function plot(points, mapShow, bounds) {
	var markers = [];
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