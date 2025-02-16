package in.vishal.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.vishal.beans.Car;

public class App {
	
	public static void main(String[] args) {
		
		// starting iOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		Car car = context.getBean(Car.class);
		car.drive();
	}
}