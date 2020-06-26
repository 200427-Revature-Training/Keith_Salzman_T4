package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findUserById(int id) {
		return UserRepository.findUserById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public User findUserByUsername(String username) {
		return UserRepository.findUserByUsername(username)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public User findUserByCredentials(String credentials) {
		return UserRepository.findUserByCredentials(credentials)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

//	public User findallUsers() {
//		return UserRepository.findAllUsers()
//				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
//	}

	public User update(User user) {
		return userRepository.update(user);
	}
	
	public User delete(User user) {
		return userRepository.delete(user);
	}
}
