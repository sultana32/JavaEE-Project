<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC</title>
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>
<script src="myjs/jquery.js"></script>
<script src="myjs/includeElement.js"></script>

<script src="myjs/langSelector.js"></script>

<link rel="stylesheet" type="text/css" href="mycss/bootstrap1.css">
<link rel="stylesheet" type="text/css" href="mycss/bootstrap2.css">
<link rel="stylesheet" type="text/css" href="mycss/boxes.css">
<link rel="stylesheet" type="text/css" href="mycss/vmenu.css">







</head>

<body class="map">


	<div class="container">
		<%@ include file="header.jsp"%>
		<div id="includescroll"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebar"></div>
				</div>


				<div class="span9">

					<p>I like Google maps very much and use this awesome Google
						service now and then. So I wanted to integrate Google maps in my
						practice project and customize in my own way.</p>

					<div id="map" style="width: 550px; height: 450px;"></div>

					<script type="text/javascript">
						var locations = [
								[ 'Home', 47.270135, 8.581977, 4, 'green.png' ],
								[ 'Sihl city', 47.372913, 8.536036, 5,
										'red.png' ],
								[ 'Muri', 47.273579, 8.341557, 3, 'yellow.png' ] ];

						var map = new google.maps.Map(document
								.getElementById('map'),
								{
									zoom : 10,
									center : new google.maps.LatLng(47.353620,
											8.495860),
									mapTypeId : google.maps.MapTypeId.ROADMAP
								});

						var infowindow = new google.maps.InfoWindow();

						var marker, i;

						for (i = 0; i < locations.length; i++) {

							marker = new google.maps.Marker({
								position : new google.maps.LatLng(
										locations[i][1], locations[i][2]),
								icon : locations[i][4],
								map : map
							});

							google.maps.event
									.addListener(
											marker,
											'mouseover',
											(function(marker, i) {
												return function() {
													infowindow
															.setContent(locations[i][0]);
													infowindow
															.open(map, marker);
												}
											})(marker, i));
						}
					</script>


				</div>

			</div>
		</div>
	</div>
</body>
</html>