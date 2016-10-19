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

<body class="mail">
	<div class="container">
		<%@ include file="headerGr.jsp"%>
		<div id="includescrollGr"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebarGr"></div>
				</div>


				<div class="span9">
					<div id=register_box>
						<b>${msg}</b>
						<form action="mymail" method="get">

							<!-- Simple text field -->
							<label for="name">Name </label> <input type="text" name="name" />
							<br />

							<!-- Email -->
							<label for="email">Email </label> <input type="email"
								name="email" /> <br />


							<!-- Textarea -->
							<label for="description">Ihre Nachricht</label>
							<textarea name="description" cols="80" rows="5"></textarea>
							<br /> <input type="submit" name="submit" value="Senden" />
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>