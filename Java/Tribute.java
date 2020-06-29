package Homework4;
//Etti Sherman
//Tribute Class

public class Tribute
{
	private String name;
	private char gender;
	private int district;
	
	public Tribute(String name, char gender, int district)
	{
		this.name = name;
		this.gender = gender;
		this.district = district;
	}
	public String getName()
	{
		return name;
	}
	public char getGender()
	{
		return gender;
	}
	public int getDistrict()
	{
		return district;
	}
}
