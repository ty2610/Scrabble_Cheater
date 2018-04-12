import java.io.*;
import java.util.*;
import java.lang.*;
public class CheatAtScrabbleFilter implements TokenFilter
{
	private String letters;

	public CheatAtScrabbleFilter(String letters)
	{
		this.letters = letters;
	}

	public boolean applyFilter(Token token)
	{
		String other;
		int count;
		String hold;
		String temp;
		int loc;

		other = token.getToken();
		temp = other;
		hold = this.letters;

		for(int i=0; i < hold.length() && temp.length()>0; i++)
		{
			loc = temp.indexOf(hold.charAt(i));
			if(loc >= 0)
			{
				temp = temp.substring(0,loc) + temp.substring(loc+1,temp.length());
			}
		}
		return(temp.length()<1);
	}

}