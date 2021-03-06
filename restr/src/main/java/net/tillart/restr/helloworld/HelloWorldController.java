package net.tillart.restr.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	// @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello, World!";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello, World!");
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWorldBean helloName(@PathVariable String name) {
		return new HelloWorldBean("Hello, " + name);
	}

}
