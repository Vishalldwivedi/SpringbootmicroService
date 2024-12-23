package in.vishal.exception;
//user defined exception class
public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CustomerNotFoundException(String msg) {
		super(msg);// is RuntimeException class means, when ever we are
		// calling this constructor internally it is calling the RuntimeException then
		// exception constructor then
		//finally Throwable class constructor will be called .
	}

}
