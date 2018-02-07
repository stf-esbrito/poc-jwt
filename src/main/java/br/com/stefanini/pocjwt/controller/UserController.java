package br.com.stefanini.pocjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.stefanini.pocjwt.dto.UserDTO;
import br.com.stefanini.pocjwt.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String getUsers() {
		return "teste";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody UserDTO user) {
		return userService.login(user);
	}
}
