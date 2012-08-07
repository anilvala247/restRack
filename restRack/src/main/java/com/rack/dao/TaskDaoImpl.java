package com.rack.dao;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.rack.Task;

public class TaskDaoImpl implements TaskDao {
	private  SessionFactory sessionFactory;

	public  void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;

	}

	public Task loadTask(Long id) {
		 Session session =sessionFactory.openSession();
		 return (Task)session.get(Task.class, id, LockMode.READ);
//		HibernateTemplate template = new HibernateTemplate(sessionFactory);
//		return (Task) template.get(Task.class, id);
	}

	public Task saveTask(Task task) {
		HibernateTemplate template = new HibernateTemplate(sessionFactory);
		template.save(task);
		System.out.println(task.getTaskID());
		return task;
	}
}
