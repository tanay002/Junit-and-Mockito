package com.mockito.business;

import org.junit.Test;

import com.mockito.data.api.TaskService;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;
import java.util.Arrays;
import java.util.List;

public class TaskBusinessImplMockTestBDD {

	@Test
	public void testRetriveTaskRelatedToSpring_usingAMock()
	{
		//Given
		TaskService taskServices= mock(TaskService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn Spring Boot");
		given(taskServices.retrieveTasks("Dummy")).willReturn(allTodos);
		TaskBusinessImpl taskBusinessImpl=new TaskBusinessImpl(taskServices);
		
		//when
		List<String> filteredTasks=taskBusinessImpl.retrieveTasksRelatedToDo("Dummy");
		
		//then
		assertThat(filteredTasks.size(),is(2));
	}

}
