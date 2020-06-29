import java.util.Scanner;
public class Homework_Week3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String character = "";
		int size = 0;
		int x = 1;
		int y = 0;
		int t = 0;
		String shape = "";
		String shape1 = "";
		System.out.print("Please enter a character: ");
		character = input.next();
		System.out.print("Please enter the size of your shape: ");
		size = input.nextInt();
		System.out.print("Please enter a shape(Checkerboard, Hollow Square, or Filled Square): ");
		shape = input.next();
		if (shape.equalsIgnoreCase("checkerboard")) 
		{
			do 
			{
				for(int i = 1; i<size;i++) 
				{
					System.out.print(character);
				}
				
			if (x%2 == 0) 
			{
				System.out.println(character);
				
			}
			else
			{
				System.out.println(character);
				System.out.print(" ");
			}
			x++;
			}while (x<size+1);

			}
		else if(shape.equalsIgnoreCase("hollow")) 
		{
			while(x<=size) 
			{
			if(x==1) 
			{
				for(int i = 1; i<size;i++) 
				{
					System.out.print(character);
					if (i==size-1) 
					{
						System.out.println(character);
					}
			}	}
			else if (x<size) 
			{
				t = 0;
					System.out.print(character);
					while (t < size-2) 
					{
						System.out.print(" ");
						t++;
					}
					System.out.println(character);
				}
			else if (x == size) 
			{
				for(int i = 1; i<size+1;i++) 
				{ 
				System.out.print(character); //the extra S.O.P outside the for loop 
			}	}
			x++;

		
			}}
		else if (shape.equalsIgnoreCase("filled")) {
			while(x<size+1) {
			for(int i = 1; i<size;i++) 
			{
				System.out.print(character);
				if(i == size -1) {
				System.out.println(character);
			}
					
				}
			x++;
			}
			
		
		}
		else {
			System.out.println("You entered an invaled shape.");
		}
}}
