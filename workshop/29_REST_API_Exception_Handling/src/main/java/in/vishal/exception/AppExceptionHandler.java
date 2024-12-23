package in.vishal.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//in rest api(means no UI) global exception handling we use this @
// in client app we use @controllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)// this tell us that this method is
	// is used to find CustomerNotFoundExecption
	//we use ResponceEntity to convey data to client with respective status code
	public ResponseEntity<ExceptionInfo> handleCnfe(CustomerNotFoundException cnfe) {

		ExceptionInfo info = new ExceptionInfo();
		info.setCode("EX0011");
		info.setMsg(cnfe.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);

	}
}
