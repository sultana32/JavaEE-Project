<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<body>
		
		<div class="container">  
		<%@ include file="headerGr.jsp" %>
		<div id="includescrollGr"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebarGr"></div>
					</div>
					
					
					<div class="span9"> 
					
								 <h3>Hallo ${username} </h3>
								 <br>
								<p>Vielen Dank für Ihre Registrierung. </p>
								<!--help-->
								<p>Jetzt können Sie Einzahlung verwenden, übertragen oder widerrufen Funktion</p>
								<p>Sie erhalten täglich um 22 Uhr eine Mail über Ihre Transaktionen. 
								<br>
								Sie können dies jederzeit über den entsprechenden Link in der Mail widerrufen.</p>
					 </div>
	   
				</div>
			</div>
		</div>
	</body>
</html>