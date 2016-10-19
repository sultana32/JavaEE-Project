<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABC</title>
			<link rel="stylesheet" type="text/css" href="mycss/bootstrap1.css">
			<link rel="stylesheet" type="text/css" href="mycss/bootstrap2.css">
			<link rel="stylesheet" type="text/css" href="mycss/boxes.css">
			<link rel="stylesheet" type="text/css" href="mycss/vmenu.css">
			<link rel="stylesheet" type="text/css" href="mycss/dropdown.css">
			
			<script src="myjs/jquery.js"></script>
			<script src="myjs/includeElement.js"></script>
			<script src="myjs/langSelector.js"></script>
	</head>

	<body class="deposit">
		
	
		<div class="container">  
		<%@ include file="specialHeaderGr.jsp" %>  <!-- special header does not allow to change language mode-->
		<div id="includescrollGr"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebarGr"></div>
					</div>
					
					
					<div class="span9"> 
						<p>
						Jetzt Ihr Ergebnis lautet: = ${balance}
						 </p>
						<br>
						<p>Vielen Dank für Ihren Test </p>
	 				 </div>
	   
				</div>
			</div>
		</div>
	</body>
</html>