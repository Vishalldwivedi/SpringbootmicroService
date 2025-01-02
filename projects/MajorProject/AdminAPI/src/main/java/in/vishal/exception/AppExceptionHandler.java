package in.vishal.exception;


import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppExceptionHandler {//when ever exception occurs in my app i want to send
    //msg to my client in json format

    private Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)//when ever any runtime exception occurs i want to execute this method.
    public ResponseEntity<AppExcepiton> handleException(String exMsg) {//this will reutrn app exceptoin info/
        //binded to my AppException

        logger.error("Exception Occured : " + exMsg);

        AppExcepiton ex = new AppExcepiton();
        ex.setExCode("EX0003");
        ex.setExDesc(exMsg);
        ex.setExDate(LocalDateTime.now());

        return new ResponseEntity<AppExcepiton>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}