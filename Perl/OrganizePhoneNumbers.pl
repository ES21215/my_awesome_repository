#Etti Sherman
#Phone Number Organizer
#!/usr/local/bin/perl

@phones = ('9085551000', '555.3350X32', '410.555-9777X552', '(718) 555-3600 extension 40');

foreach $phoneNumber(@phones)
{
	@allNumbers = $phoneNumber =~ /(\d+)/g;
	@newNumbers = "";
	$allNumbers = join("", @allNumbers);
	$size = length $allNumbers;
	$phoneNumber =~ /(x)/i;
	$extension = $';
	$number = $`;
	@extension = $extension =~ /(\d+)/;
	@number = $number =~ /(\d+)/g;
	$number = join("", @number);
	$size2 = length $number;
	if(@extension == 0)
	{
		if($size == 10)
		{
			$first = substr($allNumbers, 0, 3);
			$middle = substr($allNumbers, 3, 3);
			$last = substr($allNumbers, 6, 4);
			@newNumbers = "($first)$middle-$last";
		}
		else
		{
			$middle = substr($allNumbers, 0, 3);
			$last = substr($allNumbers, 3, 4);
			@newNumbers = "(410)$middle-$last"; 
		}
	}
	else 
	{
		if($size2 == 10)
		{
			$first = substr($allNumbers, 0, 3);
			$middle = substr($allNumbers, 3, 3);
			$last = substr($allNumbers, 6, 4);
			@newNumbers = "($first)$middle-$last ext @extension";
		}
		else
		{
			$middle = substr($allNumbers, 0, 3);
			$last = substr($allNumbers, 3, 4);
			@newNumbers = "(410)$middle-$last ext @extension"; 
		}
	}
	print "@newNumbers\n";
}