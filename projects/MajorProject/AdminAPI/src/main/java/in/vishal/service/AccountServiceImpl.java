package in.vishal.service;

import in.vishal.Util.EmailUtils;
import in.vishal.bindings.UnlockAccForm;
import in.vishal.bindings.UserAccForm;
import in.vishal.entity.UserEntity;
import in.vishal.repositories.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class AccountServiceImpl implements AccountService{

    //we need to UserRepo so inject it to create account we need to communicate with repo
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmailUtils emailUtils;
    @Override
    public Boolean createUserAccount(UserAccForm accForm) {
        //converting the Acc form data into User entity object
        //copying the data from binding form to entity object
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(accForm,entity);


        //set random pwd
        entity.setPwd(generatePwd());

        //set acc status
        entity.setAccStatus("LOCKED");
        entity.setActiveSw("Y");
        userRepo.save(entity);//save the entity object in UserRepo

        //send email
        // send email
        String subject = "User Registration";
        String body = readEmailBody("REG_EMAIL_BODY.txt", entity);
        return emailUtils.sendEmail(subject, body, accForm.getEmail());
        //if true that means record is inserted and email is send successfully

    }

    private String readEmailBody(String filename, UserEntity user) {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            lines.forEach(line -> {
                line = line.replace("${FNAME}", user.getFullName());
                line = line.replace("${TEMP_PWD}", user.getPwd());
                line = line.replace("${EMAIL}", user.getEmail());
                sb.append(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override//when every click on view Accounts this method is responsible to get
    // the created user data from DB in form of binding obj
    public List<UserAccForm> fetchUserAccount() {
       List<UserEntity> entities = userRepo.findAll();//this will return list of entity from DB

        //convert these entities to binding objects so that i can display those
        //binding obj to UI .

        List<UserAccForm> users = new ArrayList<>();
        for(UserEntity userEntity : entities){
            UserAccForm user = new UserAccForm();
            BeanUtils.copyProperties(userEntity,user);
            users.add(user);
        }

        return users;//finally i am return one collection of UserAccForm binding obj to UI

    }

    @Override//when user click on edit option we need to get the userdata by userID from Db
    public UserAccForm getUserAccById(Integer accID) {
        //optinal because from the given ID record may or may not be available
        Optional<UserEntity> optional = userRepo.findById(accID);
        if(optional.isPresent()){
            UserEntity userEntity = optional.get();
            //but we need the binding UserAccForm in the UI
            UserAccForm user = new UserAccForm();
            BeanUtils.copyProperties(userEntity,user);//user entity to user binding object
            return user;
        }
            return null;
    }

    @Override
    public String changeAccStatus(Integer userId, String status) {
        int count = userRepo.updateAccStatus(userId, status);
        if(count>0){
            return "status Changed";
        }
        return "Failed to change";
    }

    @Override//we get the entered form data in unlockedAccForm
    public String unlockUserAccount(UnlockAccForm unlockAccForm) {

        UserEntity entity = userRepo.findByEmail(unlockAccForm.getEmail());
        entity.setPwd(unlockAccForm.getNewPwd());
        entity.setAccStatus("UNLOCKED");
        userRepo.save(entity);//save updated entity in Db with user give new pwd
        return "Account Unlocked";
    }

    private String generatePwd() {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";

        // combine all strings
        String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

        // create random string builder
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();

        // specify length of random string
        int length = 6;

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(alphaNumeric.length());

            // get character specified by index
            // from the string
            char randomChar = alphaNumeric.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
