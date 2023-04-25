package com.mockito.data.api;

import java.util.Arrays;
import java.util.List;

public class TaskServiceStub implements TaskService{
// Dynamic Condition
	// Service Definition
	
	public List<String> retrieveTasks(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring","Learn Spring Boot"
				,"Learn Java","Learn Hibernate");
	}

}
