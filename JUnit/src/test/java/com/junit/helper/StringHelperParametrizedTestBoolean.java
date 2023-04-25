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
public class StringHelperParametrizedTestBoolean
{
	public StringHelper helper=new StringHelper();

	private String input;
	private Boolean output;
	
	
	
	public StringHelperParametrizedTestBoolean(String input, Boolean output) {
		super();
		this.input = input;
		this.output = output;
	}
    
	@Parameters
	public static Collection<String[]> testConditions()
	{
		String expectedOutput[][]= {
				{"AACD","true"},
				{"ACD","true"}
		};
      return Arrays.asList(expectedOutput);
	}
	
	@Test
	public void testTruncateAInFirst2Positions_AinFirst2Positions() {

		//AACD => CD ACD => CD  CDEF=> CDEF  CDAA => CDAA	
		assertTrue(Boolean.getBoolean(helper.truncateAInFirst2Positions(input)));      
	}
}
