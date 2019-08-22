package com.revature.intercomm;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.models.User;

@Component
public class UserClientFallback implements UserClient {

	@Override
	public List<User> findByEmail(String emails) {
		System.out.println("fallback");
		return null;
	}

}
