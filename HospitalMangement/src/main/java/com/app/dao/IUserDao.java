package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.User;

public interface IUserDao extends JpaRepository<User, Long> {
	Optional<User> findByNameAndPass(String em, String pass);
	List<User> findAllByRole(String role);
	
}
