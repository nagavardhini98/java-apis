package com.spring.web.service;

import java.util.List;

import com.spring.web.beans.Quiz1;
import com.spring.web.beans.Registration;


public interface UserService {
	public void save(Quiz1 q1);

	public int save(Registration register);

	// void deleteUserById(int id);
	// void deleteAllUsers();
	// void updateUser(User currentUser);

	// void saveUser(User user);

}
