package com.fssa.dynamicDesign.TestUser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.model.User;
import com.fssa.dynamicDesign.service.UserService;
import com.fssa.dynamicDesign.service.exception.ServiceException;

public class TestRegisterFeature {

	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		// email is not repeating so give unique email
		//********************** Important ******************
		// change userID , Email
		//***************************************************
		
		User user1 = new User(6, "isu3@gmail.com", "Ishwarya", "Ishu@123", "8072404562", "user");
		try {
			assertTrue(userService.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testRegistrationNullPassword() {
		UserService userService = new UserService();
		User user = new User(5, "JohnDoe", null, "john@example.com", "8565473543", "user");
		try {
			userService.registerUser(user);
			fail("Expected ServiceException for null password, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegistrationNullUser() {
		UserService userService = new UserService();
		try {
			userService.registerUser(null);
			fail("Expected ServiceException for null user, but none was thrown.");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

//    @Test
//    public void testRegistrationEmailEmpty() {
//        UserService userService = new UserService();
//        User user1 = new User(2, "", "Babu", "Babu@123", "9876543123", "user");
//        try {
//            userService.registerUser(user1);
//            fail();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testRegistrationPhoneNumberInvalid() {
//        UserService userService = new UserService();
//        User user1 = new User(3, "babu@gmail.com", "Babu", "Babu@123", "987654h123", "user");
//        try {
//            userService.registerUser(user1);
//            fail();
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void testRegistrationEmptyPassword() {
//        UserService userService = new UserService();
//        User user = new User(4, "JohnDoe", "", "john@example.com", "8565473543", "user");
//        try {
//            userService.registerUser(user);
//            fail("Expected ServiceException for empty password, but none was thrown.");
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }

//    @Test
//    public void testRegistrationEmptyUsername() {
//        UserService userService = new UserService();
//        User user = new User(6, "", "P@ssw0rd", "john@example.com", "8565473543", "user");
//        try {
//            userService.registerUser(user);
//            fail("Expected ServiceException for empty username, but none was thrown.");
//        } catch (ServiceException e) {
//            e.printStackTrace();
//        }
//    }

}