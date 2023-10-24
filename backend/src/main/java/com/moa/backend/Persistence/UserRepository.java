package com.moa.backend.Persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moa.backend.Class.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserNameAndPassword(String userName, String password);
	User findByToken(String token);
	User findByUserName(String userName);
	Optional<User> findById(Long id);
}