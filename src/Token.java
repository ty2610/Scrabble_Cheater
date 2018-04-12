import java.io.*;
import java.util.*;
import java.lang.*;
public class Token implements Serializable
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class takes in a String and converts it into a Token object, it can then check if said token is a palindrome, has certain characters, and reverse the string.

	Variables:

		token
			Is the created token from the passed string.

	Constructors:

		public Token(String token, boolean removeLeadingAndTrailingWhiteSpace)
			Initializes the token to the passed string that is trimmed and says if(boolean) the leading and trailing white space is removed.

		public Token(String token)
			Passes on the given string and false to the first constructor.

	Methods:

		public String getToken()
			Returns the token instance variable.

		public String toString()
			Returns the token instance variable in string form for testing.

		public int length()
			Returns the length of the token instance variable.

		public String getCharacterSet()
			Returns a string of all the unique letters within a token.

		public boolean sameCharacterSetAs(Token token)
			Returns if(boolean) the passed tokens have the same character sets.

		public boolean equals(Object object)
			Overrides the built in equal method to compare tokens.

		public int hashCode()
			Overrides the build in hashCode method because we override equal.

		public Token reverse()
			Returns the Token in a reverse order.

		public boolean isPalindrome()
			Returns(boolean) if the passed token in a palindrome, reads the same forwards and backwards.

*/
	private String token;
	private static long serialVersionUID=1;

	public Token(String token, boolean removeLeadingAndTrailingWhiteSpace)
	{
		//Initializes the token to the passed string that is trimmed and says if(boolean) the leading and trailing white space is removed.
		if(token == null)
		{
			throw new IllegalArgumentException("The passed token to the constructor is null");
		}//if
		this.token = token.trim();
	}//Token(String token, boolean removeLeadingAndTrailingWhiteSpace)

	public Token(String token)
	{
		//Passes on the given string and false to the first constructor.
		this(token, false);
	}//Token(String token)

	public String getToken()
	{
		//Returns the token instance variable.
		return this.token;
	}//getToken()

	public String toString()
	{
		//Returns the token instance variable in string form for testing.
		return this.getToken();
	}//toString()

	public int length()
	{
		//Returns the length of the token instance variable.
		return getToken().length();
	}//length()

	public String getCharacterSet()
	{
		//Returns a string of all the unique letters within a token.
		String heldLetters;
		String token;
		token = this.getToken();
		heldLetters = "";
		for(int i=0; i < token.length() ; i++)
		{
			if(heldLetters.indexOf(token.charAt(i)) < 0)
			{
				heldLetters = heldLetters + token.charAt(i);
			}//if
		}//for
		return heldLetters;
	}//getCharacterSet()

	public boolean sameCharacterSetAs(Token token)
	{
		//Returns if(boolean) the passed tokens have the same character sets.
		boolean result;
		String 	stringCharacterSet;
		String 	tokenCharacterSet;

		stringCharacterSet = this.getCharacterSet();
		tokenCharacterSet = token.getCharacterSet();
		result = true;

		result = (stringCharacterSet.length() == tokenCharacterSet.length());
		for(int i=0; i < tokenCharacterSet.length() && result; i++)
		{
			result = (stringCharacterSet.indexOf(tokenCharacterSet.charAt(i)) > -1);
		}//for
		return result;
	}//sameCharacterSetAs(Token token)

	public boolean equals(Object object)
	{
		//Overrides the built in equal method to compare tokens.
		boolean result;
		result = (object != null) && ((this == object) || (this.getToken().equals(((Token)object).getToken())));
		return result;
	}//equals(Object object)

	public int hashCode()
	{
		//Overrides the build in hashCode method because we override equal.
		return this.getToken().hashCode();
	}//hashCode()

	public Token reverse()
	{
		//Returns the Token in a reverse order.
		String backwards;
		String givenToken;
		backwards = "";

		givenToken = this.getToken();
		for(int i=0; i<givenToken.length(); i++)
		{
			backwards = backwards + givenToken.charAt((givenToken.length()-1)-i);
		}//for
		return new Token(backwards);
	}//reverse()

	public boolean isPalindrome()
	{
		//Returns(boolean) if the passed token in a palindrome, reads the same forwards and backwards.
		String  constructedString;
		String  passedToken;
		boolean result;

		passedToken = this.getToken();
		result = true;
		for(int i=0; i < passedToken.length() && result; i++)
		{
			result = (passedToken.charAt(i) == passedToken.charAt((passedToken.length()-1)-i));
		}//for
		return result;
	}//isPalindrome()

}//class Token