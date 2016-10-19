package hasan.com.rashid;


public class Cypher {
public String oneCypher(String name)  // this function just shift each char by one
	
	{
	
		char [] arrayName=name.toCharArray();
		for (int i=0;i<arrayName.length;i++)
		{
			
			int nextValue = (int)arrayName[i] + 1; // next char

			arrayName[i] = (char)nextValue; // convert that to back to a char
		}
		
	    	String cypherdName=new String(arrayName);
	    	return cypherdName;
	    
	   
	 }

public String onedeCypher(String name)  // this function just shift each char by one

{

	char [] arrayName=name.toCharArray();
	for (int i=0;i<arrayName.length;i++)
	{
		
		int nextValue = (int)arrayName[i] - 1; // prev char

		arrayName[i] = (char)nextValue; // convert that to back to a char
	}
	
    	String cypherdName=new String(arrayName);
    	return cypherdName;
    
   
 }

}
