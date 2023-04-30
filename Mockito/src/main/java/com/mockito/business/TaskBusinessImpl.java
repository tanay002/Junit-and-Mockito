package com.mockito.business;

import java.util.List;
import java.util.stream.Collectors;

import com.mockito.data.api.TaskService;
//TaskBusinessImpl SUT (System Under Test)
// TaskServiceImpl Dependency
public class TaskBusinessImpl {

	private TaskService taskService;

	public TaskBusinessImpl(TaskService taskService) {
		super();
		this.taskService = taskService;
	}

	public List<String> retrieveTasksRelatedToDo(String username)
	{   
		List<String> todotasks=taskService.retrieveTasks(username);
	List<String> filteredTasks=	todotasks.stream().filter(task->task.contains("Spring")).collect(Collectors.toList());
		return filteredTasks;
	}
	
	public void deleteTasksRelatedToDo(String username)
	{   
		List<String> todotasks=taskService.retrieveTasks(username);
	
		for(String task: todotasks)
		{
			if(!task.contains("Spring"))
			{
				taskService.deleteTask(task);
			}
		}
	}
}
