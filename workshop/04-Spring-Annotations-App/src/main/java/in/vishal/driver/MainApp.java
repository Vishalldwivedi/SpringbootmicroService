package in.vishal.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.vishal.beans.Motor;
import in.vishal.config.AppConfig;

public class MainApp {
	
	public static void main(String[] args) {
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Motor m1 = context.getBean(Motor.class);
		System.out.println(m1.hashCode());
		
		Motor m2 = context.getBean(Motor.class);
		System.out.println(m2.hashCode());
		
	}

}
