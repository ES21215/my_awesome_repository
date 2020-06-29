//Etti Sherman
//Homework #3
//This program writes objects to an object file.

package edu.wits.spring2020.homework.week3;
import java.io.*;
import java.util.*;
public class StudentListFileWriter 
{
	public static void main(String[] args)
	{
		Scanner stdIn = new Scanner(System.in);
		StudentList studentList;
		
		System.out.println("Enter filename: ");
		try(ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(stdIn.nextLine())))
		{
		String [] names = {"Caleb","Izumi","Mary","Usha"};
		studentList = new StudentList(names);	
		fileOut.writeObject(studentList);
		
		String [] names2 = {"Caleb","Izumi","Mary","Usha","Etti"};
		studentList = new StudentList(names2);
		fileOut.writeObject(studentList);
		
		studentList.removeStudent(1);
		fileOut.reset();
		fileOut.writeObject(studentList);
		
		} //end try and close file automatically
		catch(Exception e)
		{
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		} //end catch
	} //end main
} //end StudentListFileWriter Class
