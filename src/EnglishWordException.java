public class EnglishWordException extends IllegalArgumentException
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class extends IllegalArgumentException to throw a custom EnglishWordException.

	Constructors:

		public EnglishWordException()
			Initializes EnglishWordException.

		public EnglishWordException(String message)
			Initializes EnglishWordException and passed a string.

*/


	public EnglishWordException()
	{
		//Initializes EnglishWordException.
		super();
	}//EnglishWordException()

	public EnglishWordException(String message)
	{
		//Initializes EnglishWordException and passed a string.
		super(message);
	}//EnglishWordException(String message)

}//class EnglishWordException