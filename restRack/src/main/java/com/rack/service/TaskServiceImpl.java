package com.rack.service;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.rack.ApplicationError;
import com.rack.BeansFactory;
import com.rack.Errors;
import com.rack.Task;
import com.rack.dao.TaskDao;

@Path("task")
public class TaskServiceImpl implements TaskService {

	private TaskDao taskDao = (TaskDao) BeansFactory.getBean("taskDao");
	private static final Logger LOG = Logger.getLogger(TaskDao.class);
	
	public Task createTaskOld(InputStream model) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({ MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_XML })
	public Task createTask(Task task) {
		validateTask(task);
		LOG.debug(task);
		return saveTaskToDB(task);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_OCTET_STREAM })
	public Task getTask(Long id) {
		validateID(id);
		Task task = taskDao.loadTask(id);
		return null;
	}

	protected void validateID(Long id) {
		if (id != null && id < 0) {
			Errors errors = new Errors();
			ApplicationError error = new ApplicationError("INPUT_DATA",
					"Invalid Request. Id, is Required");
			errors.add(error);
			throw new WebApplicationException(Response
					.status(Status.BAD_REQUEST).entity(errors).build());
		}

	}

	private Task saveTaskToDB(Task task) {
		return taskDao.saveTask(task);
	}

	protected void validateTask(Task task) {
		if (task == null || task.getTitle() == null) {
			Errors errors = new Errors();
			ApplicationError error = new ApplicationError("INPUT_DATA",
					"Invalid Data");
			errors.add(error);
			throw new WebApplicationException(Response
					.status(Status.BAD_REQUEST).entity(errors).build());
		}

	}
}
