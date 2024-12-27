package in.vishal.controller;

import in.vishal.entity.citizenPlan;
import in.vishal.service.ReportService;
import in.vishal.service.ReportServiceimp;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import in.vishal.request.SeachRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;



@Controller
public class ReportController {
    // contoller is talking to service
    //there form inject service object here doing DI
    @Autowired
    private ReportService service;

    @GetMapping("/")//page is loading through controller method
    //this controller method is creating the serarhRequest object and
    //sending that searchRequest obj through through UI using model obj
    //
    public String indexPage(Model model){//model will give data from controller to UI
       // to bind the UI data to searchReq
        model.addAttribute("search", new SeachRequest());
        // i am sending this search request object to the UI by model attribute
        //becuase for that page i want to map it to my java class

        init(model);
        return "index";
    }

//why init method?
  //  After submitting the form, the model is rebuilt without
  //  including the dropdown data unless explicitly added again.
    private void init(Model model) {
      //  model.addAttribute("search", new SeachRequest());
        model.addAttribute("names",service.getPlanNames());
        model.addAttribute("status",service.getPlanStatus());
    }

    @PostMapping("/search")
    public String handleSearch(SeachRequest search, Model model){
      List<citizenPlan> plans =  service.search(search);//service data is coming to controller
        //now from controller to UI i need to send the data
        model.addAttribute("plans" , plans);
        model.addAttribute("search",search);
        //sending binding selected data back to UI

        init(model);
        return "index";//return the data in the same page
    }
    //modelAttribute after this postRequest is executed again in model that search
    //object will be stored .so that now the selected option will be remained


    //method to download the generated Excel by clicking excel link
    @GetMapping("/excel")//it should be downloaded
    //why httpServletResponse as i wnat to send excel file in the browser as a response object
    public void excelExport(HttpServletResponse response)throws Exception{

        response.setContentType("application/octet-stream");
        // when u click on excel excel file should be downloaded in browser
        response.addHeader("Content-Disposition","attachment;filename=plans.xlsx");

        //we need to pass this response object to service class method
        service.exportExcel(response);

        //my data will send via response object  response contain the outputstream
        // which as data excel file which will be downloaded
    }
    @GetMapping("/pdf")//to send the file to browser i am taking response obj as parameter
    public void exportPdf(HttpServletResponse response)throws Exception{
        response.setContentType("application/pdf");
        response.addHeader("Content-Disposition","attachment;filename=plans.pdf");
        service.exportPdf(response);
    }
}
