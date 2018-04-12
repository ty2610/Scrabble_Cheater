import java.io.*;
import java.util.*;
public class EnglishWord extends Token
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class takes in a string and tries converts it to an EnglishWord. It can count the number of certain characters and symbols, count the number of passed multiple characters, and say if(boolean the EnglishWord is a palindrome.

	Variables:

		vowels
			Holds all the vowels in the English Alphabet.

		consonants
			Holds all the consonants in the English Alphabet.

		apostrophe
			Holds an apostrophe.

		hyphen
			Holds a hyphen.

		ALPHABET
			Holds every letter of the English alphabet.

	Constructors:

		public EnglishWord(String word)
			Takes in a string and trims it and tries to convert it to an EnglishWord.

	Methods:

		private int countThese(String string)
			Counts the amount of the given characters within the passed EnglishWord.

		private int numberOf(char character)
			Counts the number of occurances of a character in a passed EnglishWord.

		public int numberOfApostrophes()
			Counts the number of occurances an apostrophe has in a passed EnglishWord.

		public int numberOfHyphens()
			Counts the number of occurances a hyphen has in a passed EnglishWord.

		public int numberOfConsonants()
			Counts the number of occurances consonants have in a passed EnglishWord.

		public int numberOfVowels()
			Counts the number of occurances vowels have in a passed EnglishWord.

		public boolean isPalindrome()
			Returns(boolean) if the passed EnglishWord is a palindrome, it can be read the same forwards and backwards.



*/
	public static final String vowels = "aeiouyAEIOUY";
	public static final String consonants = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
	public static final String apostrophe = "'";
	public static final String hyphen = "-";
	private static final String ALPHABET = vowels + consonants;
	private long letterSet;
	private static String validCharacters = "-'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static long allTheVowels = new EnglishWord("aeiouyAEIOUY").letterSet;
	public EnglishWord(String word)
	{
		//Takes in a string and trims it and tries to convert it to an EnglishWord.

		super(word,true);
		word = super.getToken();
		int loc;
		String holdAlphabet;
		holdAlphabet = ALPHABET + hyphen + apostrophe;
		if(word.length() != word.trim().length())
		{
			throw new EnglishWordException("The passed String has whitespace.");
		}//if
		if(word.length()<1)
		{
			throw new EnglishWordException("The passed string is not longer than one character.");
		}//if
		for(int i=0; i<word.length();i++)
		{
			if(holdAlphabet.indexOf(word.charAt(i)) == -1)
			{
				throw new EnglishWordException("This letter/symbol is not a part of the English language: " + word.charAt(i));
			}//if
		}//for
		if(word.charAt(0) == '-')
		{
			throw new EnglishWordException("The passed word starts with a hyphen");
		}//if
		if(word.charAt(0) == '\'')
		{
			throw new EnglishWordException("The passed word starts with an apostrophe");
		}//if
		if(word.charAt(word.length()-1) == '-')
		{
			throw new EnglishWordException("The passed word ends with a hyphen");
		}//if
		this.letterSet = 0;
		for(int i=0; i<word.length(); i++)
		{
			loc = EnglishWord.validCharacters.indexOf(word.charAt(i));
			if(loc<0)
			{
				throw new EnglishWordException("The pass word has an invalid character");
			}

			this.letterSet = this.letterSet | ((long)1<<loc);

		}

	}//EnglishWord(String word)

	public boolean sameCharacterSetAs(EnglishWord word)
	{
		if(word == null)
		{
			throw new IllegalArgumentException("The passed EnglishWord to method:sameCharacterSetAs(EnglishWord word) is null");
		}
		return(this.letterSet == word.letterSet);
	}

	public boolean sameCharacterSetAs(Token token)
	{
		if(token == null)
		{
			throw new IllegalArgumentException("The passed token to method:sameCharacterSetAs(Token token) is null");
		}
		try
		{
			return sameCharacterSetAs((EnglishWord)token);
		}
		catch(ClassCastException cce)
		{
			return super.sameCharacterSetAs(token);
		}
	}

	public boolean sameLetterSetAs(EnglishWord other)
	{
		if(other==null)
		{
			throw new IllegalArgumentException("The passed EnglishWord to method:sameLetterSetAs(EnlgishWord other) is null");
		}
		return(sameLetterSetAs(other,true));
	}

	public boolean sameLetterSetAs(EnglishWord other, boolean ignoreCase)
	{
		long thisLetterSet;
		//long thisUpperCaseLetterSet;
		//long thisLowerCaseLetterSet;
		long otherLetterSet;
		//long otherUpperCaseLetterSet;
		//long otherLowerCaseLetterSet;
		boolean result;
		result = true;

		//thisLetterSet = this.letterSet;
		//otherLetterSet = other.letterSet;


		thisLetterSet = (this.letterSet>>>2);//(this.letterSet>>>2);//(this.letterSet<<2);//this.letterSet;//2<<this.letterSet;
		otherLetterSet = (other.letterSet>>>2);//(other.letterSet>>>2);//(other.letterSet<<2);//other.letterSet;//2<<other.letterSet;

		/*System.out.println(thisLetterSet);
		System.out.println(otherLetterSet);

		System.out.println(((thisLetterSet<<38)>>>38)<<26);
		System.out.println(((otherLetterSet<<38)>>>38)<<26);
		System.out.println((thisLetterSet>>>26));
		System.out.println((otherLetterSet>>>26));*/

		if(ignoreCase)
		{
			thisLetterSet = (((thisLetterSet<<38)>>>12) | (thisLetterSet>>>26) | (thisLetterSet));//moving it over 38 to get rid of upper, then back 38 to bring it back, then up 26 to put lower were upper was.
			otherLetterSet = (((otherLetterSet<<38)>>>12) | (otherLetterSet>>>26) | (otherLetterSet));
		}
			/*result = (thisLetterSet == otherLetterSet);
		if(!ignoreCase)
		{
			result = ;
		}*/

		return (thisLetterSet == otherLetterSet);
	}

	public String getAsString(long bitMap)
	{
		String result;
		int x;
		result = "";

		for(int i=0; i<64;i++)
		{
			if(i%8==8)
			{
				result = " " + result;
			}
			x = (int)bitMap%2;
			bitMap = bitMap/2;
			result = x+result;
		}
		return result;
	}

	public boolean containsAllTheVowels()
	{
		long thisLetterSet;
		long bothAdded;
		long vowels;

		vowels = allTheVowels>>>2;
		thisLetterSet = this.letterSet>>>2;
		bothAdded = (thisLetterSet & vowels);
		System.out.println(getAsString(bothAdded));
		bothAdded = (((bothAdded<<38)>>>12) | (bothAdded>>>26) | (bothAdded));
		System.out.println(getAsString(bothAdded));
		return (bothAdded == vowels);
	}

	public boolean containsOnlyVowels()
	{

		long thisLetterSet;
		long bothAdded;
		long vowels;

		vowels = allTheVowels;
		thisLetterSet = this.letterSet;
		//System.out.println(Long.bitCount(thisLetterSet));
		bothAdded = (thisLetterSet | vowels);
		return (Long.bitCount(bothAdded) == 12);
	}

	public long amountOfUniqueVowels()
	{
		long thisLetterSet;
		long bothAdded;
		long vowels;

		vowels = allTheVowels>>>2;
		thisLetterSet = this.letterSet>>>2;
		thisLetterSet = (thisLetterSet | ((thisLetterSet<<38)>>12) | (thisLetterSet>>>26));
		bothAdded = (thisLetterSet & vowels);
		bothAdded = (bothAdded>>>26);

		return(Long.bitCount(bothAdded));
	}

	/*public containsAnyOf(String string);
	{

	}*/

	private int countThese(String string)
	{
		//Counts the amount of the given characters within the passed EnglishWord.
		int counter;
		counter = 0;
		for(int i=0; i < string.length(); i++)
		{
			counter = counter + this.numberOf(string.charAt(i));
		}
		return counter;
	}//countThese(String string)

	private int numberOf(char character)
	{
		//Counts the number of occurances of a character in a passed EnglishWord.
		String givenString;
		int count;
		givenString = super.getToken();
		count = 0;

		for(int i=0; i < givenString.length();i++)
		{
			if(givenString.charAt(i) == character)
			{

				count = count + 1;
			}//if
		}//for
		return count;
	}//numberOf(char character)

	public int numberOfApostrophes()
	{
		//Counts the number of occurances an apostrophe has in a passed EnglishWord.
		return numberOf('\'');
	}//numberOfApostrophe()

	public int numberOfHyphens()
	{
		//Counts the number of occurances a hyphen has in a passed EnglishWord.
		return numberOf('-');
	}//numberOfHyphens()

	public int numberOfConsonants()
	{
		//Counts the number of occurances consonants have in a passed EnglishWord.
		return countThese(consonants);
	}//numberOfConsonants()

	public int numberOfVowels()
	{
		//Counts the number of occurances vowels have in a passed EnglishWord.
		return countThese(vowels);
	}//numberOfVowels()

	public boolean isPalindrome()
		{
			//Returns(boolean) if the passed EnglishWord is a palindrome, it can be read the same forwards and backwards.
			String  constructedString;
			String  passedToken;
			boolean result;

			passedToken = this.getToken().toLowerCase();
			result = true;
			constructedString = "";
			for(int i=0; i < passedToken.length();i++)
			{
				if(passedToken.charAt(i) != '-' && passedToken.charAt(i) != '\'')
				{
					constructedString = constructedString + passedToken.charAt(i);
				}//if
			}//for
			for(int i=0; i < constructedString.length() && result; i++)
			{
				result = (constructedString.charAt(i) == constructedString.charAt((constructedString.length()-1)-i));
			}//for
			return result;

	}//isPalindrome()

}//class EnglishWord