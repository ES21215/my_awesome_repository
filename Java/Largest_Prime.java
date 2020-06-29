import java.util.Scanner;
public class Largest_Prime2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a Number (Negative to Quit):");
		int num;
		int largestPrime = 1;
		num = input.nextInt();
		boolean prime = true;
		int count = 0;
		
		while(num >= 0)
		{
			count = 2;
			prime = true;
			while(count<num && prime) 
			{
					if(num%count == 0) 
					{
						prime  = false;
					}
					else
					{
						count++;
						//System.out.print("Went");
					}
			}
			if (prime && num>largestPrime) 
			{
					largestPrime = num;
					
			}
			System.out.println("Enter a Number (Negative to Quit): ");
			num = input.nextInt();
		}
		if (largestPrime == 1)
		{
			System.out.print("No prime numbers were entered.");
		}
		else 
		{
			System.out.print("The largest prime number entered was: " + largestPrime);
		}
			
}}
