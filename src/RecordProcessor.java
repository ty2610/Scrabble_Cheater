import java.io.*;
import java.util.*;
import java.lang.*;
abstract public class RecordProcessor
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This is an abstract that passes on the processRecord method to its subclasses.

	Constructors:

		public RecordProcessor()
			Initializes RecordProcessor.

	Methods:

		abstract public void processRecord(String record)
			An abstract that processes the passed record.

*/
	public RecordProcessor(){}

	abstract public void processRecord(String record);

}//class RecordProcessor