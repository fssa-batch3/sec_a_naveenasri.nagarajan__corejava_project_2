package com.fssa.dynamicDesign.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicDesign.validation.ArchitectValidator;
import com.fssa.dynamicDesign.validation.exception.InvalidArchitectException;

public class TestValidateGender {

	@Test
	public void testValidMaleGender() {
		try {
			assertTrue(ArchitectValidator.validateGender("Male"));
			System.out.println("Valid Male gender test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid Male gender.");
		}
	}

	@Test
	public void testValidFemaleGender() {
		try {
			assertTrue(ArchitectValidator.validateGender("Female"));
			System.out.println("Valid Female gender test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid Female gender.");
		}
	}

	@Test
	public void testValidOtherGender() {
		try {
			assertTrue(ArchitectValidator.validateGender("Other"));
			System.out.println("Valid Other gender test passed.");
		} catch (InvalidArchitectException e) {
			e.printStackTrace();
			System.out.println("Caught InvalidArchitectException for a valid Other gender.");
		}
	}

	@Test
	public void testInvalidNullGender() {
		try {
			assertFalse(ArchitectValidator.validateGender(null));
			System.out.println("Invalid null gender test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid null gender.");
		}
	}

	@Test
	public void testInvalidNonAllowedGender() {
		try {
			assertFalse(ArchitectValidator.validateGender("NonAllowed"));
			System.out.println("Invalid non-allowed gender test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid non-allowed gender.");
		}
	}

	@Test
	public void testInvalidMixedCaseGender() {
		try {
			assertFalse(ArchitectValidator.validateGender("mAle"));
			System.out.println("Invalid mixed-case gender test passed.");
		} catch (InvalidArchitectException e) {
			// Correct exception type is caught
			System.out.println("Caught InvalidArchitectException for an invalid mixed-case gender.");
		}
	}
}
