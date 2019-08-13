package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.revature.models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
	List<User> findByRoleOrderByUsername(String role);
	
	@Query("FROM User u WHERE u.role = :role")
	List<User> findByRoleHql(String role);
	
	
}
