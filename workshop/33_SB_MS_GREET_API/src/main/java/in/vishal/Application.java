package in.vishal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient// it should identify were the eureka server is running
// to register it in eureka server
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
