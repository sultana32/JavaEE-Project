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

<body class="register">


	<div class="container">
		<%@ include file="header.jsp"%>
		<div id="includescroll"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebar"></div>
				</div>


				<div class="span9">
					<b>${msg} </b>
					<div id=register_box>
						<form action="myregister" method="get">

							<!-- Simple text field -->
							<label for="name">Name </label> <input type="text" name="name" />

							<br />

							<!-- Email -->
							<label for="email">Email </label> <input type="email"
								name="email" /> <br /> <label for="pwd">Password:</label> <input
								type="password" id="pwd" name="pwd"> <label
								for="confirmpwd">Confirm Password:</label> <input
								type="password" id="confirmpwd" name="confirmpwd"> <input
								type="submit" name="submit" value="Register" />
						</form>
						* No field can be empty<br> *Minimum password length=6<br>
						* An email address can not be used for more than one registration<br>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>