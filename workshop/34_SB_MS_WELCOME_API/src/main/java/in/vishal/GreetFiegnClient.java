package in.vishal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "GREET-API")//three are 3 apis available in greet api.
public interface GreetFiegnClient {

	@GetMapping("/greet")
	public String invokGreetApi();

}
