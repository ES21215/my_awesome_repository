<!DOCTYPE>
<html>
<head>
	<title>Balloons & Co.</title>
	<link rel="stylesheet" type ="text/css" href ="loginStyle.css" />
</head>
<body>
	<h1 id = "header">Balloons & Co.</h1>
	<div id = "login">
	<div id = "old">
	<h3>Returning Customer Login</h3>
	<form method = "post" action = "VerifyCustomer.php">
		<p>Email Address: <input type = "text" name = "email"/></p>
		<p>Username: <input type = "text" name = "username"/></p>
		<p>Password: <input type = "password" name = "password"/><input type = "hidden" name = "Hidden"/></p>
		<p style = "font-size:15px; padding-top:0"><em>(Passwords are case-sensitive and must be at least 6 characters long)</em></p>
		<input type = "reset" name = "reset" value = "Reset Form"/>
		<input type = "submit" name = "register" value = "Login"/>
	</form>
	</div>
	<hr/>
	<div id = "new">
	<h3>New Customer Registration</h3>
	<form method = "post" action = "registerCustomer.php">
		<p>Full Name: <input type = "text" name = "name"/></p>
		<p>Username: <input type = "text" name = "username"/></p>
		<p>Email address: <input type = "text" name = "email"/></p>
		<p>Password: <input type = "password" name = "password"/></p>
		<p>Confirm password: <input type = "password" name = "password2"/></p>
		<p style = "font-size:15px; padding-top:0"><em>(Passwords are case-sensitive and must be at least 6 characters long)</em></p>
		<p>What is your favorite animal?<input name = "securityText"/></p>
		<input type = "reset" name = "reset" value = "Reset Registration Form"/>
		<input type = "submit" name = "register" value = "Register"/>
	</form>
	</div>
	</div>
</body>
</html>