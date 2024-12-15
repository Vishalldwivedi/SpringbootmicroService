package in.vishal;

import in.vishal.entity.Passport;
import in.vishal.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vishal.repository.PassportRepository;
import in.vishal.repository.PersonRepository;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		PersonRepository personRepo = context.getBean(PersonRepository.class);

		PassportRepository passportRepo = context.getBean(PassportRepository.class);

		Person person = new Person();
		person.setPersonName("vishal");
		person.setPersonGender("Male");

		Passport passport = new Passport();
		passport.setPassportNum("JJHG73H");
		passport.setIssuedDate(LocalDate.now());
		passport.setExpiryDate(LocalDate.now().plusYears(10));

		person.setPassport(passport);
		passport.setPerson(person);
		
		personRepo.save(person);// both person and password will be save
		
       Optional<Person> per =  personRepo.findById(1);
	   Person obj = per.get();
		System.out.println(obj.toString());
//
		personRepo.deleteById(1);

	}
}
