package com.junit.helper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {

	StringHelper helper;
	
	@Before
	public void initializeObject() 
	{
		helper=new StringHelper();
	}
	
	@Test
	public void testGeneral()
	{
		//fail("Not yet implemented");
		// when we write junit test then we have expected
		//value as well as actual value
		
	//	expected <ABC[]> but was: <ABC[]> 
	//	assertEquals("ABC", "ABCD");
		         //expected  actual
		
	}
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {
	
		//AACD => CD ACD => CD  CDEF=> CDEF  CDAA => CDAA	
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));      
	}
	
	@Test
	public void testTruncateAInFirst2Positions2_AinFirstPosition() {
	
		//AACD => CD ACD => CD  CDEF=> CDEF  CDAA => CDAA
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	      
	      
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
	
		//ABCD => false , ABAB => true, AB => true, A=> false
	//	boolean actualvalue=helper.areFirstAndLastTwoCharactersTheSame("ABCD");
	   //   assertEquals(false,actualvalue);	      
		
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	 //   assertFalse("The condition Failed", true);
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
	     
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABCAB"));
     //    assertTrue(true);
	//	assertTrue("Scenario Failed ",helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}

	@After
	public void deInitializeObject() 
	{
		helper=null;
	}
}
