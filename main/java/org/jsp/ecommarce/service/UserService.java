package org.jsp.ecommarce.service;


import java.util.List;
import java.util.Optional;

import org.jsp.ecommarce.dao.UserDao;
import org.jsp.ecommarce.dto.ResponseStructure;
import org.jsp.ecommarce.exception.IdNotFoundException;
import org.jsp.ecommarce.exception.InvalidCredentialException;
import org.jsp.ecommarce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserDao userdao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> structure = new ResponseStructure<>();
		structure.setData(userdao.saveUser(user));
		structure.setMessage("User Created");
		structure.setStatuscode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(User user) {
		Optional<User> recUser = userdao.findById(user.getId());
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			User dbuser = new User();
			dbuser.setName(user.getName());
			dbuser.setPhone(user.getPhone());
			dbuser.setAge(user.getAge());
			dbuser.setEmail(user.getEmail());
			dbuser.setPassword(user.getPassword());
			user = userdao.saveUser(user);
		}
		structure.setData(userdao.saveUser(user));
		structure.setMessage("User Updated");
		structure.setStatuscode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<User>> findById(int id) {
		Optional<User> recUser = userdao.findById(id);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Found");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new IdNotFoundException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyByEmail(String email, String password) {
		Optional<User> recUser = userdao.verifyByEmail(email, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Email Verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}

	public ResponseEntity<ResponseStructure<User>> verifyByPhone(long phone, String password) {
		Optional<User> recUser = userdao.verifyByPhone(phone, password);
		ResponseStructure<User> structure = new ResponseStructure<>();
		if (recUser.isPresent()) {
			structure.setData(recUser.get());
			structure.setMessage("User Phone Number Verified");
			structure.setStatuscode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
		}
		throw new InvalidCredentialException();
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAll() {
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setData(userdao.findAll());
		structure.setMessage("Users Found");
		structure.setStatuscode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>>>(structure, HttpStatus.FOUND);
	}

	}


