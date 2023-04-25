package com.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArrayCompareTest {

	@Test
	public void testArraySort_RandomArray() {
		int [] numbers = {12,3,4,1};
		int [] expected = {1,4,3,12};
		                        
		Arrays.sort(numbers);// 1 3 4 12 	
		
	assertArrayEquals(expected,numbers);
	// arrays first differed at element [1];
	// expected: <4> but was: <3>
	
	}
	

	@Test(expected = NullPointerException.class)
	public void testArraySort_NullArray() {
		int [] numbers = null;

		Arrays.sort(numbers);// 1 3 4 12 	
		
	}
	
	@Test(timeout = 100)
	public void testSort_Performance()
	{
		int [] arr= {12,23,4};
		for(int i=0;i<=1000000;i++)
		{
			arr[0]=i;
			Arrays.sort(arr);
		}
	}

}
