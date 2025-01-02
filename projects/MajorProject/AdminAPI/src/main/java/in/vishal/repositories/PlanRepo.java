package in.vishal.repositories;

import in.vishal.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface PlanRepo extends JpaRepository<PlanEntity, Integer> {

    @Modifying // Required for update queries
    @Transactional // Ensures query execution within a transaction
    @Query("UPDATE PlanEntity p SET p.activeSw = :status WHERE p.planId = :id")
    public Integer updatePlanStatus(@Param("id") Integer id, @Param("status") String status);

}
