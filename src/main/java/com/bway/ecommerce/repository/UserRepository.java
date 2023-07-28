package com.bway.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailAndPassword(String email, String psw);
	User findByUsername(String un);
	User findByEmail(String email);
	void save(String pwd);
}
