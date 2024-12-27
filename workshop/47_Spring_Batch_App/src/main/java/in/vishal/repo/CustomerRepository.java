package in.vishal.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
