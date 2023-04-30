package com.mockito.business;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.mockito.data.api.TaskService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.mockito.runners.MockitoJUnitRunner;

//@RunWith(MockitoJUnitRunner.class)
public class TaskBusinessImplMockInjectMockAndCaptor {
    
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}

	@Rule
	public MockitoRule mockitoRule=MockitoJUnit.rule();
	
	@Mock
	TaskService taskServices;
	
	@InjectMocks
	TaskBusinessImpl taskBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> argumentCaptor;
	
	@Test
	public void testRetriveTaskRelatedToSpring_usingAMock()
	{
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot");
		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(3, filteredTasks.size());
	}
	
	@Test
	public void testRetriveTaskRelatedToSpringWithEmptyArray_usingAMock()
	{
		
		List<String> allTodos = Arrays.asList();
		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(0, filteredTasks.size());
	}
	
	@Test
	public void testDeleteTaskRelatedToSpring_usingAMock()
	{
			List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java");
		
		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");
		
		verify(taskServices).deleteTask("Learn Java");
		//or    above and below line of code is same
		// Below line of code is easily readable
		then(taskServices).should().deleteTask("Learn java");
		
		
		verify(taskServices,never()).deleteTask("Learn Spring MVC");
		// or
		then(taskServices).should(never()).deleteTask("Learn Spring MVC");
		
		
		verify(taskServices).deleteTask("Learn Spring");
	
		verify(taskServices, times(2)).deleteTask("Learn Spring");
		verify(taskServices, atLeast(1)).deleteTask("Learn Spring Boot");
	//	verify(taskServicesMock, atLeastOnce()).deleteTask("Learn Spring MVC");
		verify(taskServices, atMost(2)).deleteTask("Learn Spring Boot");
	
	}
	

	@Test
	public void testDeleteTaskRelatedToSpring_testArgumentCaptor()
	{
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java");

		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");

		then(taskServices).should().deleteTask(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(),is("Learn Java"));
	}
	
	@Test
	public void testDeleteTaskRelatedToSpring_testArgumentCaptorMutipleValue()
	{
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java","Learn Hibernate");

		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");

		then(taskServices).should(times(2)).deleteTask(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(),is(2));
	}
}
