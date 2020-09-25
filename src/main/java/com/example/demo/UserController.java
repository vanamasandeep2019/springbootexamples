package com.example.demo;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User user=userDaoService.get(id);
		if(user==null){
			throw new UserNotFoundException(id);
		}
		return user;
	}
	
	@PostMapping(path="/updateUser")
	public ResponseEntity<Object> saveUser(@RequestBody User user){
		userDaoService.save(user);
		URI location=ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

}
