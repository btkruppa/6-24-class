package com.revature.w.exceptions;

import java.rmi.ServerException;

public class ExceptionsDriver {
	public static void main(String[] args) {
		try {
			String user = login("btkruppa", "pass");
			System.out.println("logged in as: " + user);
		} catch (ServerException e) {
			// send back 500 status code
			System.out.println("500");
		}  catch (InvalidCredentialsException e) {
			// send back 400 status code
			System.out.println("400");
		} finally {
			// finally always runs
			System.out.println("finally");
		}

	}

	private static String login(String username, String password) throws ServerException, InvalidCredentialsException {
		double random = Math.random();
		if (random < 0.3) {
			throw new ServerException("Something went wrong while trying to login");
		} else if (random < 0.6) {
			throw new InvalidCredentialsException();
		} else {
			return "btkruppa";
		}
	}
}
