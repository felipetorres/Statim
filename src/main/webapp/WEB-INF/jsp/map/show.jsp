<head>
    <title>Location</title>
    <style type="text/css">
        html { height: 100%; }
        body { height: 100%; margin: 0; padding: 0; }
        #panel button { width: 150px; margin-left: 15px; vertical-align: top; margin-top: 15px;}
        #panel img { margin-top: 5px;}
        #panel { height: 10%; min-height: 50px;}
        #map-canvas { width:100%; height:90%;}
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
    <div id="panel">
		<img src="images/statim.png"/>
    	<button onclick="/map/clear">Limpar mapa</button>
    	<button onclick="/ping/felipe.gtorres@gmail.com">Localizar aparelhos</button>
    </div>
    <div id="map-canvas"></div>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">
    	var url = "./map.json";
    	var map = create();
    	var markers = [];
    	setInterval(function() {
	    	var points = [];
	    	$.getJSON(url,function (json) {
				$.each(json.coordenadas, function(i,item){
					points.push([item.latitude, item.longitude])
		  		});
				clear(markers);
		        markers = plot(points, map[0], map[1]);
			});
    	}, 10000);
    </script>
</body>