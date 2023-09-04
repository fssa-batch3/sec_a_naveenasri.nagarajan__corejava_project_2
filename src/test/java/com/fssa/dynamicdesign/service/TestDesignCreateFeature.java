package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignCreateFeature {

	@Test
	void testCreateDesignSuccess() {
		DesignService designService = new DesignService();
		// (designName, designUrl, price, noOfRooms, architectID)
		Design design1 = new Design("Minimalist Bed Room", "https://cdn.pixabay.com/photo/2020/11/24/11/36/bedroom-5772286_1280.jpg", 100.0,
				"Interior design helps one elevate their existence,their lifestyle and their perception of the world.It is a fundamental human desire to seek and identify beauty in the surrounding.",
				2, 76);
		try {
			assertTrue(designService.createDesign(design1));
			System.out.println("Your Design Added Successfully ");
		} catch (ServiceException e) {
			e.printStackTrace();
			fail();
		}

	}

	@Test
	void testNegativePriceValue() {
		DesignService designService = new DesignService();
		Design design = new Design("Modern design", "https://example.com/negative_price", -50.0,
				"Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
				1, 3);
		try {
			assertFalse(designService.createDesign(design));
			fail("Expected ServiceException for negative price value");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testNegativeRoomsValue() {
		DesignService designService = new DesignService();
		Design design = new Design("Modern design", "https://example.com/negative_id", 80.0,
				"Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
				-5, 5);
		try {
			assertFalse(designService.createDesign(design));
			fail("Expected ServiceException for negative number of rooms");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testNullDesignObject() {
		DesignService designService = new DesignService();
		Design design = null;
		try {
			assertFalse(designService.createDesign(design));
			fail("Expected ServiceException for null design object");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}