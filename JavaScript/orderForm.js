function promptTime()
{
	document.getElementById("otherTime").type = "text";
}
function calculate()
{
	document.getElementById("header").innerHTML = 'Reciept';
	document.getElementById("fname").innerHTML = "First Name:" + " " + first.value;
	document.getElementById("lname").innerHTML = "Last Name:" + " " + last.value;
	document.getElementById("num").innerHTML = "Phone #:" + " " + phone.value;
	document.getElementById("@email").innerHTML = "Email:" + " " + email.value;
	var check = 0;
	if(document.getElementById('coral').checked)
	{
		document.getElementById("lblCoral").innerHTML = "Coral    X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblCoral").innerHTML = "Coral    X    " + 0 +    " = $0.00";
	}
	if(document.getElementById('teal').checked)
	{
		document.getElementById("lblTeal").innerHTML = "Teal    X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblTeal").innerHTML = "Teal    X    " + 0 +    " = $0.00";
	}
	if(document.getElementById('robin').checked)
	{
		document.getElementById("lblRobin").innerHTML = "Robin's Egg    X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblRobin").innerHTML = "Robin's Egg    X    " + 0 +    " = $0.00";
	}
	if(document.getElementById('gold').checked)
	{
		document.getElementById("lblGold").innerHTML = "Gold    X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblGold").innerHTML = "Gold    X    " + 0 +    " = $0.00";
	}
	if(document.getElementById('silver').checked)
	{
		document.getElementById("lblSilver").innerHTML = "Silver    X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblSilver").innerHTML = "Silver    X    " + 0 +    " = $0.00";
	}
	if(document.getElementById('lavendar').checked)
	{
		document.getElementById("lblLavendar").innerHTML = "Lavendar   X    " + perColor.value +    " = $" + (perColor.value * 3) + ".00";
		check+=1;
	}
	else
	{
		document.getElementById("lblLavendar").innerHTML = "Lavendar   X    " + 0 +    " = $0.00";
	}
	var del = "Unchecked";
	if(document.getElementById("morning").checked)
	{
		del = "Morning";
	}
	else if(document.getElementById("after").checked)
	{
		del = "Afternoon";
	}
	else if(document.getElementById("even").checked)
	{
		del = "Evening";
	}
	else if(document.getElementById("other").checked)
	{
		del = otherTime.value;
	}
	document.getElementById("delivery").innerHTML = "Delivery: " + del;
	document.getElementById("total").innerHTML = "Total:  $" + (perColor.value*check*3) + ".00";
}

	
