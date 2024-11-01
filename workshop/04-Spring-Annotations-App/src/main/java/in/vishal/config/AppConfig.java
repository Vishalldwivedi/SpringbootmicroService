package in.vishal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.vishal.beans.Robot;

@Configuration
@ComponentScan(basePackages = { "in.vishal" , "com.ibm" })
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

	@Bean//programmer is creating the robot objects
	public Robot buildRobot() {
		//logic
		Robot r = new Robot();
		return r;
	}
}