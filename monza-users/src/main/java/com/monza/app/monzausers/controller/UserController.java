package com.monza.app.monzausers.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monza.app.monzausers.exception.UserNotFoundException;
import com.monza.app.monzausers.model.User;
import com.monza.app.monzausers.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UsersService usersService;

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return usersService.save(user);
	}

	@PutMapping("/users/{userId}")
	public User updateUser(@PathParam("userId") String userId, @RequestBody User user) throws UserNotFoundException {
		return usersService.updateUser(userId, user);
	}

	@DeleteMapping("/users/{userId}")
	public void deleteUser(@PathParam("userId") String userId) {
		usersService.deleteUser(userId);
	}

	@GetMapping("/users/{userId}")
	public void getUser(@PathParam("userId") String userId) throws UserNotFoundException {
		usersService.getUser(userId);
	}
}
