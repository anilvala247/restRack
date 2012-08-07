package com.rack.service;

import java.io.InputStream;

import com.rack.Task;

public interface TaskService {
	Task createTaskOld(InputStream model);

	Task createTask(Task task);

	Task getTask(Long id);
}
