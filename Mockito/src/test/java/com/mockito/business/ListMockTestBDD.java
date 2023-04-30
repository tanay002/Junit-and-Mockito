package com.mockito.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.anyInt;

public class ListMockTestBDD {

	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		given(mock.size()).willReturn(5);
		assertThat(mock.size(),is(5));
	}

	@Test
	public void returnDifferentValues() {
		given(mock.size()).willReturn(5).willReturn(10);
		assertThat(mock.size(),is(5));
		assertThat(mock.size(),is(10));
	}

	@Test
	public void returnWithParameters() {
		given(mock.get(0)).willReturn("practices");
		assertThat(mock.get(0),is("practices"));
	}
	
	

}
