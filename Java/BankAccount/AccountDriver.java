/*Etti Sherman
*This is a program that keeps track of activity in Bank Accounts.
*/
package edu.wits.spring2020.homework.week1;
import java.util.ArrayList;

public class AccountDriver 
{
	public static void main(String[] args)
	{
		BankAccount[] accounts = new BankAccount[3];
		
		accounts[0] = new Savings(1100, .05);
		accounts[0].deposit(100);
		accounts[0].withdraw(200);
		((Savings)accounts[0]).addInterest();
		
		accounts[1] = new Checking(100);
		accounts[1].deposit(50);
		
		accounts[2] = new Checking(200);
		accounts[2].withdraw(100);
		accounts[2].deposit(75);
		((Checking) accounts[2]).writeACheck(50);
		
		for(int i = 0; i < accounts.length && accounts[i] != null; i++)
		{
			accounts[i].display();
		}
		System.out.println("ArrayList Results: ");
		
		ArrayList<BankAccount> accountsList = new ArrayList<BankAccount>();
		
		accountsList.add(new Savings(1100,.05));
		accountsList.get(0).deposit(100);
		accountsList.get(0).withdraw(200);
		((Savings)accountsList.get(0)).addInterest();	
		
		accountsList.add(new Checking(100));
		accountsList.get(1).deposit(50);
		
		accountsList.add(new Checking(200));
		accountsList.get(2).withdraw(100);
		accountsList.get(2).deposit(75);
		((Checking)accountsList.get(2)).writeACheck(50);
		
		for(BankAccount account:accountsList)
		{
			account.display();
		}
	}
}
