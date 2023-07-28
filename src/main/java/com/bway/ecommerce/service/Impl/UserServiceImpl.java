package com.bway.ecommerce.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.ecommerce.model.User;
import com.bway.ecommerce.repository.UserRepository;
import com.bway.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepo;
	@Override
	public void register(User user) {
		userRepo.save(user);
		
	}

	@Override
	public User login(String email, String psw) {
		
		return userRepo.findByEmailAndPassword(email, psw);
	}

	@Override
	public User isUserExist(String un) {
		return userRepo.findByUsername(un);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

}
