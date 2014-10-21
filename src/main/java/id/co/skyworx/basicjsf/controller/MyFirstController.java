package id.co.skyworx.basicjsf.controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MyFirstController {
	private String message = "this is my first controller";
	private String name;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		message = "Hello " + name;
	}
	
	public String sayHelloAgain() {
		 message = "Hello Again " + name;
		 return "output";
	}
	
}
