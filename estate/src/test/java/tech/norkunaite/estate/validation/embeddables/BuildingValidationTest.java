package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Building;
import tech.norkunaite.estate.validation.EstateValidator;

public class BuildingValidationTest {
	
	private EstateValidator validator;
	private Building building;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		building = new Building(5, "Dalinė apdaila", 2000);
	}

	@Test
	public void testAreaZero() {
		building.setArea(0);
		assertTrue(validator.validatesSuccessfully(building), "Building's area cannot be zero");
	}
	
	@Test
	public void testAreaNegative() {
		building.setArea(-5);
		assertTrue(validator.validatesSuccessfully(building), "Building's area cannot be negative");
	}
	
	@Test
	public void testEquipmentNull() {
		building.setEquipment(null);
		assertTrue(validator.validatesSuccessfully(building), "Building's equipment cannot be null");
	}

	@Test
	public void testEquipmentEmpty() {
		building.setEquipment("");
		assertTrue(validator.validatesSuccessfully(building), "Building's equipment cannot be empty");
	}

	@Test
	public void testEquipmentSpace() {
		building.setEquipment(" ");
		assertTrue(validator.validatesSuccessfully(building), "Building's equipment cannot be space");
	}
	
	@Test
	public void testYear() {
		building.setYear(999);
		assertTrue(validator.validatesSuccessfully(building), "Building's year cannot be less than 1000");
	}

}
