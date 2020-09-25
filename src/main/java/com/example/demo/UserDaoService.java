package com.example.demo;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User("1", "Daiwik"));
		users.add(new User("2", "Krishna"));
		users.add(new User("3", "Madhu"));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User save(User user) {
		users.add(user);
		
		return user;
	}

	public User get(String userId){
		for (User user : users) {
			if(user.getId().equalsIgnoreCase(userId)){
				return user;
			}
		}
		return null;
	}

}
