function create() {
    var mapCanvas = document.getElementById("map-canvas");
    var mapOptions = { zoom: 16,
                       mapTypeId: google.maps.MapTypeId.HYBRID
                     };
    var mapShow = new google.maps.Map(mapCanvas, mapOptions);
	var bounds = new google.maps.LatLngBounds();
	return [mapShow, bounds];
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
	mapShow.fitBounds(bounds);
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