package com.moa.backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.backend.Persistence.UserRepository;
import com.moa.backend.Class.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> getAll() {
		return repository.findAll();
	}
	
	public Optional<User> getOne(Long id) {
		return repository.findById(id);
	}
	
	public User save(User u) {
		return repository.save(u);
	}
	
	public User update(User u) {
		if (u.getId() == null) {
			throw new RuntimeException("User id is not defined.");
		}
		User prevUser = repository.getReferenceById(u.getId());
		// logic to update data here
		return repository.save(u);
	}
	
	/*
	 * As a personal preference, data should never be deleted.
	 * Consider implementing a disabled state for deleted users instead.
	 */
	public void delete(Long id) throws Exception {
		repository.deleteById(id);
	}
}
