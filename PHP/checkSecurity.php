<!DOCTYPE>
<html>
<head>
</head>
<body>
	<?php
	$securityAnswer = $_POST['secAnswer'];
	if(($_POST['securityText']) == $securityAnswer)
	{?>
		<head>
			<title>Balloons & Co.</title>
			<link rel="stylesheet" type ="text/css" href ="loginStyle.css" />
		</head>
		<h1 id = "header">Balloons & Co.</h1>
		<div id = "login">
		<form method = "post" action = "BalloonLogin.php">
			<p style = "font-size:25px; padding-top:0"><em>Your Password has been emailed to you.<em></p>
			<input type = "submit" name = "register" value = "Try Login Again"/>
		</form>
		</div>
	<?php
	}
	else
	{
		header("Location: lockedOut.php");
	}
	?>
</body>
</html>
			