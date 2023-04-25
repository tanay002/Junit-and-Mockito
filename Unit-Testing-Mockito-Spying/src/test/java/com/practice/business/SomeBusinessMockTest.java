 package com.practice.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.practice.Business.SomeBusinessImpl;
import com.practice.data.SomeDataService;

@ExtendWith(MockitoExtension.class)
 class SomeBusinessMockTest {

	@InjectMocks
	 SomeBusinessImpl someBusinessImpl;	
	
	@Mock
	SomeDataService someDataServiceMock;
	
	@Test
	void calculateSumUsingDataService_basic() {
	someBusinessImpl.setSomeDataService(someDataServiceMock);
	when(someDataServiceMock.retrieveAllData()).thenReturn(new int [] {1,2,3});
	assertEquals(6, someBusinessImpl.calculateSumUsingDataService());
	}
	
	@Test
	void calculateSumUsingDataService_CheckEmpty() {
		someBusinessImpl.setSomeDataService(someDataServiceMock);
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int [] {});
		assertEquals(0, someBusinessImpl.calculateSumUsingDataService());

	}
	
	@Test
	void calculateSumUsingDataService_CheckSingleValueSum() {
		someBusinessImpl.setSomeDataService(someDataServiceMock);
		when(someDataServiceMock.retrieveAllData()).thenReturn(new int [] {5});
		assertEquals(5, someBusinessImpl.calculateSumUsingDataService());

	}

}
