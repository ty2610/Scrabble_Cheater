import java.io.*;
public class SequentialDataFile
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	9-29-2015

	This class errors checks and processes file.

	Variables:

		dataFile
			Stores the given file.

		recordProcessor
			Object of RecordProcessor

	Constructors:

		public SequentialDataFile(File dataFile, RecordProcessor recordProcessor)
			Error checks and makes actual parameters into instance variables.

	Methods:

		public File getDataFile()
			Accesses the dataFile instance variable.

		public RecordProcessor getRecordProcessor()
			Accesses the recordProcessor instance variable.

		public void processFile()
			Recieves file and reads each line and sends string to RecordProcessor.

*/

	private File dataFile;
	private RecordProcessor recordProcessor;

	public SequentialDataFile(File dataFile, RecordProcessor recordProcessor)
	{
		//Error checks and makes actual parameters into instance variables.
		if(dataFile == null)throw new IllegalArgumentException("The file passed to processSequentialDataFile is null.");
		if(!dataFile.exists())throw new IllegalArgumentException("The file passed to processSequentialDataFile does not exist.");
		if(!dataFile.isFile())throw new IllegalArgumentException("The file passed to processSequentialDataFile is, in fact, not a file.");
		this.dataFile = dataFile;
		this.recordProcessor = recordProcessor;
	}//SequentialDataFile(File dataFile, RecordProcessor recordProcessor)


	public File getDataFile()
	{
		//Accesses the dataFile instance variable.
		return this.dataFile;
	}//getDataFile()

	public RecordProcessor getRecordProcessor()
	{
		//Accesses the recordProcessor instance variable.
		return this.recordProcessor;
	}//getRecordProcessor()



	public void processFile()throws IOException
	{
		//Recieves file and reads each line and sends string to RecordProcessor.
		BufferedReader input;
		String         record;

		input = new BufferedReader(new FileReader(this.getDataFile()));
		record = input.readLine();
		while (record != null)
		{
			this.getRecordProcessor().processRecord(record);
			record = input.readLine();
		} //while
		input.close();
	}//processFile()

}//class SequentialDataFile