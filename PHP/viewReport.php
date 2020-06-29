<!DOCTYPE>
<html>
<head>
	<title>Balloons & Co.</title>
	<link rel="stylesheet" type ="text/css" href ="loginStyle.css" />
</head>
<body>
	<?php
	$errors = 0;
	$DBConnect = new mysqli("localhost:3308", "root", "", "balloons&co");
	if($DBConnect === FALSE)
	{
		++$errors;
	}
	$Table1 = "customeraccounts";
	$Table2 = "favoriteballoon";
	?>
	<h1 id = "header">Balloons & Co.</h1>
	<div id = "login">
	<h1>We love knowing our customer's favorites.</h1>
	<h4 style="color:#f88379">This Months 3 Most Popular Colors are...</h4>
	<?php
	if($errors==0)
	{
		$SQLstring = "SELECT $Table2.customerID, favColor, recentOrder FROM $Table1, $Table2 WHERE $Table1.customerID = $Table2.customerID;";
		$QueryResult = $DBConnect->query($SQLstring);
		$SQLstring = "SELECT favColor, Count(favColor) FROM $Table2 WHERE recentOrder>\"2020-06-01\" GROUP BY favColor ORDER BY Count(favColor) DESC"; 
		$QueryResult = $DBConnect->query($SQLstring);
		if(mysqli_num_rows($QueryResult)>0)
		{
			while($Row=$QueryResult->fetch_assoc())
				$Results[]=$Row['favColor'];
			mysqli_free_result($QueryResult);
		}
		for($i=0; $i<3; $i++)
		{	
			echo"<p style = \"font-size:'35px'; font-weight: 700\">".$Results[$i]."</p>";
		}
		$SQLstring = "SELECT $Table1.customerID, username, favColor FROM $Table1, $Table2 WHERE $Table1.customerID = $Table2.customerID 
		ORDER BY username";
		$QueryResult = $DBConnect->query($SQLstring);
		$newResults[]="";
		if(mysqli_num_rows($QueryResult)>0)
		{
			while($Row=$QueryResult->fetch_assoc())
				$newResults[]=$Row;
		}
		$DBConnect->close();
		echo "<h4 style=\"color:#f88379\">But Check Out Everyone's Faves...</h4>";
		echo "<table border = '1' width = '50%'>\n";
		echo "<tr>\n";
		echo "<th style = 'background-color:#f88379'>Username</th>\n";
		echo "<th style = 'background-color:#f88379'>Favorite Color</th>\n";
		echo "</tr>\n";
		for($i = 1; $i<sizeof($newResults); $i++)
		{
			echo "<tr>\n";
			echo "<td>".$newResults[$i]['username']."</td>\n";
			echo "<td>".$newResults[$i]['favColor']."</td>\n";
			echo "</tr>\n";
		}
		echo "</table>\n";	
		echo "</div";
	}
	?>
</body>
</html>
	