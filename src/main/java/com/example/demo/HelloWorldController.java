package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	//GET
	//URI
	//Method
	@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	public String HelloWorld(){
		return "Hello World";
	}
	
	@GetMapping(path="/username")
	public String getUserName(){
		return "Sandeep";
	}
	
	@GetMapping(path="/helloWorldBean")
	public HelloWorldBean getHelloWorldBean(){
		return new HelloWorldBean("Hello World Bean");
	}
	
	
	// http://localhost:8081/HelloWorld/path/pathDemo
	@GetMapping(path="HelloWorld/path/{name}")
	
	public HelloWorldBean getHelloWorldBean(@PathVariable String name){
		return new HelloWorldBean(name);
	}

}
