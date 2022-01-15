package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before           
    public void setUp() {
        mycustomstring =  new MyCustomString();
    }

    @After            
    public void tearDown() {
        mycustomstring = null;
    }
    
    @Test     
    public void testCountNumbers1() {             
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }
    
   @Test       //counts digits when they are in separate positions 
    public void testCountNumbers2() {
	   mycustomstring.setString("My numbers are 12 and 55");
	   assertEquals(2, mycustomstring.countNumbers());
    }
   
    @Test      //counts digits when they are in between strings
    public void testCountNumbers3() {    	
    	mycustomstring.setString("Hi there is 365 days in a year");
 	   assertEquals(1, mycustomstring.countNumbers());
    }
    
    
    @Test      //countNumbers counts digits=0 when string is empty
    public void testCountNumbers4() {
    	mycustomstring.setString("");
    	assertEquals(0, mycustomstring.countNumbers() );
    	
    }

    @Test      //counts digits when the number are at the beginning
    public void testCountNumbers5() {
    	mycustomstring.setString("455 900 hey there my age is");
  	   assertEquals(2, mycustomstring.countNumbers());
     
    }

    @Test     //counts digits when string is at the end
    public void testCountNumbers6() {
    	mycustomstring.setString("hey there is age is 698");
   	   assertEquals(1, mycustomstring.countNumbers());
       
    }
    
    @Test     //Returns a string  of the characters in positions n, 2n, 3n from beginning n=3
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }
    
    @Test  //Returns a string  of the characters in positions n, 2n, 3n..from End
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?"); 
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }
    
    @Test  //returns empty string when string is empty
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
        
    }

    @Test //returns emptyString when length is less then n
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("hi");  
        assertEquals("", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }
    
    
    @Test (expected=IllegalArgumentException.class)   //throws IllegalArgumentException If "n" less than or equal to zero startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString("hi");  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, false);
    }

    @Test  (expected=NullPointerException.class)   //throws NullPointerException when string is null and n is greater then 0 startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString(null);  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false);
       
    }

    @Test  (expected=NullPointerException.class)   //throws NullPointerException when string is null and n is greater then 0, startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString(null);  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true);  //n is greater then 0 :D
    	
    }

    @Test (expected=IllegalArgumentException.class)  //// throws IllegalArgumentException If "n" less than or equal to zero startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("hi");
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(0, true);
    	
    }

    @Test   //returns a string of characters of position n=1 and startFromEnd=false
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("My name is Nick");  
   	 assertEquals("My name is Nick", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test  //returns a string of characters of position n=1 and startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("My name is Nick");  
      	 assertEquals("My name is Nick", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test //returns a string of characters of position n=5 and startFromEnd=false 
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("My name is Nick");  
      	 assertEquals("ask", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(5, false));
    }

    @Test  //This test checks whether method GetEveryNthCharacterFromBegining returns a string of characters of position n=4 and startFromEnd=false 
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString("My name is Nick, I am from India!");  
   	 assertEquals("n N,arIa", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
   
    }

    @Test //returns a string of characters of position n=4 and startFromEnd=true
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString("My name is Nick");  
      	 assertEquals("n N", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
        
    }

    @Test (expected=IllegalArgumentException.class) //throws IllegalArgumentException If "n" less then zero
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("Finally done with tests");  
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-2, false);
    	
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {  //returns right convert digit to name in string when startIndex and endIndex are between 
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }
    
    //exceptions //throws NullPointerException when startPosition <= endPosition, startPosition and  endPosition are greater than 0, current string is null
    @Test (expected=NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring2() {
    	mycustomstring.setString(null);
    	mycustomstring.convertDigitsToNamesInSubstring(3, 4);
    }

    @Test(expected=MyIndexOutOfBoundsException.class) //throws MyIndexOutOfBounds exception when startPosition <= endPosition, but either startPosition or endPosition are out of bounds.
    public void testConvertDigitsToNamesInSubstring3() {
      mycustomstring.setString("This is a testCase");
      mycustomstring.convertDigitsToNamesInSubstring(0, 3);  //outofBounds
    }

    @Test (expected=MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring4() {  //throws MyIndexOutOfBounds end position outOfBounds 
    	mycustomstring.setString("This is a testCase");
        mycustomstring.convertDigitsToNamesInSubstring(2, mycustomstring.getString().length()+1);  //outofBounds
    }

    @Test(expected=IllegalArgumentException.class) //throws IllegalArgumentException when startPosition > endPosition
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString("This is a testCase");
    	mycustomstring.convertDigitsToNamesInSubstring(4, 3);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() { //returns right output when startPosition is the first element and endPosition is the last element(begining to end)
    	mycustomstring.setString("I was 25 years old last year and today 23");
        mycustomstring.convertDigitsToNamesInSubstring(1,41 );
        assertEquals("I was TwoFive years old last year and today TwoThree", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {  //returns right output when startPosition and endPosition is the same element
    	mycustomstring.setString("I was 25 years old last year and today 23");
        mycustomstring.convertDigitsToNamesInSubstring(7,7 );
        assertEquals("I was Two5 years old last year and today 23", mycustomstring.getString());
    	
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() { //returns right output when startPosition and endPosition are inBetween
    	mycustomstring.setString("I was 25 years old last year and today 23");
        mycustomstring.convertDigitsToNamesInSubstring(8,40 );
        assertEquals("I was 2Five years old last year and today Two3", mycustomstring.getString());
    }
    


}