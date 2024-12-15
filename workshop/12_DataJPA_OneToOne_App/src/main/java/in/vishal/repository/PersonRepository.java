package in.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
