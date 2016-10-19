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
		<%@ include file="specialHeaderGr.jsp"%>
		<div id="includescrollGr"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebarGr"></div>
				</div>


				<div class="span9">
					<h3>Hallo ${username}</h3>
					<br>
					<p>Ich danke Ihnen für die Prüfung meines Projektes. Es ist
						eine Praxis-Projekt nur, nichts professionell. So kann es einige
						Fehler.</p>

					<p>Sie können nun zu hinterlegen, die Übertragung, Menge
						zurücktreten.</p>
					<p>Ich werde glücklich sein, wenn Sie mit Ihrem Feedback per
						Post Abschnitt dieses Projekt zu geben.</p>
					<p>
						erhalten Sie eine E-Mail auf Ihre Transaktionen Alltags 10.00 zu
						bekommen. Ich habe es als <i>Cron-Job</i>. Sie können ganz einfach
						abmelden über den Link in der E-Mail selbst bereitgestellt
					</p>
				</div>

			</div>
		</div>
	</div>
</body>
</html>