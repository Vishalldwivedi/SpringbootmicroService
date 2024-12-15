package in.vishal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vishal.entity.Passport;

public interface PassportRepository extends JpaRepository<Passport, Integer>{

}
