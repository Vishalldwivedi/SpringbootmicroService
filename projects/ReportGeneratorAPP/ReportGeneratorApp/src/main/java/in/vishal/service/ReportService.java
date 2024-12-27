package in.vishal.service;

import in.vishal.entity.citizenPlan;
import in.vishal.request.SeachRequest;
import org.apache.catalina.filters.ExpiresFilter;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.util.List;

public interface ReportService {
    //method to get the plan name drop down data from dB.
    public List<String> getPlanNames();

    //method to get the plan status drop down data from DB
    public List<String> getPlanStatus();

    //search use may select filters or may not
    //if not we need to display all the data of DB

    //for that we will use form binding class
    public List<citizenPlan> search(SeachRequest request);
    //when user click search we are adding seachRequest as paramete and returing the citizenPlan data


    //to send report to the email
    public boolean exportExcel(HttpServletResponse response) throws Exception;//when click to excel it has to generate
    //excel file and send to the email as attachment
    // i need to display success or failaur msg

    public boolean exportPdf(HttpServletResponse response) throws Exception;;//
}
