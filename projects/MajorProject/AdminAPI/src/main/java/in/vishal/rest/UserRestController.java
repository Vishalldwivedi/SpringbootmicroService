package in.vishal.rest;

import in.vishal.bindings.DashboardCard;
import in.vishal.bindings.LoginForm;
import in.vishal.bindings.UserAccForm;
import in.vishal.entity.UserEntity;
import in.vishal.service.AccountService;
import in.vishal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {//deal with login  forGetpassword dashboard
    @Autowired
    private UserService userService;

    @PostMapping("login")//click on login
    public String login(@RequestBody LoginForm loginForm){
       String status =  userService.login(loginForm);
       if(status.equals("success")){//i need to send DashBoard Data
            return "redirect:/dashboard?email="+loginForm.getEmail();//i am sending email from the logininform
           //// as a query parameter to dashboard
       }else{
            return status;
       }
    }//but is it a admin log in or caseWorker login
    @GetMapping("/dashboard")
    public ResponseEntity<DashboardCard> buildDashboard(@RequestParam("email") String email){
        //i need to fetch userName based on emailId
        UserAccForm user =  userService.getUserByEmail(email);

        DashboardCard dashboardCard = userService.fetchDashboardInfo();
        dashboardCard.setUser(user);//set the type of user who is accessing the dashboard
        return new ResponseEntity<>(dashboardCard, HttpStatus.OK);

    }


}
