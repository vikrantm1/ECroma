package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface IUserService {
	User authenticateUser(String em, String pass);
	String registerUser(User user);
	List<User> getPateintList();
}
