package in.vishal.service;

import in.vishal.bindings.UnlockAccForm;
import in.vishal.bindings.UserAccForm;

import java.util.List;

//to capture account data we need accountFrom object so accountFrom we can take as a method parameter
//form data should come from UI to backend
// in backend we have this createUserAccount method which will take this form data as parameter
//and put in DB and return true or false .
public interface AccountService
{
    //CreateAccount need input(form data) and output(msg of creation of acc)
    public Boolean createUserAccount(UserAccForm accForm);

    //method to get createdAcc data from Db and display
    //when view account so  no input just output .
    public List<UserAccForm> fetchUserAccount();

    //after seeing createdAcc we need to able to edit that account info or soft delete that
    // to edit user input will be accountID and return type should be UserAccForm
    public UserAccForm getUserAccById(Integer accID);

    //for soft delete
    public String changeAccStatus(Integer accId, String status);
    //taking two parameter which user account to change and what we need to keep

//when admin will create a account for caseworker caseworker it will receive a mail to unlock the account.
    public String unlockUserAccount(UnlockAccForm unlockAccForm);


}
