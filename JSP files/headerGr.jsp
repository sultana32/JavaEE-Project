<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>
<div class="container">
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li><a href="home?lang=DE" class="home">Home</a></li>
				<!-- if user logged in, show sign out. otherwise show register and sign in -->
				<%
					Integer myId = (Integer) session.getAttribute("uid");
					if (myId == null) {
				%>
				<li><a href="/register?token=0" class="register">Registrieren</a></li>
				<li><a href="/login?token=0" class="login">Log in</a></li>
				<%
					} else {
				%>
				<li><a href="#" onclick="signoutConfirmGr();">Log out</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>

	<div class="hero-unitGr"></div>

	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand">Service</a>

			<ul class="nav">

				<li><a href="/balance" class="balance">Kontostand</a></li>
				<li><a href="/deposit?token=0" class="deposit">Einzahlen</a></li>
				<li><a href="/withdraw?token=0" class="withdraw">Auszahlen</a></li>
				<li><a href="/transfer?token=0" class="transfer">Überweisen</a></li>
			</ul>
			<div style="text-align: right">
				<select id="dropdown" onchange="langChange()">
					<option value="English">English</option>
					<option value="Deutsch" selected>Deutsch</option>

				</select>
			</div>



		</div>
	</div>



</div>

