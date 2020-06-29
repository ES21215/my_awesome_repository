<!DOCTYPE>
<html>
<head>
</head>
<body>
	<?php
		$errors=0;
		$email = stripslashes($_POST['email']);
		$password = stripslashes($_POST['password']);
		$password2 = stripslashes($_POST['password2']);	
		$username = stripslashes($_POST['username']);	
		$fullname = stripslashes($_POST['name']);	
		$securityAnswer = stripslashes($_POST['securityText']);
		$errorInfo = "";
		if((empty($email)) || (empty($password2)) || (empty($password)) || (empty($securityAnswer)) 
			|| (empty($fullname)) || (empty($username)))
		{
			$errorInfo.="<p class = 'err'> Please fill out the entire form. ";
			++$errors;
		}
		else
		{
			$email = stripslashes($_POST['email']);
			$password = stripslashes($_POST['password']);
			$password2 = stripslashes($_POST['password2']);	
			$username = stripslashes($_POST['username']);	
			$fullname = stripslashes($_POST['name']);	
			$securityAnswer = stripslashes($_POST['securityText']);
		}
		if($errors == 0)
		{
			if(!(empty($password) && (!(empty($password2)))))
			{
				if(strlen($password)<6)
				{
					++$errors;
					$errorInfo.="<p class = 'err'>The password is too short. ";
					$password="";
					$password2="";
				}
				if($password<>$password2)
				{
					++$errors;
					$errorInfo.="<p class = 'err'>The passwords don't match. ";
					$password="";
					$password2="";
				}
			}
		}
		$DBConnect = FALSE;
		if($errors == 0)
		{
			$DBConnect = new mysqli("localhost:3308", "root","","balloons&co");
			if ($DBConnect === FALSE)
			{
				echo "<p>Unable to connect to the database server. Error Code ". mysql_errno(). ": ".
				mysql_error(), "</p>\n";
			}
			$TableName = "customeraccounts";
			$SQLString = "SELECT count(*) as mycount FROM $TableName where email = '$email';";
			$QueryResult = $DBConnect->query($SQLString);
			if($QueryResult!==FALSE)
			{
				$Row = $QueryResult->fetch_assoc();
				if($Row["mycount"]>0)
				{
					$errorInfo.="<p class = 'err'> The email address entered (".htmlentities($email).") is already registered. ";
					++$errors;
				}
			}
		}
		if($errors>0)
		$errorInfo.="Please Refill in Form.</p>";
		{?>
			<head>
			<title>Balloons & Co.</title>
			<link rel="stylesheet" type ="text/css" href ="loginStyle.css" />
			</head>
			<h1 id = "header">Balloons & Co.</h1>
			<p style = "color:#f88379">Fix Registration Information</p>
			<?php echo $errorInfo ?>
				<div id = "login">
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
		<?php
		}
		if($errors == 0)
		{
			$password = md5($password);
			$SQLString = "INSERT INTO $TableName (username, password, securityAnswer, email)VALUES('$username', '$password',
			'$securityAnswer', '$email');";
			$QueryResult = $DBConnect->query($SQLString);
			if($QueryResult===TRUE)
			{
				header("Location: welcomeIn.php");
			}
		}
	?>
</body>
</html>