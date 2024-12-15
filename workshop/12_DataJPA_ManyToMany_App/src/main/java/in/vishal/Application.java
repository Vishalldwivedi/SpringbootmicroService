package in.vishal;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vishal.entity.Address;
import in.vishal.entity.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		EmpRepository empRepository = context.getBean(EmpRepository.class);
		AddressRepository addrReposiotry = context.getBean(AddressRepository.class);

		Employee e = new Employee();
		e.setEmpName("vislal");
		e.setEmpSalary(4000.00);

		Address a1 = new Address();
		a1.setCity("canada");
		a1.setState("toronto");
		a1.setCountry("canada");
		a1.setEmp(e);

		Address a2 = new Address();
		a2.setCity("er");
		a2.setState("ree");
		a2.setCountry("India");
		a2.setEmp(e);

		// setting addresses to emp
		List<Address> addrList = Arrays.asList(a1, a2);
		e.setAddr(addrList);

		// empRepository.save(e);

		// empRepository.findById(2);

		// empRepository.deleteById(1);

		// addrReposiotry.findById(3);
	}
}
