<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<div class="container">
	<div class="navbar">
		<div class="navbar-inner">
			<ul class="nav">
				<li id="home"><a href="home?lang=eng" class="home">Home</a></li>
				<!-- if user logged in, show sign out. otherwise show register and sign in -->
				<%
					Integer myId = (Integer) session.getAttribute("uid");
					if (myId == null) {
				%>
				<li><a href="/register?token=0" class="register">Register</a></li>
				<li><a href="/login?token=0" class="login">Sign in</a></li>
				<%
					} else {
				%>
				<li><a href="#" onclick="signoutConfirm();">Sign out</a></li>
				<%
					}
				%>

			</ul>


		</div>
	</div>

	<div class="hero-unit"></div>

	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand">Service</a>

			<ul class="nav">

				<li><a href="/balance" class="balance">Balance</a></li>
				<li><a href="/deposit?token=0" class="deposit">Deposit</a></li>
				<li><a href="/withdraw?token=0" class="withdraw">Withdraw</a></li>
				<li><a href="/transfer?token=0" class="transfer">Transfer</a></li>
			</ul>




		</div>
	</div>



</div>

