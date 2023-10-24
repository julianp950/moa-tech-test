package com.moa.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.backend.Class.Role;
import com.moa.backend.Persistence.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
	public List<Role> getAll() {
		return repository.findAll();
	}
	
	public Optional<Role> getOne(Long id) {
		return repository.findById(id);
	}
}
