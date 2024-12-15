package in.vishal;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import in.vishal.repository.AddressRepository;
import in.vishal.repository.EmpRepository;
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
		// the implementation object empRepo will be get
		AddressRepository addrReposiotry = context.getBean(AddressRepository.class);
		//// the implementation object addRepo will be get

		Employee e = new Employee();
		e.setEmpName("Rajat");
		e.setEmpSalary(65000.00);

		Address a1 = new Address();// parent of this address is employee rjt
		a1.setCity("roorke");
		a1.setState("Uttra");
		a1.setCountry("India");
		a1.setEmp(e);

		Address a2 = new Address();// parent of this address is employee rjt
		a2.setCity("roor");
		a2.setState("goa");
		a2.setCountry("India");
		a2.setEmp(e);

		// setting addresses to emp
		List<Address> addrList = Arrays.asList(a1, a2);
		e.setAddr(addrList);


		empRepository.save(e);// due to cascading type all after inserting emp parent object
		//automatically child address also inserted.
		System.out.println("done ");

//		Optional<Employee> employeeOptional = empRepository.findById(1); // as fetch type is lazy will will only retrive pareant ie: emp
//		if (employeeOptional.isPresent()) {
//			Employee employee = employeeOptional.get(); // Get the actual entity
//			System.out.println(employee.toString());
//		} else {
//			System.out.println("Employee not found");
//		}
		// record and not child ie address records

		// empRepository.deleteById(1);// when i delete my parent records child records
		// will be deleted or not-> will be deleted because i have give cascade type all

		// addrReposiotry.findById(3);//retrive both child and parent because address have
		// // emp_id forgien key haveing info of parent.
		Optional<Address> empadd = addrReposiotry.findById(1);
		if (empadd.isPresent()) {
			Address ad = empadd.get(); // Get the actual entity
			System.out.println(ad.toString()); // Address details

			// Retrieve and print Employee details
			Employee emp = ad.getEmp();
			if (emp != null) {
				System.out.println(emp.toString()); // Employee details
			} else {
				System.out.println("No Employee associated with this address.");
			}
		} else {
			System.out.println("Address not found");
		}

	}
}
