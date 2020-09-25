package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping(path = "/getAllUsers")
	public List<User> getAllUsers() {
		return userDaoService.findAllUsers();
	}

	@GetMapping(path = "findUser/{id}")
	public User findUser(@PathVariable String id) {
		return userDaoService.get(id);
	}
	
	@PostMapping(path="/updateUser")
	public void saveUser(@RequestBody User user){
		userDaoService.save(user);
	}

}
