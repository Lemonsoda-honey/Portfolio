package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	long countByUsername( String username);

	User findByUsername(String username);
}
