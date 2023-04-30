package com.mockito.business;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.mockito.data.api.TaskService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
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


public class TaskBusinessImplMockTest {
    // What is mocking
	//Mocking is creating objects that simulates the behaviour of real object.
	//Unlike stubs,mocks can be dynamicaly created from code - at runtime
	// Mocks offer more functionality than stubbing
	// We can verify method calls and a lot
	@Test
	public void testRetriveTaskRelatedToSpring_usingAMock()
	{
		TaskService taskServices= mock(TaskService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot");
		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServices);
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(3, filteredTasks.size());
	}
	
	@Test
	public void testRetriveTaskRelatedToSpringWithEmptyArray_usingAMock()
	{
		TaskService taskServices= mock(TaskService.class);
		List<String> allTodos = Arrays.asList();
		when(taskServices.retrieveTasks("Dummy")).thenReturn(allTodos);
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServices);
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(0, filteredTasks.size());
	}
	
	@Test
	public void testDeleteTaskRelatedToSpring_usingAMock()
	{
		TaskService taskServicesMock= mock(TaskService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java");
		
		when(taskServicesMock.retrieveTasks("Dummy")).thenReturn(allTodos);
		
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServicesMock);
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");
		
		verify(taskServicesMock).deleteTask("Learn Java");
		//or    above and below line of code is same
		// Below line of code is easily readable
		then(taskServicesMock).should().deleteTask("Learn java");
		
		
		verify(taskServicesMock,never()).deleteTask("Learn Spring MVC");
		// or
		then(taskServicesMock).should(never()).deleteTask("Learn Spring MVC");
		
		
		verify(taskServicesMock).deleteTask("Learn Spring");
	
		verify(taskServicesMock, times(2)).deleteTask("Learn Spring");
		verify(taskServicesMock, atLeast(1)).deleteTask("Learn Spring Boot");
	//	verify(taskServicesMock, atLeastOnce()).deleteTask("Learn Spring MVC");
		verify(taskServicesMock, atMost(2)).deleteTask("Learn Spring Boot");
	
	}
	

	@Test
	public void testDeleteTaskRelatedToSpring_testArgumentCaptor()
	{
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		TaskService taskServicesMock= mock(TaskService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java");

		when(taskServicesMock.retrieveTasks("Dummy")).thenReturn(allTodos);
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServicesMock);
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");

		then(taskServicesMock).should().deleteTask(argumentCaptor.capture());
		assertThat(argumentCaptor.getValue(),is("Learn Java"));


	}
	
	@Test
	public void testDeleteTaskRelatedToSpring_testArgumentCaptorMutipleValue()
	{
		ArgumentCaptor<String> argumentCaptor=ArgumentCaptor.forClass(String.class);
		TaskService taskServicesMock= mock(TaskService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot","Learn Java","Learn Hibernate");

		when(taskServicesMock.retrieveTasks("Dummy")).thenReturn(allTodos);
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServicesMock);
		taskBusinessImpl.deleteTasksRelatedToDo("Dummy");

		then(taskServicesMock).should(times(2)).deleteTask(argumentCaptor.capture());
		assertThat(argumentCaptor.getAllValues().size(),is(2));


	}
	
	
}
