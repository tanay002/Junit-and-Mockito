package com.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperParametrizedTest 
{
	public StringHelper helper=new StringHelper();

	private String input;
	private String output;
	
	
	
	public StringHelperParametrizedTest(String input, String output) {
		super();
		this.input = input;
		this.output = output;
	}
    
	@Parameters
	public static Collection<String[]> testConditions()
	{
		String expectedOutput[][]= {
				{"AACD","CD"},
				{"ACD","CD"}
		};
      return Arrays.asList(expectedOutput);
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {

		//AACD => CD ACD => CD  CDEF=> CDEF  CDAA => CDAA	
		assertEquals(output,helper.truncateAInFirst2Positions(input));      
	}
}
