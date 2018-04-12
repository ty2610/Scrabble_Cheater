import java.io.*;
import java.util.*;
import java.lang.*;
public class TokenCollection implements Serializable
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class stores the passed Tokens into a collection. It can access, copy, add, remove, contain(boolean), and size(int) the tokens within the collection.

	Variables:

		tokenCollection
			An instance variable that holds onto all the passed Token types.

	Constructors:

		public TokenCollection()
			Makes the tokenCollection into an arraylist that contains Tokens.

		public TokenCollection(File file, TokenProcessor tokenProcessor)
			Creates a new object that goes through and sends each line of a passed file to the record processor.


	Methods:

		public Token[] get()
			Accessor to the array list instance variable and returns an array.

		public Token get(int integer)
			Returns the element of the instance variable at the given integer.

		public Token[] get(TokenFilter filter)
			Filters all the elements in the instance variable and then returns the reminants in an array.

		public void add(Token token)
			Adds the given Token to the instance variable.

		public boolean remove(Token token)
			Removes the given Token to the instance variable.

		public boolean contains(Token token)
			Returns a boolean of if the instance variable contains the given token.

		public int size()
			Returns the amount of elements in the instance variable.

		public void saveCollection(PrintWriter out)
			Prints the instance variable contents into a given PrintWriter connected to a file.
*/
	private ArrayList<Token> tokenCollection;
	private static long serialVersionUID=1;

	//private ObjectOutputStream objectOutputStream;

	public TokenCollection()throws IOException
	{
		//Makes the tokenCollection into an arraylist that contains Tokens.
		this.tokenCollection = new ArrayList<Token>();
		//this.objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("TestThingy.txt")));
		//objectOutputStream.close();
	}//TokenCollection()

	/*public TokenCollection(File file, TokenProcessor tokenProcessor)
	{
		//Creates a new object that goes through and sends each line of a passed file to the record processor.
		if(file == null)
		{
			throw new IllegalArgumentException("the passed file is null");
		}//if
		this.tokenCollection = new ArrayList<Token>();
	    SequentialDataFile sequentialDataFile;
		try
		{
			tokenProcessor.setTokenCollection(this);
			sequentialDataFile = new SequentialDataFile(file,tokenProcessor);
			sequentialDataFile.processFile();
		}//try
		catch(IOException ioe)
		{
			throw new RuntimeException(ioe.getMessage());
		}//catch

	}//TokenCollection(File file, TokenProcessor tokenProcessor)*/

	public Token[] get()
	{
		//Accessor to the array list instance variable and returns an array.
		return this.tokenCollection.toArray(new Token[0]);
	}//get()

	public Token get(int integer)
	{
		//Returns the element of the instance variable at the given integer.
		return this.tokenCollection.get(integer);
	}//get(int integer)

	public Token[] get(TokenFilter filter)
	{
		//Filters all the elements in the instance variable and then returns the reminants in an array.
		ArrayList<Token> list;
		list = new ArrayList<Token>();
		Token hold;

		for(int i=0; i<this.size();i++)
		{
			hold = this.get(i);
			if(filter.applyFilter(hold))
			{
				list.add(hold);
			}//if
		}//for
		return (Token[])list.toArray(new Token[0]);
	}//get(TokenFilter filter)

	public void add(Token token)
	{
		//Adds the given Token to the instance variable.
		tokenCollection.add(token);
	}//add(Token token)

	public void add(File file, TokenProcessor tokenProcessor)
	{
		if(file == null)
		{
			throw new IllegalArgumentException("the passed file is null");
		}//if
		this.tokenCollection = new ArrayList<Token>();
	    SequentialDataFile sequentialDataFile;
		try
		{
			tokenProcessor.setTokenCollection(this);
			sequentialDataFile = new SequentialDataFile(file,tokenProcessor);
			sequentialDataFile.processFile();
		}//try
		catch(IOException ioe)
		{
			throw new RuntimeException(ioe.getMessage());
		}//catch

	}

	public boolean remove(Token token)
	{
		//Removes the given Token to the instance variable.
		return tokenCollection.remove(token);
	}//remove(Token token)

	public boolean contains(Token token)
	{
		//Returns a boolean of if the instance variable contains the given token.
		return tokenCollection.contains(token);
	}//contains(Token token)

	public int size()
	{
		//Returns the amount of elements in the instance variable.
		return tokenCollection.size();
	}//size()

	public void saveCollection(PrintWriter out)
	{
		//Prints the instance variable contents into a given PrintWriter connected to a file.
        for(int i=0; i<this.size(); i++)
        {
			out.println(this.get(i));
		}//for
		out.flush();
	}//saveCollection(PrintWriter out)

	public void saveCollection(ObjectOutputStream output)throws IOException
	{
		if(output==null)
		{
			throw new IllegalArgumentException("The pass output to method:saveCollection(ObjectOutputStream output) is null");
		}
		output.writeObject(this);
	}

}//class TokenCollection