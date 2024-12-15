package in.vishal;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.vishal.entity.Account;
import in.vishal.entity.AccountPK;
import in.vishal.repository.AccountRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		AccountRepository accountRepo = context.getBean(AccountRepository.class);
		// for this accountRepo interface i need to get the implementation obj.
		//jpa will create the implementation class using proxy class
		
//		AccountPK pk= new AccountPK();
//		pk.setAccId(2);
//		pk.setAccType("Current");
//		pk.setAccNum(32423423l);
//
//		Account acc = new Account();
//		acc.setHolderName("vishal");
//		acc.setBranch("roorkee");
//		acc.setAccountPk(pk);
//
//		accountRepo.save(acc);
		
		AccountPK pk = new AccountPK();
		pk.setAccId(2);
		pk.setAccType("Current");
		pk.setAccNum(32423423l);

		Optional<Account> findById = accountRepo.findById(pk);
		System.out.println(findById.get());
	}
}
