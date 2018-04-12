import com.google.gson.Gson;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.lang.*;

import static com.apple.eio.FileManager.getResource;

public class Driver
{
	/*
		Tyler A. Green
		CISC 230
		Patrick L. Jarvis
		11-12-2015

		This class takes in string and can convert it into Token or EnglishWord. It then can store and process and store passed tokens and englishwords.

	*/

	private static void print(Object[] array)
	{
		//goes through the given array and prints it.
		System.out.println("Array contains " + array.length + " elements");
		for(int i=0; i<array.length;i++)
		{
			System.out.println("[" + i + "]" + array[i].toString());
		}//for

	}//print(Object[] array)

	/*private void print(ArrayList<Object>[] arrayList)
	{
		print(arrayList.toArray(new Object[0]));
	}*/

	//public static void main(String[] args)throws IOException,ClassNotFoundException
	public String runner(String characters) throws IOException,ClassNotFoundException
	{
		//This main takes a passed dictionary of words and makes them into EnglishWords. It then passes the EnglishWords through a filter and prints the remaining.
		File 			file;
		TokenFilter     m;
		TokenCollection tokenCollection;
		TokenProcessor tokenProcessor;

		m = new CheatAtScrabbleFilter(characters);
		URL url=this.getClass().getResource("/DictionaryWords.txt");
		file=new File(url.getPath());
		tokenProcessor = new EnglishWordProcessor();
		tokenCollection = new TokenCollection();
		tokenCollection.add(file, tokenProcessor);
		String temp = new Gson().toJson(tokenCollection.get(m));
		return new Gson().toJson(temp);
	}//main

}//Driver