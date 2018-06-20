package huff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class decoder {
	
	public static void main(String[] args) throws FileNotFoundException, IOException

	{
		try( BufferedReader br = new BufferedReader( new FileReader("code_table.txt") ) )
	
	{
		String line;
		
		while((line = br.readLine()) != null)
		{
			String s[]= line.split(" ");
		}
	}
	}
}