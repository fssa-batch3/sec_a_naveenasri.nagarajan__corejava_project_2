package com.fssa.dynamicdesign.service;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.dynamicdesign.model.Design;
import com.fssa.dynamicdesign.service.exception.ServiceException;

class TestDesignUpdateFeature {

	@Test
	void testUpdateDesignSuccess() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(29, "fansy living Room",
				"https://cdn.pixabay.com/photo/2016/06/24/10/47/house-1477041_1280.jpg", 110.00,
				"Interior design helps one elevate their existence,their lifestyle and their perception of the world.It is a fundamental human desire to seek and identify beauty in the surrounding.",
				4);
		try {
			if (!designService.updateDesign(designToUpdate)) {
				fail("Failed to update design.");
			} else {
				System.out.println("Design Updated Successfully");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
			fail("Failed to update design.");
		}
	}

	@Test
	void testUpdateNonExistentDesign() {
		DesignService designService = new DesignService();
		Design nonExistentDesign = new Design(1000, "Updated Design", "https://example.com/updated", 150.0,
				"Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
				4);
		try {
			if (designService.updateDesign(nonExistentDesign)) {
				fail("Successfully updated non-existent design.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateWithNegativePrice() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(3, "Updated Design", "https://example.com/updated", -50.0, "", 2);
		try {
			if (designService.updateDesign(designToUpdate)) {
				fail("Successfully updated design with negative price.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testUpdateWithNegativeRooms() {
		DesignService designService = new DesignService();
		Design designToUpdate = new Design(4, "Updated Design", "https://example.com/updated", 150.0,
				"Interior design helps one elevate their existence, their lifestyle and their perception of the world. It is a fundamental human desire to seek and identify beauty in the surrounding.",
				-3);
		try {
			if (designService.updateDesign(designToUpdate)) {
				fail("Successfully updated design with invalid email.");
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}
