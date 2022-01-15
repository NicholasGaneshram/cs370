package edu.qc.seclass;


public class MyCustomString implements MyCustomStringInterface {
	
	 String input=null; 
	
	
	 public String getString() {            
		 
		 return this.input;              
	 }
	 
	 
	 public void setString(String string) {
		 this.input=string;            
	 }
	 
	public int countNumbers() {
		
		if(this.input.isEmpty()) {  
			return 0;
		}
		
		if(this.input==null) {       
			throw new NullPointerException("NullPointerException: the current string is null");
		}
		
		int countDigit=0;
		for(int i=0;i<this.input.length();i++) {
			
			char temp=this.input.charAt(i);
			
			if(!Character.isDigit(temp)) {        
				continue;
			} else if(i==this.input.length()-1) {   
				countDigit++;
			}else if(Character.isDigit(this.input.charAt(i+1))) {
				continue;                           
			}else {    
				countDigit++;
			}
			
		} 
		
		return countDigit;
		
	} 

	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		
		String result="";
		
		if(this.input.isEmpty()||this.input.length()<n) {  
			return "";    
		}
		
		if(n<=0) {
			throw new IllegalArgumentException("n is either less then zero or is 0 ");
			
		}
		
		if(n>0 && this.input==null) {
			throw new NullPointerException("NullPointerException: the current string is null and is greater than zero");
		}
		
		String tempStr=""; 
		
		if(startFromEnd==false) {  
			tempStr=this.input;
		}else { 
			tempStr=new StringBuilder(this.input).reverse().toString();
		}
			
		int start=1;
		while((n*start)<=tempStr.length()) {
		int index=(n*start)-1;     
		result=result+String.valueOf(tempStr.charAt(index));	
		start++;    
		} 
		
		if(startFromEnd==true) {  
		result=new StringBuilder(result).reverse().toString();
		}
		
		return result;
	}

	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		
		if(startPosition > endPosition) {
			throw new IllegalArgumentException("Illegal Argument: startPosition > endPosition");
		}
		
		if((startPosition <=endPosition)&& (startPosition<1|| endPosition<1 || startPosition>this.input.length()||endPosition>this.input.length())) {
			throw new MyIndexOutOfBoundsException("Index out of bounds");
		}
		
		if(startPosition<=endPosition && (startPosition>0 && endPosition>0)&& this.input==null) {
			throw new NullPointerException("NullPointerException as the string is empty");
		}
		
		
		String temp="";
		String lhs="";   
		String rhs="";   
		
		int startIndex=startPosition-1;
		int endIndex=endPosition;
		temp=input.substring(startIndex, endIndex);  //temp holds a substring of the input
		
		lhs=input.substring(0, startIndex);
		rhs=input.substring(endIndex);
		
		
		temp=temp.replaceAll("0", "Zero");
		temp=temp.replaceAll("1", "One");
		temp=temp.replaceAll("2", "Two");
		temp=temp.replaceAll("3", "Three");
		temp=temp.replaceAll("4", "Four");
		temp=temp.replaceAll("5", "Five");
		temp=temp.replaceAll("6", "Six");
		temp=temp.replaceAll("7", "Seven");
		temp=temp.replaceAll("8", "Eight");
		temp=temp.replaceAll("9", "Nine");
		
		setString(lhs+temp+rhs);  
		
	}

}