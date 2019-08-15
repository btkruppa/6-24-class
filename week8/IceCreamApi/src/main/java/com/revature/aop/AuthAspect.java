package com.revature.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.revature.models.User;

@Aspect
@Component
public class AuthAspect {

	@Around("@annotation(auth) && execution(* *(..))")
	public Object authenticate(ProceedingJoinPoint pjp, Auth auth) throws Throwable {
		// get current user from session
		HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		User currentUser = (User) req.getSession().getAttribute("user");
		
		// if there is no current user don't call the controller method
		// and set the status to 401
		if (currentUser == null) {
			HttpServletResponse res = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			res.getWriter().write("You are not authenticated");
			res.setStatus(401);
			return null;
		} else {
			// see if the user has one of the allowed roles
			// if so allow the controller to continue
			for (String role : auth.roles()) {
				if (role.equals(currentUser.getRole())) {
					return pjp.proceed();
				}
			}

			// if the user did not have any allowed roles
			// do not call controller and set status to 403
			HttpServletResponse res = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getResponse();
			res.getWriter().write("You do not have permissions");
			res.setStatus(403);
			return null;
		}

	}

}
