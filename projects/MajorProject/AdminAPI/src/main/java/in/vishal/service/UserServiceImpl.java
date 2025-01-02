package in.vishal.service;

import in.vishal.Util.EmailUtils;
import in.vishal.bindings.DashboardCard;
import in.vishal.bindings.LoginForm;
import in.vishal.bindings.UserAccForm;
import in.vishal.constant.AppConstants;
import in.vishal.entity.EligEntity;
import in.vishal.entity.UserEntity;
import in.vishal.repositories.EligRepo;
import in.vishal.repositories.PlanRepo;
import in.vishal.repositories.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;//to communicate with repo then repo to DB
    @Autowired
    private PlanRepo planRepo;//to communicate the planRepo then planRepo to DB

    @Autowired
    private EligRepo eligRepo;//to get the eligibility data in dashboard

    @Autowired
    private EmailUtils emailUtils;

    @Override//when ever user click on log in button to verify the given user credentials are vaild ornot
    public String login(LoginForm loginForm) {
       UserEntity entity = userRepo.findByEmailAndPwd(loginForm.getEmail(),loginForm.getPwd());
        if(entity == null){
            return AppConstants.INVALID_CRED;
        }
        if(AppConstants.Y_STR.equals(entity.getAccStatus()) && AppConstants.UNLOCKED.equals(entity.getAccStatus())){
            return AppConstants.SUCCESS;

        }else{
            return AppConstants.ACC_LOCKED;
        }
    }
    //first time user acccount will be in locked status so check is this unlocked or not
    //second we need to check if account is active or not



    @Override
    public boolean recoverPwd(String email) {
        UserEntity userEntity = userRepo.findByEmail(email);
        if(null == userEntity) {
            return false;
        }
            else{
            String subject = AppConstants.RECOVER_SUB;
            String body = readEmailBody(AppConstants.PWD_BODY_FILE, userEntity);
            return emailUtils.sendEmail(subject, body, email);
            }
    }

    @Override
    public DashboardCard fetchDashboardInfo() {
       long plansCount =  planRepo.count();//tell u how many plans are available in our sys

       List<EligEntity> eliList =  eligRepo.findAll();//in this list how many records approved
        //denied , amountGiven

        //using filters in stream api we can count data in eliList
       Long approvedCnt =  eliList.stream().filter(ed-> ed.getPlanStatus().equals(AppConstants.AP)).count();

       Long deniedCnt =  eliList.stream().filter(ed-> ed.getPlanStatus().equals(AppConstants.DN)).count();

       Double total = eliList.stream().mapToDouble(ed -> ed.getBenefitAmt()).sum();



        DashboardCard card =new  DashboardCard();//adding these dashboards info in dashboards binding obj
        card.setPlansCnt(plansCount);
        card.setApprovedCnt(approvedCnt);
        card.setDeniedCnt(deniedCnt);
        card.setBeniftAmtGiven(total);
        return card;//this card will have data that we need for dashboard display
    }
    @Override
    public UserAccForm getUserByEmail(String email){
       UserEntity userEntity =  userRepo.findByEmail(email);
       UserAccForm user = new UserAccForm();

        BeanUtils.copyProperties(userEntity,user);
        return user;
    }

    private String readEmailBody(String filename, UserEntity user) {
        StringBuilder sb = new StringBuilder();
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            lines.forEach(line -> {
                line = line.replace(AppConstants.FNAME, user.getFullName());
                line = line.replace(AppConstants.PWD, user.getPwd());
                line = line.replace(AppConstants.EMAIL, user.getEmail());
                sb.append(line);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
