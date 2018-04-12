import java.io.*;
import java.util.*;
import java.lang.*;
public class TokenLengthFilter implements TokenFilter
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class implements TokenFilter and passes the filter to said interface.

	Variables:

		tokenLength
			Holds the desired length for the token filter.

	Constructors:

		public TokenLengthFilter(int tokenLength)
			Initializes tokenLength to the passed desired length.

	Methods:

		public boolean applyFilter(Token token)
			Returns(boolean) if the Token passes the given filter test.

*/
	private int tokenLength;

	public TokenLengthFilter(int tokenLength)
	{
		//Initializes tokenLength to the passed desired length.
		this.tokenLength = tokenLength;
	}//TokenLengthFilter(int tokenLength)

	public boolean applyFilter(Token token)
	{
		//Returns(boolean) if the Token passes the given filter test.
		return(token.length() == this.tokenLength);
	}//applyFilter(Token token)

}//class TokenLengthFilter