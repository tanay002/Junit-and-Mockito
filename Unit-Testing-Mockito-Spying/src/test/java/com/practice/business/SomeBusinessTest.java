package com.practice.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.practice.Business.SomeBusinessImpl;

class SomeBusinessTest {

	@Test
	void calculateSum_basic() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		int actualResutt=someBusinessImpl.calculateSum(new int [] {1,2,3});
		int expectedResult=6;
		assertEquals(expectedResult, actualResutt);
	}
	
	@Test
	void calculateSum_CheckEmpty() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		int actualResutt=someBusinessImpl.calculateSum(new int [] {});
		int expectedResult=0;
		assertEquals(expectedResult, actualResutt);
	}
	
	@Test
	void calculateSum_CheckSingleValueSum() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		int actualResutt=someBusinessImpl.calculateSum(new int [] {5});
		int expectedResult=5;
		assertEquals(expectedResult, actualResutt);
	}

}
