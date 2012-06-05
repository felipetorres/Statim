<head>
    <title>Location</title>
    <style type="text/css">
        html { height: 100%; }
        body { height: 100%; margin: 0; padding: 0; }
        #map { height: 400px; }
    </style>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
    <script type="text/javascript">
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
    </script>
</head>
<body>
    <div id="map-canvas" style="width:100%;height:100%;"></div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">
    	var url = "./map.json";
    	var map = create();
    	var markers = [];
    	setInterval(function() {
	    	var points = [];
	    	$.getJSON(url,function (json) {
				$.each(json.coordinate, function(i,item){
					points.push([item.latitude, item.longitude])
		  		});
				clear(markers);
		        markers = plot(points, map[0], map[1]);
			});
    	}, 10000);
    </script>
</body>