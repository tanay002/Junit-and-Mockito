package com.mockito.data.api;

import java.util.List;

// Create TodoserviceStub
// Test TodoBusinessImpl using TodoServicesStub
public interface TaskService {

	public List<String> retrieveTasks(String user);

    public void deleteTask(String task);
}
