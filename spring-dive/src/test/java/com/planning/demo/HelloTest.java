package com.planning.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author yxc
 * @date 2021/7/3 2:04 下午
 */
public class HelloTest {

	@Test
	public void classpathXmlApplicationContextTest(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationcontext.xml");
		HelloSpring helloSpring = context.getBean("helloSpring", HelloSpring.class);
		String result = helloSpring.run();
		assertThat(result).isEqualTo("run");
	}

	@Test
	public void beanFactoryTest(){
		// BeanFactory is Deprecated, For advanced needs, consider using a DefaultListableBeanFactory with an XmlBeanDefinitionReader.

		/*
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationcontext.xml"));
		HelloSpring helloSpring = (HelloSpring) beanFactory.getBean("helloSpring");
		demoService.run();
		*/

		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(new ClassPathResource("applicationcontext.xml"));
		HelloSpring helloSpring = factory.getBean("helloSpring", HelloSpring.class);
		String result = helloSpring.run();
		assertThat(result).isEqualTo("run");
	}

	public void beanFactoryTest2(){

	}

}
