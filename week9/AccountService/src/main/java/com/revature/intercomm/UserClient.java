package com.revature.intercomm;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.models.User;

@FeignClient(name = "user-service")
public interface UserClient {

	@GetMapping("users/email/{emails}")
	public List<User> findByEmail(@PathVariable String emails);
		
}
