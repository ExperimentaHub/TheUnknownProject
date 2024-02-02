package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;


	@Service
	public class UserService {

		@Autowired
	    private final UserRepository userRepository;

	    public UserService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    public User getUserById(Long userId) {
	        return userRepository.findById(userId).orElse(null);
	    }
}
