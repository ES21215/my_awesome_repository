import java.util.Scanner;
public class Integers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner input = new Scanner(System.in);	
	System.out.println("Enter an integer: ");
	int num1 = input.nextInt();
	System.out.println("Enter an integer: ");
	int num2 = input.nextInt();
	System.out.println("Enter an integer: ");
	int num3 = input.nextInt();
	
	int largest=0;
	int smallest =0;
	int middle=0;
	
	if(num1>=num3 && num1>=num2) {
		largest = num1;
	}
	else if(num2>=num3 && num2>=num1) {
		largest = num2;
	}
	else if(num3>=num1 && num3>=num2) {
		largest = num3;
	}
	
	if(num1<=num3 && num1<=num2) {
		smallest = num1;
	}
	else if(num2<=num3 && num2<=num1) {
		smallest = num2;
	}
	else if(num3<=num1 && num3<=num2) {
		smallest = num3;
	}
	
	
	if(smallest == num1 && largest == num3) {
		middle = num2;
	}
	else if(smallest == num2 && largest == num3) {
		middle = num1;
	}
	else if(smallest == num2 && largest == num1) {
		middle = num3;
	}
	else if(largest == num1 && smallest == num3) {
		middle = num2;
	}
	else if(largest == num2 && smallest == num3) {
		middle = num1;
	}
	else if(largest == num2 && smallest== num1) {
		middle = num3;
	}
	
	System.out.println("Sum:" + (num1+num2+num3));
	System.out.println("Difference of largest and smallest integer:" + (largest-smallest));
	System.out.println("Product:" + (num1*num2*num3));
	System.out.println("In ascending order:" + smallest + "," + middle+ ","+ largest);
	}}

