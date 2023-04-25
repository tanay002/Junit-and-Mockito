 package com.practice.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.practice.Business.SomeBusinessImpl;
import com.practice.data.SomeDataService;
// When we user the stub we directly hard-code the data ,but when we use the mock
// we defined programtically

 class SomeBusinessMockTest {

	@Test
	void calculateSumUsingDataService_basic() {
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl();
		
	SomeDataService someDataServiceMock=mock(SomeDataService.class);
	when(someDataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3});
	
		someBusinessImpl.setSomeDataService(someDataServiceMock);
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
