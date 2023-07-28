package com.bway.ecommerce.service;

import com.bway.ecommerce.model.User;

public interface UserService {

	void register(User user);
	User login(String email, String psw);
	User isUserExist(String un);
	User getUserByEmail(String email);
}
