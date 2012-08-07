package com.rack.dao;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rack.Task;

public class TaskDaoImplTest extends TaskDaoImpl {
	SessionFactory sessionFactory;

	@Before
	public void setUp() throws Exception {
		sessionFactory = new Configuration().configure().buildSessionFactory();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoad() {
		setSessionFactory(sessionFactory);
		Task task = loadTask((long) 1);
		assertNotNull(task);
		System.out.println("---------" + task);
	}

	@Test
	public void testSave() {
		setSessionFactory(sessionFactory);
		Task task = new Task(4, 1, "Testing Hibernate", "Done", new Date());
		Task task1 = saveTask(task);
		assertNotNull(task1);
	}

}
