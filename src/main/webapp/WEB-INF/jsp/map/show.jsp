<head>
    <title>Statim</title>
    <link type="text/css" rel=StyleSheet href="css/map.css" media=screen >
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
</head>
<body>
    <div id="panel">
		<img src="images/statim.png"/>
		<button onclick="acessa('map/clear');">Limpar mapa</button>
    	<button onclick="acessa('ping/felipe.gtorres@gmail.com')">Localizar aparelhos</button>
    	<input type="checkbox" id="autoZoom" name="autoZoom"><label for="autoZoom">Desabilitar zoom autom&aacute;tico</label>
    </div>
    <div id="map-canvas"></div>

    <script src="javascripts/jquery.min.js"></script>
    <script type="text/javascript" src="javascripts/application.js"></script>
    <script type="text/javascript">
    	var url = "map.json";
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