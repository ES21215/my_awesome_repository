//Etti Sherman
package edu.wits.spring2020.homework.week1;

public class Savings extends BankAccount
{
	private double interest = 0.0;
	public Savings(int amount, double interest)
	{
		super(amount);
		this.interest = interest;
	}
	public void addInterest()
	{
		amount+=(amount*interest);
	}
	public void display()
	{
		System.out.println("Savings account balance = $" + amount + ".00");
	}
	
}
