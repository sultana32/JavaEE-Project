<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta charset="utf-8">
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

	<body class="about">
			<div id="fb-root"></div>
	<script>(function(d, s, id) {
	  var js, fjs = d.getElementsByTagName(s)[0];
	  if (d.getElementById(id)) return;
	  js = d.createElement(s); js.id = id;
	  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=207548429405226";
	  fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));</script>
		
		<div class="container">  
			<%@ include file="headerGr.jsp" %>
			<div id="includescrollGr"></div>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span3">
							<div id="include_sidebarGr"></div>
					</div>
					
					
					<div class="span9"> <!-- main body-->
					
						<p>
						Dies ist ein kleines Web-Projekt in Java. Ich denke, dass die Technologien Java, C#, Datenbank
						und Web-Entwicklung am Arbeitsmarkt Zürich aktuell sehr gefragt sind. Ich habe bereits mit allen
						angeführten Technologien gearbeitet.Aber ich war weg von beruflichen Tätigkeit für eine lange Zeit,
					    obwohl ich nicht weg von kleinen Programmierung oder einfache SW-Entwicklung.
						Also, wenn ich beschlossen, wieder zu kommen, dachte ich, eine Praxis-Projekt wird mich auf dem Laufenden zu kompensieren.
						 </p>
						<br><br>
						<p>
						Ich hatte ein paar Web-Projekte durchgeführt. 
						Ich habe einige dieser Module als Rückgrat dieses Projekt, 
						sondern in Java renoviert. Hier habe ich:
						 </p>
						<br>

	
	
						<div id=mid_box> <!--this box puts the text in mid of the web page-->
							<b>1. Java Version:</b> Java EE in JDK 1.7 da die Google App lediglich JDK 1.7. unterstützt. <br>
							<b> 2.</b> Servlet,JSP,HTML and XML<br>
							<b> 3. Bootstrap 2.3.1 :</b>Ich weiss, dass diese Version ein wenig veraltet ist, aber ich habe sie bereits als
							Grundlage für dieses Projekt verwendet, als es am neuesten Stand war, deswegen habe ich es
							auch jetzt nicht verändert.<br>
							 <b>4. JQuery </b><br>
							<b> 5. Anderes CSS : </b>Ich habe einiges an CSS geschrieben und habe hierfür einige Online-Hilfen in Anspruch genommen.<br>
							<b> 6. IDE: </b>Eclipse mars in Windows 7<br>
							 <b>7. Upload Plattform: </b>Da ich mein Java-Projekt in der Google-App Engine gratis betreiben kann,
							habe ich mich für diese Standard-Plattform entschieden, obwohl es dort einige Einschränkungen gibt.<br>
							<b> 8. Database: </b>GAE cloud SQL<br><br>
						</div>
						<br>
						<p>
						<h3>MVC framework:</h3> 
						Ich habe keine speziellen Framework verwendet, aber ich habe mich strikt am MVC Framework orientiert:
						</p>

						<div id=mid_box>
							<b>Model:</b> Alle Datenbank-Operationen werden in einer bestimmte Datei geschrieben. Diese Datei
							hängt von keinen anderen ab und führt auch keine Berechnungen durch.<br> <br>
							<b>View:</b> Diese Layout-Dateien sind in JSP oder HTML implementiert. Sie sind in zwei Sprachen,
							Deutsch und Englisch vorhanden und kümmern sich nur um die Darstellung von Seiten. View Dateien werden vom Controller aufgerufen.<br> <br>
							<b>Controller: </b>Die Controller-Komponente ist als Java Servlet implementiert und enthält alle logischen
							Operationen. Sie greift über das Modell auf die Datenbank zu und verwendet View um die
							Ausgabe zu erzeugen.
							<br> <br>
						</div>

						Dieses Projekt soll zeigen, dass ich Java-, Datenbank- und Web-Entwicklungs-Erfahrung habe. Ich
						habe einige Projekte in C, C++, OpenGL und C#, jedoch ist es schwer, sich in kurzer Zeit all die
						Neuerungen für diverse Projekte anzueignen.

						<br><br><br><br>
						<div class="fb-comments" data-href="http://1-dot-rashid-1048.appspot.com/" data-width="500" data-numposts="5"></div>
	   
					</div>
				</div>
			</div>
		</div>
	</body>
</html>