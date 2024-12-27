package in.vishal.DataLoader;

import in.vishal.entity.citizenPlan;
import in.vishal.repo.citizenPlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component// we need to load the data in the data base table
//runner are used to execute only once when app is started
public class runner implements ApplicationRunner {
    //injecting the repo so that i can save the data
    //using this repo i need to insert recored in my db table
    @Autowired
    private citizenPlanRepo repo ;
    @Override
    public void run(ApplicationArguments args) throws Exception{
        citizenPlan c1 = new citizenPlan();
        //cash approved
        c1.setCitizenName("vishal");
        c1.setGender("male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(9));


        citizenPlan c2 = new citizenPlan();
       // cash denied
        c2.setCitizenName("dwivedi");
        c2.setGender("male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setPlanStartDate(LocalDate.now());
        c2.setPlanEndDate(LocalDate.now().plusMonths(9));
        c2.setDeniedReason("Rental Income");

       List<citizenPlan> list = Arrays.asList(c1,c2);//i have list of entity
        repo.saveAll(list);//insert all the record in the table
    }

}
