package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.LifeEstate;

public class LifeEstateValidationTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testBedroomZero() {
		LifeEstate lifeEstate = new LifeEstate(0, 5, 5);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's bedroom quantity cannot be zero");
	}

	@Test
	public void testBedroomNegative() {
		LifeEstate lifeEstate = new LifeEstate(-5, 5, 5);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's bedroom quantity cannot be negative");
	}
	
	@Test
	public void testFloorZero() {
		LifeEstate lifeEstate = new LifeEstate(5, 0, 5);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's floor cannot be zero");
	}

	@Test
	public void testFloorNegative() {
		LifeEstate lifeEstate = new LifeEstate(5, -5, 5);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's floor cannot be negative");
	}
	
	@Test
	public void testMaxFloorQuantityZero() {
		LifeEstate lifeEstate = new LifeEstate(5, 5, 0);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's floor quantity cannot be zero");
	}

	@Test
	public void testMaxFloorQuantityNegative() {
		LifeEstate lifeEstate = new LifeEstate(5, 5, -5);

		Set<ConstraintViolation<LifeEstate>> violations = validator.validate(lifeEstate);
		assertFalse(violations.isEmpty(), "Life estate's floor quantity cannot be negative");
	}

}
