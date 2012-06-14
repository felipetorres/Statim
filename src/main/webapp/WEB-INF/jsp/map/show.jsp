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
    	<div id="option">
    		<label><input type="checkbox" id="autoZoom"/>Desabilitar zoom autom&aacute;tico</label>
    	</div>
    </div>
    <div id="map-canvas"></div>

    <script src="javascripts/jquery.min.js"></script>
    <script type="text/javascript" src="javascripts/application.js"></script>
    <script type="text/javascript">
    	var map = create();
    	var markers = [];
    	drawPointsOnMap("map.json", markers, map);
    </script>
</body>