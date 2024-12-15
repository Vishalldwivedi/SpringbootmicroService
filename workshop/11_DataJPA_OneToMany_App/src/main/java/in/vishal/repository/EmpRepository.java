package in.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
