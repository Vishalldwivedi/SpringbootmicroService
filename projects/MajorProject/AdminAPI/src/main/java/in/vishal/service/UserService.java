package in.vishal.service;

import in.vishal.bindings.DashboardCard;
import in.vishal.bindings.LoginForm;
import in.vishal.bindings.UserAccForm;

public interface UserService {

    //this method will that in credentails which are stored in binding object of LoginForm
    //and verify if credentials are correct or not and return
    public String login(LoginForm loginForm);


    //once user click on forget password it will take mail id as input
    // return your password is send to your mail
    //or your mail id is not in our system
    public boolean recoverPwd(String email);

    //once loged in successfully fetch Dashboard
    // get the users records based in user ID .
    public DashboardCard fetchDashboardInfo();
    //from backend to front end sending json object to display in dashboard


    public UserAccForm getUserByEmail(String email);


}
