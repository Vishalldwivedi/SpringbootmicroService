package in.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}