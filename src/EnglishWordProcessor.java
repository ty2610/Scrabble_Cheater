public class EnglishWordProcessor extends TokenProcessor
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This class extends TokenProcessor; it trys to convert the passed string into an EnglishWord.

	Constructors:

		public EnglishWordProcessor()
			Initializes EnglishWordProcessor.

	Methods:

		public Token tokanize(String record)
			Trys to convert the passed string into an EnglishWord.

*/
	public EnglishWordProcessor()
	{
		//Initializes EnglishWordProcessor.
		super();
	}//EnglishWordProcessor()

	public Token tokanize(String record)
	{
		//Trys to convert the passed string into an EnglishWord.
		return new EnglishWord(record);
	}//tokanize(String record)

}//class EnglishWordProcessor