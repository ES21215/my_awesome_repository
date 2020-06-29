import java.util.*;
public class DataStructureStrings 
{
	public static String vowels [] = {"a","o","i","e","u",};
	public static String starters [] = {"ch","gh", "ph", "qu", "sh", "th"};
	public static void main(String [] args)
	{
		Scanner input = new Scanner (System.in);
		String sentence = "";
		System.out.print("Transalate into Pig-Latin: ");
		sentence = input.nextLine();
		String [] words = sentence.split(" ");
		System.out.print("Transalation: ");
		for (String word:words)
		{
			String firstLetters = word.substring(0,2).toLowerCase();
			checkLetter(firstLetters, word);
		}
	}
	public static void checkLetter(String firstLetters,String word)
	{
		boolean startsVowel = false;
		boolean startsStarters = false;
		String letter = firstLetters.substring(0,1);
		for(String vowel:vowels)
		{
			if(letter.equals(vowel))
				startsVowel = true;
		}
		for(String starter:starters)
		{
			if(firstLetters.equals(starter))
				startsStarters = true;
		}
		if(startsVowel == true)
			startsWithVowel(word);
		else if(startsStarters == true)
			startsWithStarter(word);
		else
			noVowel(word);
	}	
	public static void startsWithVowel(String word)
	{
		System.out.print(word+"ay ");
	}
	public static void startsWithStarter(String word)
	{
		System.out.print(word.substring(2)+word.substring(0,2)+ "ay ");
	}
	public static void noVowel(String word)
	{
		System.out.print(word.substring(1)+word.substring(0,1)+ "ay ");
	}
}

