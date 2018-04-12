import java.io.*;
import java.util.*;
import java.lang.*;
public class UniqueTokenCollection extends TokenCollection
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class collects passed Token elements and only adds elements that arnt already found in the arraylist; it also extends TokenCollection.

	Constructors:

		public UniqueTokenCollection()
			This constructor creates the UniqueTokenCollection object.

		public UniqueTokenCollection(File file, TokenProcessor tokenProcessor)
			This constructor passes a passed file and tokenProcessor up the hierarchy.

	Methods:

		public void add(Token token)
			Adds given tokens to the tokencollection if it doesn't find it within the instance variable.


*/

	private HashSet inTokenCollection;

	public UniqueTokenCollection() throws IOException
	{
		//This constructor creates the UniqueTokenCollection object.
		super();
		this.inTokenCollection = new HashSet();
	}//UniqueTokenCollection()

	/*public UniqueTokenCollection(File file, TokenProcessor tokenProcessor)
	{
		//This constructor passes a passed file and tokenProcessor up the hierarchy.
		super(file,tokenProcessor);
	}//UniqueTokenCollection(File file, TokenProcessor tokenProcessor)*/

	public void add(Token token)
	{
		//Adds given tokens to the tokencollection if it doesn't find it within the instance variable.
		if(token == null)
		{
			throw new IllegalArgumentException("The passed Token is null");
		}//if

		/*if(!super.contains(token))
		{
			super.add(token);
		}//if*/

		if(!contains(token))
		{
			this.inTokenCollection.add(token);
			super.add(token);
		}//if


	}//add(Token token)

	public boolean remove(Token token)
	{
		boolean result;
		result = true;
		if(contains(token))
		{
			result = this.inTokenCollection.remove(token);
			super.remove(token);
		}

		return result;

	}

	public boolean contains(Token token)
	{
		return this.inTokenCollection.contains(token);
	}

}//class UniqueTokenCollection