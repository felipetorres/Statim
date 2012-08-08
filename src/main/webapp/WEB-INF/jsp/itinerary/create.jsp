<head>
    <title>Statim</title>
    <link type="text/css" rel=StyleSheet href="css/map.css" media=screen >
</head>

<body>
	<div>
		<form action="">
			<select>
	 			<c:forEach items="${devices}" var="device">
					<option value="${device.id}">${device.name}</option>
				</c:forEach>
			</select>
			<div id="itinerary">
				<div id="last" pos="0">
					<input type="text" name="itinerary[0].name">
					<input type="text" name="itinerary[0].number">
				</div>
			</div>
			<input type="submit" name="Bla"> 
		</form>	
	</div>
	
    <script src="/javascripts/jquery.min.js"></script>
	<script type="text/javascript">
	$("form").submit(function(){
		var selectedId = $("option:selected").val();
		$("#last input").remove();
		$(this).attr("action", "/itinerary/sendTo/" + selectedId);
	});
	
	function handler(){
		$(this).removeAttr("id");
		var pos = parseInt($(this).attr("pos")) + 1;
		var newInput =
			'<div id="last" pos="' + pos +'"><input type="text" name="itinerary['+ pos +'].name"><input type="text" name="itinerary['+ pos +'].number"></div>';

		$(newInput).insertAfter($(this));
		$("#last").one("change", handler);
	};

	$("#last").one("change",handler);
	</script>	
</body>