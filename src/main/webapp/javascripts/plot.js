var markers = [];

function plot(points, map, bounds) {
	for (var i=0;i<points.length;i++) {
		point = new google.maps.LatLng(points[i][0],points[i][1]);
		title = points[i][2];
        marker = new google.maps.Marker({
            map: map,
            draggable: false,
            position: point,
            title: title
        });
		bounds.extend(point);
		markers.push(marker);
	};
	
	var check = document.getElementById("autoZoom");
	if(!check.checked) { 
		map.fitBounds(bounds);
	}
	return markers;
}

function drawPointsOnMap(url, markerList, map) {
    var points = [];
    $.getJSON(url,function (json) {
            $.each(json.coordenadas, function(i,item){
                    points.push([item.latitude, item.longitude, item.deviceName])
            });
            clear(markerList);
            markerList = plot(points, map[0], map[1]);
    });
    setTimeout(function (){ drawPointsOnMap(url, markerList, map); } ,10000);
}

function plotFlagAtAddress(address, map, markers) {
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode({'address': address}, function(results, status) {
		if (status == google.maps.GeocoderStatus.OK) {
			createMarker(results[0].geometry.location, map, markers)
		}
	});
}

function createMarker(location, map, markers) {
	clear(markers)
	var flag = 'images/flag.png'
    var marker = new google.maps.Marker({
        map: map,
        icon: flag,
        animation: google.maps.Animation.DROP,
        position: location
    });
	markers.push(marker);
}