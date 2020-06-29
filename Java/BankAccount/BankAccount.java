//Etti Sherman
package edu.wits.spring2020.homework.week1;

public abstract class BankAccount 
{
	protected int amount = 0;
	
	public BankAccount(int amount)
	{
		this.amount = amount;
	}
	public void deposit(int amountDeposit)
	{
		amount+=amountDeposit;
	}
	public void withdraw(int amountWithdraw)
	{
		amount-=amountWithdraw;
	}
	public abstract void display();
	
}

