<!DOCTYPE>
<html>
<head>
</head>
<body>
	<?php
		$errors = 0;
		$DisplaySecurityQuestion = FALSE;
		$DisplayForm = FALSE;
		$CountWrong = $_POST['Hidden'];
		$DBConnect = new mysqli("localhost:3308", "root", "", "balloons&co");
		if($DBConnect === FALSE)
		{
			++$errors;
		}
		$TableName = "customeraccounts";
		$username = stripslashes($_POST['username']);
		$email = stripslashes($_POST['email']);
		$password = md5(stripslashes($_POST['password']));
		if($errors==0)
		{
			$SQLstring = "SELECT customerID, username, email, password FROM $TableName WHERE
			password='".$password."' and username = '".$username."' and email = '".$email."';";
			$QueryResult = $DBConnect->query($SQLstring);
			if(mysqli_num_rows($QueryResult)==0)
			{
				++$CountWrong;
				if($CountWrong<3)
				{
					$DisplayForm = TRUE;
				}
				if($CountWrong>=3)
				{
					$SQLstring = "SELECT customerID, username, email, password, securityAnswer FROM $TableName WHERE username = '".$username."';";
					$QueryResult = $DBConnect->query($SQLstring);
					if(mysqli_num_rows($QueryResult)!=0)
					{
						$DisplayForm = FALSE;
						$DisplaySecurityQuestion = TRUE;
						$Row = $QueryResult->fetch_assoc();
						$mailPassword = $Row['password'];
						$mailEmail = $Row['email'];
						$securityAnswer = $Row['securityAnswer'];
					}
					else
					{
						header("Location: lockedOut.php");
					}
				}
			}
			else
			{
				header("Location: welcomeIn.php");
			}
		}
		?>
		<head>
			<title>Balloons & Co.</title>
			<link rel="stylesheet" type ="text/css" href ="loginStyle.css" />
		</head>
		<h1 id = "header">Balloons & Co.</h1>
			<div id = "login">
			<h4><em>Your Login Information is Invalid.<em></h4>
		<body>
		<?php
		if($DisplayForm == TRUE)
		{?>
			<p style = "font-size:25px; padding-top:0"><em>Please Try Again. Number of tries remaining: <?php echo (3-$CountWrong)?><em></p>
			<form method = "post" action = "VerifyCustomer.php">
				<p>Email Address: <input type = "text" name = "email"/></p>
				<p>Username: <input type = "text" name = "username"/></p>
				<p>Password: <input type = "password" name = "password"/><input type = "hidden"  value = "<?php echo $CountWrong;?>" name = "Hidden"/></p>
				<input type = "reset" name = "reset" value = "Reset Form"/>
				<input type = "submit" name = "register" value = "Login"/>
			</form>
		<?php 
		}
		if($DisplaySecurityQuestion == TRUE)
		{?>
		<p><em>Three tries your out.<em></p>
		<form method = "post" action = "checkSecurity.php">
			<p style = "font-size:25px; padding-top:0"><em>Please Answer your security question and we will email you your password.</em></p>
			<p>What is your favorite animal?<input name = "securityText"/></p>
			<input type = 'hidden' name = 'secAnswer' value = "<?php echo $securityAnswer;?>"/>
			<input type = "reset" name = "reset" value = "Reset Form"/>
			<input type = "submit" name = "mailPass" value = "Email Password"/>
		</form>
		<?php
		}
	?>
</body>
</html>