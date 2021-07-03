package com.planning.demo;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author yxc
 * @date 2021/7/3 2:04 下午
 */
public class HelloTest {

	@Test
	public void test(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationcontext.xml");
		HelloSpring demoService = context.getBean("helloSpring", HelloSpring.class);
		demoService.run();
	}
}
