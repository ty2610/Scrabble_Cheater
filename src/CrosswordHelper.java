import java.io.*;
import java.util.*;
import java.lang.*;
public class CrosswordHelper implements TokenFilter
{
	private String answer;

	public CrosswordHelper(String answer)
	{
		this.answer = answer.toLowerCase();
	}

	public boolean applyFilter(Token token)
	{
		String other;
		boolean result;
		char ch;
		other = token.getToken().toLowerCase();
		result = (other.length() == this.answer.length());
		for(int i=0; i<answer.length() && result; i++)
		{
			ch = this.answer.charAt(i);
			result = (ch == ' ' || ch == other.charAt(i));
		}
		return result;
	}

}