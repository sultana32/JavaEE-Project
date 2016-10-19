<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABC</title>
		<link rel="stylesheet" type="text/css" href="mycss/bootstrap1.css">
		<link rel="stylesheet" type="text/css" href="mycss/bootstrap2.css">
		<link rel="stylesheet" type="text/css" href="mycss/vmenu.css">
		<link rel="stylesheet" type="text/css" href="mycss/dropdown.css">
		
		<script src="myjs/jquery.js"></script>
		<script src="myjs/includeElement.js"></script>
		<script src="myjs/langSelector.js"></script>
   </head>
   

	<body class="home">
	
		<div id="fb-root"></div>  <!-- code to integrate fb comment -->
				<script>(function(d, s, id) {
				  var js, fjs = d.getElementsByTagName(s)[0];
				  if (d.getElementById(id)) return;
				  js = d.createElement(s); js.id = id;
				  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=207548429405226";
				  fjs.parentNode.insertBefore(js, fjs);
				}(document, 'script', 'facebook-jssdk'));</script>
	
		<div class="container">  
			<%@ include file="header.jsp" %> <!-- Include English header -->
			<div id="includescroll"></div>   <!-- Include English scroll -->
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebar"></div> <!-- side menu -->
					</div>
					
					<div class="span9"> 
						<p>	
						I am the solo developer, so there may be some problem in the project.
						I'll be grateful if you give me feedback through email section.
						</p>
						
	 					<h4>Here is a 2 minute video on me<i></i></h4>
						<iframe width="560" height="315" src="https://www.youtube.com/embed/6jUI7thp-S4" frameborder="0" allowfullscreen></iframe>
						<br> <br><br>
						
						<div class="fb-comments" data-href="http://1-dot-rashid-1048.appspot.com/" data-width="500" data-numposts="5"></div>
					 </div>
			  	</div>
			  </div>
		</div>
	</body>
</html>