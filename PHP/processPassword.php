<!DOCTYPE>
<html>
<head>
	<title>Our Webpage</title>
	<link rel="stylesheet" type ="text/css" href ="welcomeStyles.css"/>
</head>
<body>
	<?php
		function sendError($Count)
		{
			if($Count<3)
			{
				$DisplayForm = TRUE;
			?>
				<div id = "mainBox">
			<?php
				echo "<p class = \"tries\"> The username and password were not entered correctly or do not match. </p>"; 
				echo "<p class = \"tries\"> This is try #$Count. Number of tries left: " .(3-$Count). ".";
			?>
				</div>
			<?php
			}
			else
			{
				header("Location: /errorPage.html");
			}
		}
		$DisplayForm = TRUE;
		$Number = "";
		$Count = 0;
		$usernames = array("Mickey Mouse",
						   "Minnie Mouse",
						   "Donald Duck",
						   "Barney",
						   "Curious George");
		$passwords = array("squeak",
						   "bow",
						   "quack",
						   "purple",
						   "yellow");
						   
		If (isset($_POST['submit']))
		{
			$Count = $_POST['Hidden'];
			$password = $_POST['password'];
			$username = $_POST['username'];
			$isArray = in_array($username, $usernames);
			$index = array_search($username, $usernames);
			if((empty ($username)) || (empty($password) || ($isArray == FALSE)))
			{
				++$Count;
				sendError($Count);
			}
			else if ((is_numeric($index))|| ($index == 0))
			{
				if($passwords[$index] == $password)
				{
					$DisplayForm = FALSE;
					header("Location: /successPage.html");
				}
				else
				{
					sendError($Count);
				}
				
			}
			
		}
		if($DisplayForm)
		{
		?>
			<body>
				<div id = "topBox">
					<h2>Welcome to Our Webpage.</h2>
					<p> Please Enter your Username and Password.</p>
			</div>
			<div id = "mainBox">
				<form name= "welcomePage" action = "processPassword.php" method = "post">
					<p> Username: <input id = "username" type = "text" name = "username"/></p>
					<p> Password: <input id = "password" type = "password" name = "password"/>
					<input type = "hidden" name = "Hidden" value = "<?php echo $Count;?>"/>
					<p><input id = "reset" type = "reset" value = "CLEAR"/>
					<input id = "submit" type = "submit" value = "SUBMIT" name = "submit"/></p>
				</form>
			</div>
			</body>
		<?php
		} 
		?>
</body>
</html>