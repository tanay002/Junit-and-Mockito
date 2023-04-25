package com.mockito.business;

import org.junit.Test;

import com.mockito.data.api.TaskService;
import com.mockito.data.api.TaskServiceStub;

import static org.junit.Assert.*;

import java.util.List;

public class MockTaskBusinessImplMockTest {
    // What is mocking
	//Mocking is creating objects that simulates the behaviour of real object.
	//Unlike stubs,mocks can be dynamicaly created from code - at runtime
	// Mocks offer more functionality than stubbing
	// We can verify method calls and a lot
	@Test
	public void testRetriveTaskRelatedToSpring_usingAMock()
	{
		TaskService taskService=new TaskServiceStub();
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskService);
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(3, filteredTasks.size());
	}
}
