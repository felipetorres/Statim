<head>
    <title>Statim</title>
    <link type="text/css" rel=StyleSheet href="css/map.css" media=screen >
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
</head>
<body>
    <div id="panel">
		<img src="images/statim.png"/>
    	<button id="localizar">Localizar aparelhos</button>
    	<div id="option">
    		<label><input type="checkbox" id="autoZoom"/>Desabilitar zoom autom&aacute;tico</label>
    	</div>
   		<input type="text" id="endereco">
   		<button id="gerarRotas">Gerar rotas</button>
    </div>
    <div id="map-canvas"></div>

    <script src="javascripts/jquery.min.js"></script>
    <script type="text/javascript" src="javascripts/route.js"></script>
    <script type="text/javascript" src="javascripts/plot.js"></script>
    <script type="text/javascript" src="javascripts/application.js"></script>
    <script type="text/javascript">
    	var map = createMap();
    	var markers = [];
    	drawPointsOnMap("map.json", markers, map);
    </script>
</body>