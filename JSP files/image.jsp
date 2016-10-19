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
<link rel="stylesheet" type="text/css" href="mycss/slider.css">



<script src="myjs/jquery.js"></script>
<script src="myjs/includeElement.js"></script>
<script src="myjs/langSelector.js"></script>
<script src="myjs/s3Slider.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#s3slider').s3Slider({
			timeOut : 4000
		});
	});
</script>


</head>

<body class="gallery">
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.5&appId=207548429405226";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>

	<div class="container">
		<%@ include file="header.jsp"%>
		<div id="includescroll"></div>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span3">
					<div id="include_sidebar"></div>
				</div>


				<div class="span9">

					<div id="s3slider">
						<ul id="s3sliderContent">

							<li class="s3sliderImage"><img src="myjs/nature1.jpg">
								<span>The winter is ski time</span></li>

							<li class="s3sliderImage"><img src="myjs/nature2.jpg">
								<span> Old hostoric town here and there</span></li>
							<li class="s3sliderImage"><img src="myjs/nature3.jpg">
								<span>Here mountain and lake sleeps together</span></li>

							<li class="s3sliderImage"><img src="myjs/nature4.JPG">
								<span>Enjoy the colorful fall</span></li>

							<li class="s3sliderImage"><img src="myjs/nature5.jpg">
								<span>Go anywhere and everywhere by train</span></li>
							<div class="clear s3sliderImage"></div>
						</ul>
					</div>
					<br> <br> <br>
					<div class="fb-comments"
						data-href="http://1-dot-rashid-1048.appspot.com/" data-width="500"
						data-numposts="5"></div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>