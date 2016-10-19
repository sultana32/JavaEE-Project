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

<body class="transfer">


	<div class="container">
		<%@ include file="header.jsp"%>
		<div id="includescroll"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebar"></div>
				</div>


				<div class="span9">
					<b>${msg}</b>
					<div id=register_box>
						<form action="mytransfer" method="get">
							<label for="amount">amount </label> <input type="text"
								name="amount" /> <br /> <label for="account">Transfer to
								[If you do not know any other user account,give 2]</label> <input
								type="text" name="account" /> <input type="submit" name="submit"
								value="Transfer" />
						</form>

					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>