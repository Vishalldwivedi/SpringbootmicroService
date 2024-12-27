package in.vishal.repo;

import in.vishal.entity.citizenPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;
@EnableJpaRepositories
public interface citizenPlanRepo extends JpaRepository<citizenPlan,Integer> {
//to get the data from the plan name we need to write a method
    // so that we can display that plan name in UI dropdown
    // for that i need to write one coustome  query

    @Query("select distinct(planName) from citizenPlan" )//hql query
    public List<String> getPlanName();

    // to get the unique status from the DB table
    @Query("select distinct(planStatus) from citizenPlan")
    public List<String> getStatusName();//HQL query



    //we dont need to write the query by eg method to search dynaimcally search result


}
