package com.moa.backend.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moa.backend.Class.Role;
import com.moa.backend.Services.RoleService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	private RoleService service;
	
	@GetMapping
	public List<Role> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "/{id}")
	public Optional<Role> getOneFront(@PathVariable(name = "id") Long id) {
		return service.getOne(id);
	}

}
