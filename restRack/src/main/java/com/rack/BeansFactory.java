package com.rack;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeansFactory {
	private static String beanFileName = "applicationContext.xml";

	private static BeanFactory factory;

	private BeansFactory() {
	}

	public static void initialize() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { beanFileName });
		factory = (BeanFactory) context;
//		System.out.println(((UserDao)factory.getBean("userDao")).loadUser((long)1).getPhoneNumber());
		
	}

	public static void initialize(String appContextFileName) {
		if (StringUtils.isNotEmpty(appContextFileName)) {
			beanFileName = appContextFileName;
			initialize();
		}
	}

	public static Object getBean(String bean) {
		System.out.println("Bean "+bean);
//		System.out.println(((UserDao)factory.getBean("userDao")).loadUser((long)1).getPhoneNumber());
		return factory.getBean(bean);
	}

	public static void destroy() {
		ClassPathXmlApplicationContext ctx = ((ClassPathXmlApplicationContext) factory);
		ctx.close();
	}
}
