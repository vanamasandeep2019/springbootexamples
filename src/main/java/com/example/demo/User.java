package com.example.demo;

public class User {

	private String name;

	private String id;
	
	public User(){
		
	}

	public User( String id,String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return this.getId() + "-" + this.getName();
	}

}
