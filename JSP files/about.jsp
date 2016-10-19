<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>ABC</title>
		
		<link rel="stylesheet" type="text/css" href="mycss/bootstrap1.css">
		<link rel="stylesheet" type="text/css" href="mycss/bootstrap2.css">
		<link rel="stylesheet" type="text/css" href="mycss/vmenu.css">
		<link rel="stylesheet" type="text/css" href="mycss/boxes.css">
		
		<script src="myjs/jquery.js"></script>
		<script src="myjs/includeElement.js"></script>
		<script src="myjs/langSelector.js"></script>
	
	</head>

	<body class="about"> 
			<div id="fb-root"></div>		<!-- code to integrate fb comment -->
			<script>(function(d, s, id) {
			  var js, fjs = d.getElementsByTagName(s)[0];
			  if (d.getElementById(id)) return;
			  js = d.createElement(s); js.id = id;
			  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=207548429405226";
			  fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));</script>
			
		<div class="container">  
			<%@ include file="header.jsp" %> <!-- include header-->
			<div id="includescroll"></div>   <!-- include scroll-->
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebar"></div>  <!-- include side menu -->
					</div>
					
					
					<div class="span9"> 
					<p>
					This is a small Java EE web development practice project. I found that Java,C#, database and web development have good
					demand in Zurich IT job market. I have worked in all these platforms.But I was away from professional 
					activity for a long time though I was not away from small programming or simple sw development.
					So when I decided to come back, I thought a practice project will make me up to date.
					</p>
					<br>
					<p>
					I had some web projects done. I used some of those modules as backbone of this project 
					but renovated in Java. Here I used:
					</p>
					<br>
					<div id=mid_box> <!-- this box puts the text in mid of the web page-->
											<b>1. Java technology:</b> Java EE in JDK 1.7 because Google App Engine supports only JDK 1.7.<br>
						<b> 2.FreegeoIP:</b> I used their service to determine the user's geo location. According to location this site loads either in German/English.<br>
						<b>3</b> Servlet, JSP,HTML, XML <br>
						<b> 4. Bootstrap 2.3.1 :</b> I know this version is a bit old but I used it in 
						 my backbone project when version 2.3.1 was new. And now I did not make changes.<br>
						 <b>5. JQuery </b><br>
						<b> 6. Other CSS: </b>I wrote some CSS and took help from some online sources.<br>
						<b> 7. IDE: </b>Eclipse mars in Windows 7<br>
						 <b>8. Upload platform: </b>I found that I can put my Java EE web project in Google App Engine without any cost. And it is a standard platform.
						 So though it has several limitations ,I used GAE. I used its cron job feature to send daily email.<br>
						<b> 9. Database: </b>GAE cloud SQL<br><br>
					</div>
					<br>
					<p>
					<h3>MVC framework:</h3> 
					I did not use any explicit framework in this project. But strictly followed MVC framework myself.As:
					</p>

					<div id=mid_box>
						<b>Model:</b> All database operations are written in a specific file.It is not connected with any other class.It does not
						know any logic but does only database operations.<br>
						<b>View:</b> View files are either JSP or HTML files. They only deal with what we want to show the viewers. All view files are in two languages (English and
						German). View files are invoked from controller files.<br>
						<b>Controller: </b>These are Java Servlet files. All logical operations goes there. They call database functions from Model files and invoke
						View files to show the pages.<br>
					</div>

					It is a project to show that I have experience in Java, database and web development technologies.
					I have some projects done in C,C++,
					OpenGL and C#.But it is hard to find enough time to refurbish all the projects.
					<br><br><br> <br>
	<div class="fb-comments" data-href="http://1-dot-rashid-1048.appspot.com/" data-width="500" data-numposts="5"></div>
					</div>
	   
				</div>
			</div>
		</div>
	</body>
</html>