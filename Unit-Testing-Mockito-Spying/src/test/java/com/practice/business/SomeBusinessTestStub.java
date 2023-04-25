 package com.practice.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.practice.Business.SomeBusinessImpl;
import com.practice.data.SomeDataService;

//In this we have created entire defination which is best practice

class SomeDataServiceStub implements SomeDataService
{
	// When we user the stub we directly hard-code the data ,but when we use the mock
	// we defined programtically
	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {1,2,3};
	}
	
}
class SomeDataServiceEmptyStub implements SomeDataService
{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {};
	}
	
}

class SomeDataServiceSingleValueStub implements SomeDataService
{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int [] {7};
	}
	
}
/*Above Code is the disadvantage of stub ,So for this reason mock comes into picture
So these are all typically the problems in using Stub.
So instead of creating a direct/Specific class like this this with
the mocks, we can programmatically create classes.
*/

class SomeBusinessTestStub {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceStub());
		int actualResutt=someBusinessImpl.calculateSumUsingDataService();
		int expectedResult=6;
		assertEquals(expectedResult, actualResutt);
	}
	
	@Test
	void calculateSumUsingDataService_CheckEmpty() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResutt=someBusinessImpl.calculateSumUsingDataService();
		int expectedResult=0;
		assertEquals(expectedResult, actualResutt);
	}
	
	@Test
	void calculateSumUsingDataService_CheckSingleValueSum() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		someBusinessImpl.setSomeDataService(new SomeDataServiceSingleValueStub());
		int actualResutt=someBusinessImpl.calculateSumUsingDataService();
		int expectedResult=7;
		assertEquals(expectedResult, actualResutt);
	}

}
