package com.mockito.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;

public class ListMockTest {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("practices");
		assertEquals("practices", mock.get(0));
		assertEquals(null, mock.get(1));
	}
	
	@Test
	public void returnWithAnyParameters() {
		when(mock.get(anyInt())).thenReturn("Practice_junit");
		assertEquals("Practice_junit", mock.get(0));
		assertEquals("Practice_junit", mock.get(1));
	}
	
	@Test(expected =RuntimeException.class)
	public void returnWithAnyInt_ThrowException() {
		when(mock.get(anyInt())).thenThrow(new RuntimeException("Something goes wrong"));
	mock.get(0);
	}
	
	@Test
	public void verificationBasics() {
		// SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}
	
	@Test
	public void argumentCapturing()
	{
		mock.add("Junit_Learn");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
	assertEquals("Junit_Learn",captor.getValue());
	}
	

	@Test
	public void multipleArgumentCapturing()
	{
		mock.add("Junit_Learn");
		mock.add("Mockito_Learn");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> allVaules=	captor.getAllValues();
		assertEquals("Junit_Learn",allVaules.get(0));
		assertEquals("Mockito_Learn",allVaules.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));//null
		System.out.println(arrayListMock.size());//0
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());//0
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());//5
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));//Test0
		System.out.println(arrayListSpy.size());//1
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());//3
		
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());//5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());//5
		
		verify(arrayListSpy).add("Test4");
	}
}
