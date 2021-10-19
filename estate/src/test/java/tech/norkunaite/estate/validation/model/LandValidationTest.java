package tech.norkunaite.estate.validation.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.embeddables.LifeEstate;
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.validation.EstateValidator;

public class LandValidationTest {

	private EstateValidator validator;
	private Land land;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"),
				new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"), new BigDecimal(10000));
	}

	@Test
	public void testEstateNull() {
		land.setEstate(null);
		assertTrue(validator.validatesSuccessfully(land), "Land's estate cannot be null");
	}

	@Test
	public void testEstateDefault() {
		land.setEstate(new Estate());
		assertTrue(validator.validatesSuccessfully(land), "Land's estate cannot be invalid");
	}

	@Test
	public void testAddressNull() {
		land.setAddress(null);
		assertTrue(validator.validatesSuccessfully(land), "Land's address cannot be null");
	}

	@Test
	public void testAddressdefault() {
		land.setAddress(new Address());
		assertTrue(validator.validatesSuccessfully(land), "Land's address cannot be invalid");
	}

	@Test
	public void testLandAreaNull() {
		land.setLandArea(null);
		assertTrue(validator.validatesSuccessfully(land), "Land's land area cannot be null");
	}

	@Test
	public void testLandAreaZero() {
		land.setLandArea(BigDecimal.ZERO);
		assertTrue(validator.validatesSuccessfully(land), "Land's land area cannot be zero");
	}

	@Test
	public void testLandAreaNegative() {
		land.setLandArea(new BigDecimal(-10000));
		assertTrue(validator.validatesSuccessfully(land), "Land's land area cannot be negative");
	}

}
