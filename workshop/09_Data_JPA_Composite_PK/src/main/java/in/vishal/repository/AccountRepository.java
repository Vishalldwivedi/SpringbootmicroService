package in.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Account;
import in.vishal.entity.AccountPK;

public interface AccountRepository extends JpaRepository<Account, AccountPK> {

}