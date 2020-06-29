//Etti Sherman
package edu.wits.spring2020.homework.week1;

public class Checking extends BankAccount
{
	public Checking(int amount)
	{
		super(amount);
	}
	public void writeACheck(int amountWritten)
	{
		amount-=amountWritten+1;
	}
	public void display()
	{
		System.out.println("Checking account balance = $" + amount + ".00");
	}
}
