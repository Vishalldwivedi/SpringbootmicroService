package in.vishal;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
