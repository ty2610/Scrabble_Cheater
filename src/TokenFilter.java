import java.io.*;
import java.util.*;
import java.lang.*;
public interface TokenFilter
{
/*
	Tyler A. Green
	CISC 230
	Patrick L. Jarvis
	11-12-2015

	This interface applies a given filter.

	Methods:

		public boolean applyFilter(Token token)
			Applies the given filter to the given token.
*/
	public boolean applyFilter(Token token);

}//interface TokenFilter