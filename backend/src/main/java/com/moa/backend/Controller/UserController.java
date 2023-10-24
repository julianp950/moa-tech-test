package com.moa.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moa.backend.Class.User;
import com.moa.backend.Services.UserService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<User> getOneFront(@PathVariable(name = "id") Long id) {
		return service.getOne(id);
	}
	
	@PostMapping
	public User save(@RequestBody User u) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return service.save(u);
	}
	
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.PUT)
	public User update(@RequestBody User u, @PathVariable(name = "id") Long id) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return service.update(u);		
	}
	
	@DeleteMapping (value = "/deleteUser/{id}")
	public void delete(@PathVariable(name = "id") Long id) throws Exception {
		service.delete(id);
	}
}
