package in.vishal.repositories;

import in.vishal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    //writing a custom query to update the status of the user in DB
   @Query("update UserEntity  set accStatus=:status where userId=:userId")
    public Integer updateAccStatus(Integer userId , String status);


    //unlockUserAcc in userService we need to verify if email is present or not
    public UserEntity findByEmail(String email);

    public UserEntity findByEmailAndPwd(String email, String pwd);//with given email and pwd am i
    //able to log in :: UserService login




}
