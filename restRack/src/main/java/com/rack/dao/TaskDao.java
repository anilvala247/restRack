package com.rack.dao;

import com.rack.Task;

public interface TaskDao {
	Task loadTask(Long id);

	Task saveTask(Task task);
}
