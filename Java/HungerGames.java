package Homework4;
//Etti Sherman
//Dean & Dean
//Hunger Games Class

import java.util.ArrayList;
import java.util.*;
public class HungerGames
{
	public static void main(String[] args)
	{
		ArrayList<Tribute> tributes = new ArrayList<>();
		Map<String, Tribute> tributeMap = new HashMap<>();
		
		tributes.add(new Tribute("Cato", 'm',2));
		tributes.add(new Tribute("Katniss", 'f',12));
		tributes.add(new Tribute("Peeta", 'm',12));
		tributes.add(new Tribute("Rue", 'f',11));
		tributes.add(new Tribute("Finnick", 'm',4));
		
		for(Tribute tribute: tributes)
		{
			tributeMap.put(tribute.getName(), tribute);
		}
		Collections.shuffle(tributes);
		for(int i = 0; i<tributes.size()-1; i++)
		{
			Tribute tribute = tributes.get(i);
			tributeMap.remove(tribute.getName());
			displayAttributes(tribute);
		}
		System.out.println(tributeMap.keySet());
	}
	
	public static void displayAttributes(Tribute tribute)
	{
		System.out.println("Name: " + tribute.getName());
		System.out.println("Gender: " + tribute.getGender());
		System.out.println("District: " + tribute.getDistrict() + "\n");
	}
	
}
