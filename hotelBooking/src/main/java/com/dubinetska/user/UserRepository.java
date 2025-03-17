package com.dubinetska.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * UserRepository
 */

public interface UserRepository extends JpaRepository<User, Long> {

  @SuppressWarnings("null")
  @Query("SELECT u FROM User u WHERE u.id = ?1")
  Optional<User> findById(Long id);

}