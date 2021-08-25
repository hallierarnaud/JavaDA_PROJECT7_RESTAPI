package com.nnk.springboot.domain;

import com.nnk.springboot.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User findUserByUserName (String userName) {
    User user;
    try {
      user = userRepository.findByUsername(userName);
    } catch (Exception e) {
      throw e;
    }
    return user;
  }

}
