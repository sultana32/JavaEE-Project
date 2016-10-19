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
	
	
	

	
	<script src="myjs/jquery.js"></script>
	<script src="myjs/includeElement.js"></script>
	<script src="myjs/langSelector.js"></script>
	
	
</head>

	<body>
		
	
		<div class="container">  
		<%@ include file="specialHeader.jsp" %> <!-- special header does not allow to change language mode-->
		<div id="includescroll"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebar"></div>
					</div>
					
					
					<div class="span9"> 
					
					<p>An email has been just sent in your address. Click the link and change your password</p><br>
					Please remind: <br>
					1) The link will not work after 1 hour <br>
					2) You can change password only once with this link <br>
 
       					 </div>        
	 				 </div>
	   
				</div>
			</div>
		</div>
	</body>
</html>