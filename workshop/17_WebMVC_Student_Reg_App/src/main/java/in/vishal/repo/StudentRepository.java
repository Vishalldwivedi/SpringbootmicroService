package in.vishal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}
