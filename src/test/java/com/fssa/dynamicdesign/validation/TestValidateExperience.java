package com.fssa.dynamicdesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.validation.ArchitectValidator;
import com.fssa.dynamicdesign.validation.exception.InvalidArchitectException;

 class TestValidateExperience {

	@Test
	 void testValidExperience() {
		try {
			assertTrue(ArchitectValidator.validateExperience(5));
			System.out.println("Valid experience test passed.");
		} catch (InvalidArchitectException e) {
			System.out.println("Caught InvalidArchitectException for a valid experience.");
			fail();
		}
	}

	@Test
	 void testValidExperienceWithSingleDigit() {
		try {
			assertTrue(ArchitectValidator.validateExperience(9));
			System.out.println("Valid single-digit experience test passed.");
		} catch (InvalidArchitectException e) {
			System.out.println("Caught InvalidArchitectException for a valid single-digit experience.");
			fail();
		}
	}

	@Test
	 void testInvalidNegativeExperience() {
		try {
			assertFalse(ArchitectValidator.validateExperience(-3));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid negative experience.");
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidExperienceWithNonNumeric() {
		try {
			assertFalse(ArchitectValidator.validateExperience(Integer.parseInt("-1"))); // -1 as a string
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid non-numeric experience.");
			e.printStackTrace();
		}
	}

	@Test
	 void testInvalidExperienceWithThreeDigits() {
		try {
			assertFalse(ArchitectValidator.validateExperience(123));
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid three-digit experience.");
			e.printStackTrace();
		}
	}

}
