package org.jsp.ecommarce.controller;

import java.util.List;

import org.jsp.ecommarce.dto.ResponseStructure;
import org.jsp.ecommarce.model.User;
import org.jsp.ecommarce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	public UserService userService;

	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveMerchant(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateMerchant(@RequestBody User user) {
		return userService.updateUser(user);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> findById(@PathVariable int id) {
		return userService.findById(id);
	}

	@GetMapping("/verify-by-email")
	public ResponseEntity<ResponseStructure<User>> verifyByEmail(@RequestParam String email,
			@RequestParam String password) {
		return userService.verifyByEmail(email, password);
	}

	@GetMapping("/verfiy-by-phone")
	public ResponseEntity<ResponseStructure<User>> verifyByPhone(@RequestParam long phone,
			@RequestParam String password) {
		return userService.verifyByPhone(phone, password);
	}
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		return userService.findAll();
	}
}
