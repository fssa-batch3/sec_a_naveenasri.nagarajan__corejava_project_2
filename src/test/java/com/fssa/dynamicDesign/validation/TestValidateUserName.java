package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.UserValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidUserException;

public class TestValidateUserName {

	@Test
	public void testValidUserName() {
		try {
			assertTrue(UserValidator.validateName("ValidUserName"));
			System.out.println("Valid user name test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUserNameStartingWithNumber() {
		try {
			assertFalse(UserValidator.validateName("123InvalidUserName"));
			System.out.println("Invalid user name starting with a number test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUserNameShorterLength() {
		try {
			assertFalse(UserValidator.validateName("Ab"));
			System.out.println("Invalid user name shorter length test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUserNameLongerLength() {
		try {
			assertFalse(UserValidator.validateName("ThisIsAVeryLongUserNameThatExceedsTheLimit"));
			System.out.println("Invalid user name longer length test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUserNameWithSpaces() {
		try {
			assertFalse(UserValidator.validateName("Invalid User Name"));
			System.out.println("Invalid user name with spaces test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidUserNameWithSpecialCharacters() {
		try {
			assertFalse(UserValidator.validateName("Invalid$UserName"));
			System.out.println("Invalid user name with special characters test passed.");
		} catch (InvalidUserException e) {
			e.printStackTrace();
		}
	}
}