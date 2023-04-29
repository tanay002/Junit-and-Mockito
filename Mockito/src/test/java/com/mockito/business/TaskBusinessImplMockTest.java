package com.mockito.business;

import org.junit.Test;

import com.mockito.data.api.TaskService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
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
}
