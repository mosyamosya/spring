package com.dubinetska.user;
import java.util.*;

import org.springframework.stereotype.Service;
@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public String deleteUser(Long id) {
    userRepository.deleteById(id);
    return "deleted";
  }

}
