package in.vishal.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.vishal.cfg.AppConfig;
import in.vishal.service.ReportService;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ReportService service = context.getBean(ReportService.class);
		
		service.generate();
	}
}