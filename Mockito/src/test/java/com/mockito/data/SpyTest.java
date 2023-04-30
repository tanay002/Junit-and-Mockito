package com.mockito.data;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Tanay");
		listSpy.add("Learn Junit");

		verify(listSpy).add("Tanay");
		verify(listSpy).add("Learn Junit");

		assertEquals(2, listSpy.size());
		assertEquals("Tanay", listSpy.get(0));
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Tanay");
		listSpy.add("Learn Junit");

		//stub(listSpy.size()).toReturn(-1);

		assertEquals(-1, listSpy.size());
		assertEquals("Tanay", listSpy.get(0));

		// @Spy Annotation
	}
}
