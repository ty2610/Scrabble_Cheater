import java.io.*;
import java.util.*;
import java.lang.*;
public class TokenProcessor extends RecordProcessor
{
	/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class extends RecordProcessor and try to convert the given string into a token.

	Variables:

		tokenCollection
			An instance variable that touches the TokenCollection class.

	Constructors:

		public TokenProcessor()
			Creates the TokenProcessor object and sets the instance variable to null.

	Methods:

		public void processRecord(String record)
			Trys to change the given string into a token(from sequential).

		public void setTokenCollection(TokenCollection tokenCollection)
			Initializes the instance variable.

		public Token tokanize(String record)
			Converts the given string into a token.
	*/
	private TokenCollection tokenCollection;

	public TokenProcessor()
	{
		//Creates the TokenProcessor object and sets the instance variable to null.
		super();
		this.tokenCollection = null;
	}//TokenProcessor()

	public void processRecord(String record)
	{
		//Trys to change the given string into a token(from sequential).
		try
		{
			if(this.tokenCollection == null)
			{
				throw new IllegalStateException("The passed TokenCollection is null, you need to set token collection before you .add");
			}//if
			tokanize(record);
			this.tokenCollection.add(this.tokanize(record));
		}//try
		catch(IllegalStateException ise)
		{
			Logger.getInstance().write("this is an issue: " + record);
		}//catch

	}//processRecord(String record)

	public void setTokenCollection(TokenCollection tokenCollection)
	{
		//Initializes the instance variable.
		this.tokenCollection = tokenCollection;
	}//setTokenCollection(TokenCollection tokenCollection)

	public Token tokanize(String record)
	{
		//Converts the given string into a token.
		Token token;
		token = new Token(record);
		return token;
	}//tokanize(String record)

}//class TokenProcessor