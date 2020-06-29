import java.util.Scanner;
public class BinaryConvertor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isBinary = true;
		do
		{
			long lastNumber = 0;
			double total = 0;
			int count = 0;
			double pow = 0;
			isBinary = true;
			System.out.println("Enter a Binary Number (up to 20 digits):");
			long binary = input.nextLong();
			while (binary>=1) 
			{//to keep to the length of the Binary
				lastNumber = binary%10;
				binary = binary/10;
				if(lastNumber != 0 && lastNumber != 1)
				{//checking it is a Binary
					isBinary = false;
				}
				else if(lastNumber == 1)
				{
					total = total + Math.pow(2, count);
				}
				count++;
			}
			if(isBinary)
			{//binary is valid, output decimal format
				System.out.println("Decimal: " + total);
			}
			else
			{//binary invalid, prompt user to re-enter Binary
				System.out.println("Invalid Entry");
			}
		} while(!isBinary);
	}
}
