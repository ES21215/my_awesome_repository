//Etti Sherman
//Homework #3
//This program reads all objects in an object file.

package edu.wits.spring2020.homework.week3;
import java.util.*;
import java.io.*;
public class StudentListFileReader 
{
	public static void main(String[] args) 
	{
		Scanner stdIn = new Scanner(System.in);
		StudentList studentList;
		System.out.println("Enter filename: ");
		try(ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(stdIn.nextLine())))
		{
			while(true)
			{
				studentList = (StudentList) fileIn.readObject();
				studentList.display();
			} //end while
		} //end try and close fileIn automatically
		catch (EOFException e)
		{} //end-of-file exception terminates infinite while loop
		catch (Exception e)
		{
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		} //end catch
	} //end main
} //end StudentListFileReader Class
