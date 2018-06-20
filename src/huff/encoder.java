package huff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class encoder {
	
	static HashMap<Integer, String> hm = new HashMap<>();
	
	public static void codeTable(Node ptr)
	{
		StringBuilder s = new StringBuilder("");
		constructCodeTable(ptr, hm, s );
			
	}
	
	public static void constructCodeTable(Node ptr, HashMap<Integer,String> hm, StringBuilder s)
	{
		if (ptr == null)
			return;
		
		if(ptr.right == null && ptr.left == null)
		{
			hm.put(ptr.key, s.toString());
			return;
		}
		
		s.append("0");
		constructCodeTable(ptr.left, hm, s);
		s.deleteCharAt(s.length()-1);
		
		s.append("1");
		constructCodeTable(ptr.right, hm, s);
		s.deleteCharAt(s.length()-1);
		
		
	}
	
	public static void writeCodeTable() throws IOException
	{
		File file = new File ("code_table.txt");
	    PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter ("code_table.txt", true)));
	    
		Iterator it = hm.entrySet().iterator();
		
		while(it.hasNext())
		{
			Map.Entry m = (Map.Entry) it.next();
			pw.print(m.getKey()+ " ");
			pw.println(m.getValue());
			
		}
	    
		pw.close();
	}
	
	public static void writeEncodedFile() throws IOException{
		
		StringBuilder s = new StringBuilder("");
		
		try( BufferedReader br = new BufferedReader( new FileReader("sample_input_large.txt") ) )
        {
            String line;
            int value;
            while ( ( line = br.readLine() ) != null )
            {
            	try{
            		value = Integer.parseInt(line);
            		s.append( hm.get(value) );
            	}
            	catch( NumberFormatException e ){
            		continue;
            	}
            }
        }
		
		BitSet bs = new BitSet(s.length());
		FileOutputStream fos = new FileOutputStream("encoded.bin");
		
		for (int i=0; i<s.length(); i++)
		{
			char ch= s.charAt(i);
			if(ch== '1')
				bs.set(i);
		}
		
		byte b[] = bs.toByteArray();
		fos.write(b);
		
		fos.close();
	}
	
	public static void main(String[] args) throws IOException
	{
		Map<Integer,Integer> input = new LinkedHashMap<>();
        
		try( BufferedReader br = new BufferedReader( new FileReader("sample_input_large.txt") ) )
        {
            String s;
            int line;
            while ( ( s = br.readLine() ) != null )
            {
            	try{
            		line = Integer.parseInt(s);
            	}
            	catch( NumberFormatException e ){
            		continue;
            	}
                
            	if( input.containsKey(line) )
                    input.put( line, input.get(line) + 1 );
                else
                    input.put(line,1);   
            }
            
        } 
		huffmanTree ht = new huffmanTree();
		
		BuildQueue bq = new BuildQueue();
		
		Set entrySet = input.entrySet();
		Iterator it =  entrySet.iterator();
		while(it.hasNext())
		{
			Map.Entry en =  (Entry) it.next();
			int key = (int) en.getKey();
			int freq = (int) en.getValue();
			Node a = new Node(key, freq, null, null);
			bq.add(a);
		}
		
		ht.buildTree(bq);
		codeTable(ht.ptr);
				
		writeCodeTable();
		writeEncodedFile();
	}


}
