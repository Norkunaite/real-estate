package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Building;

public class BuildingValidationTest {
	
	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testAreaZero() {
		Building building=new Building(0, "Dalinė apdaila", 2000);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's area cannot be zero");
	}
	
	@Test
	public void testAreaNegative() {
		Building building=new Building(-5, "Dalinė apdaila", 2000);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's area cannot be negative");
	}
	
	@Test
	public void testEquipmentNull() {
		Building building=new Building(5, null, 2000);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's equipment cannot be null");
	}

	@Test
	public void testEquipmentEmpty() {
		Building building=new Building(5, "", 2000);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's equipment cannot be empty");
	}

	@Test
	public void testEquipmentSpace() {
		Building building=new Building(5, " ", 2000);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's equipment cannot be space");
	}
	
	@Test
	public void testYear() {
		Building building=new Building(5, "Dalinė apdaila", 999);

		Set<ConstraintViolation<Building>> violations = validator.validate(building);
		assertFalse(violations.isEmpty(), "Building's year cannot be less than 1000");
	}

}
