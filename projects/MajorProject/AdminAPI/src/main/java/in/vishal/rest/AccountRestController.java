package in.vishal.rest;

import in.vishal.bindings.UserAccForm;
import in.vishal.service.AccountService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AccountRestController {

    private Logger logger = LoggerFactory.getLogger(AccountRestController.class);
    //for debugging , monitoring , error tracking.
    @Autowired
    private AccountService accService;

    @PostMapping("/user")//when u click submit form
    public ResponseEntity<String> createAcc(@RequestBody UserAccForm userAccForm){// i want user Account created

        logger.debug("Account Creation Process Started...");

        boolean status = accService.createUserAccount(userAccForm);
        logger.debug("Account Creation Process Completed...");
        if(status){
            logger.info("Account Created Successfully..");
            return new ResponseEntity<>("Account created", HttpStatus.CREATED);//201
            //this i want to send in the response body .
        }else{
            logger.info("Account Created Failed..");
            return new ResponseEntity<>("Account creation failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }//500
    }
    @GetMapping("/users")//when u click on viewAccount
    public ResponseEntity<List<UserAccForm>> getUsers(){//i want a list of UserAccForms

        logger.debug("Fetching User Accounts process started..");

        List<UserAccForm> userAccForms = accService.fetchUserAccount();
        logger.debug("Fetching User Accounts process completed..");
        logger.info("User Accounts Fetched success....");
        return new ResponseEntity<>(userAccForms,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")//when click on edit
    public ResponseEntity<UserAccForm> getUser(@PathVariable("userId") Integer userId) { //give me the 1 UserAccForm

        logger.debug("User account Search by Id started..");

        UserAccForm user = accService.getUserAccById(userId);

        logger.info("User account fetched successfully..");
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/user/{userId}/{status}")//when click on status
    public ResponseEntity<List<UserAccForm>> updateUserAcc(@PathVariable("userId")Integer userId,@PathVariable("status")String status){

        logger.debug("User account update process started..");

        String s = accService.changeAccStatus(userId,status);
        logger.debug("User account update process completed..");
        logger.info("User account status updated successfully..");

        List<UserAccForm> userAccForms = accService.fetchUserAccount();//once update i want all userdata;
        return new ResponseEntity<>(userAccForms,HttpStatus.OK);

    }

}
