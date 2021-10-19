package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.LifeEstate;
import tech.norkunaite.estate.validation.EstateValidator;

public class LifeEstateValidationTest {

	private EstateValidator validator;
	private LifeEstate lifeEstate;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		lifeEstate = new LifeEstate(5, 5, 5);
	}

	@Test
	public void testBedroomZero() {
		lifeEstate.setBedroom(0);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's bedroom quantity cannot be zero");
	}

	@Test
	public void testBedroomNegative() {
		lifeEstate.setBedroom(-5);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's bedroom quantity cannot be negative");
	}

	@Test
	public void testFloorZero() {
		lifeEstate.setFloor(0);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's floor cannot be zero");
	}

	@Test
	public void testFloorNegative() {
		lifeEstate.setFloor(-5);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's floor cannot be negative");
	}

	@Test
	public void testMaxFloorQuantityZero() {
		lifeEstate.setMaxFloor(0);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's floor quantity cannot be zero");
	}

	@Test
	public void testMaxFloorQuantityNegative() {
		lifeEstate.setMaxFloor(-5);
		assertTrue(validator.validatesSuccessfully(lifeEstate), "Life estate's floor quantity cannot be negative");
	}

}
