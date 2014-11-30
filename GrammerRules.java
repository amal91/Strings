//
//Check a given sentence for a given set of simple grammer rules
//
//A simple sentence if syntactically correct if it fulfills given rules. The following are given rules.
//
//1. Sentence must start with a Uppercase character (e.g. Noun/ I/ We/ He etc.)
//2. Then lowercase character follows.
//3. There must be spaces between words.
//4. Then the sentence must end with a full stop(.) after a word.
//5. Two continuous spaces are not allowed.
//6. Two continuous upper case characters are not allowed.
//7. However the sentence can end after an upper case character.
//
//Examples:
//
//Correct sentences -
//   "My name is Ram."
//   "The vertex is S."
//   "I am single."
//   "I love Geeksquiz and Geeksforgeeks."
//
//Incorrect sentence - 
//   "My name is KG."
//   "I lovE cinema."
//   "GeeksQuiz. is a quiz site."
//   "  You are my friend."
//   "I love cinema" 

package com.practise.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GrammerRules {
	
	public static void main(String [] ar) throws IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		Boolean check= checkSentence(str);
		if(check)
		{
			System.out.println("Correct ");
		}
		else
		{
			System.out.println("incorrect");
		}
	}

	private static Boolean checkSentence(String str) {
		// TODO Auto-generated method stub
		int len = str.length();
		System.out.println(str);
		// Maintain 2 states. Previous and current state based
	    // on which vertex state you are. Initialise both with
	    // 0 = start state.
		int prev_state = 0, curr_state = 0;
		 
	    //Keep the index to the next character in the string.
	    int index = 1;
	    
	    if(str.charAt(0)<'A'||str.charAt(0)>'Z')
	    	return false;
		
	    if(str.charAt(len-1)!='.')
	    	return false;
	    
	    while(index<len)
	    {
	    	System.out.println(str.charAt(index));
	    	if(str.charAt(index)>='A'&&str.charAt(index)<='Z')
	    		curr_state = 0;
	    	else if(str.charAt(index)==' ')
	    		curr_state=1;
	    	else if(str.charAt(index)>='a'&&str.charAt(index)<='z')
	    		curr_state=2;
	    	else if(str.charAt(index)=='.')
	    		curr_state=3;
	    	
	    	if(prev_state==curr_state&&curr_state!=2&&index!=1)
	    		return false;
	    	if(prev_state==2&& curr_state==0)
	    		return false;
	    	if(curr_state==1&&prev_state==3&&(str.charAt(index+1)<'A'||str.charAt(index+1)>'Z'))
	    		return false;
	    		    	
	    	if(curr_state==3&&prev_state!=1)
	    	{
	    		if(index==len-1)
	    			return true;
	    		
	    	}
	    		
	    	
	    	index++;
	    	prev_state=curr_state;
	    	
	    	
	    }
		return false;
	    
	}

}
