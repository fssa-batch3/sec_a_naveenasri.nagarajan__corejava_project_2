package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.ArchitectValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;

public class TestValidateEducation {

	@Test
	public void testValidEducation() {
		try {
			assertTrue(ArchitectValidator.validateEducation("Bachelor of Science"));
			System.out.println("Valid education test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid education.");
		}
	}

	@Test
	public void testValidEducationWithSpaces() {
		try {
			assertTrue(ArchitectValidator.validateEducation("Master of Arts in Literature"));
			System.out.println("Valid education with spaces test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid education with spaces.");
		}
	}

	@Test
	public void testInvalidNullEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(null));
			System.out.println("Invalid null education test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null education.");
		}
	}

	@Test
	public void testInvalidEmptyEducation() {
		try {
			assertFalse(ArchitectValidator.validateEducation(""));
			System.out.println("Invalid empty education test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid empty education.");
		}
	}

	@Test
	public void testInvalidEducationWithNumbers() {
		try {
			assertFalse(ArchitectValidator.validateEducation("PhD in Physics 123"));
			System.out.println("Invalid education with numbers test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with numbers.");
		}
	}

	@Test
	public void testInvalidEducationWithSpecialCharacters() {
		try {
			assertFalse(ArchitectValidator.validateEducation("High School Diploma @#$"));
			System.out.println("Invalid education with special characters test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid education with special characters.");
		}
	}
}
