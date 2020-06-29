//Etti Sherman
//Homework #3
//This class manages an ArrayList of students.

package edu.wits.spring2020.homework.week3;
import java.io.Serializable;
import java.util.ArrayList;
public class StudentList implements Serializable 
{
	ArrayList<String> students = new ArrayList<>();
	public StudentList(String[] names)
	{
		for (int i = 0; i<names.length;i++)
		{
			students.add(names[i]);
		}
	}
	public void display() 
	{
		System.out.println("Student List:");
		for (int i = 0; i<students.size(); i++)
		{
			System.out.println(students.get(i)+" ");
		}
		System.out.println();
	}
	public void removeStudent(int index)
	{
		try
		  {
		    students.remove(index);
		  }
		  catch (IndexOutOfBoundsException e)
		  {
		    System.out.println(
		      "Can't remove student because " + index +
		      " is an invalid index position.");
		  } //end catch
	} //end removeStudent
} //end StudentList Class
