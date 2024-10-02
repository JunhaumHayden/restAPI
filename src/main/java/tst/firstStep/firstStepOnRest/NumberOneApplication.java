package tst.firstStep.firstStepOnRest;

import javax.swing.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
// The @RestController annotation tells Spring that this code describes an endpoint that should be made available over the web. 
public class NumberOneApplication 
{

	// This is all the code required to create a simple “Hello World” web service in Spring Boot.
	public static void main(String[] args) 
	{
		SpringApplication.run(NumberOneApplication.class, args);
		
	}
		//   The @GetMapping(“/hello”) tells Spring to use our hello() method to answer requests that get sent to the http://localhost:8080/hello address.
		  @GetMapping("/hello")
		//   The hello() method we’ve added is designed to take a String parameter called name, and then combine this parameter with the word "Hello" in the code. This means that if you set your name to "Amy" in the request, the response would be “Hello Amy” (http://localhost:8080/hello?name=Amy).
		// the @RequestParam is telling Spring to expect a name value in the request, but if it’s not there, it will use the word "World" by default.
		  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) 
		  {
			return String.format("Hello %s!", name);
		  }
}
