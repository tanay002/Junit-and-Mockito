package com.mockito.business;

import org.junit.Test;

import com.mockito.data.api.TaskService;
import com.mockito.data.api.TaskServiceStub;

import static org.junit.Assert.*;

import java.util.List;

public class TaskBusinessImplStub {
    
	@Test
	public void testRetriveTaskRelatedToSpring_usingAStub()
	{
		TaskService taskService=new TaskServiceStub();
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskService);
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		assertEquals(3, filteredTasks.size());
	}
}
