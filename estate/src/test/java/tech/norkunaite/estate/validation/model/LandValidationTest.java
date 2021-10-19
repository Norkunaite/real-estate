package tech.norkunaite.estate.validation.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

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
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.model.Land;

public class LandValidationTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testEstateNull() {
		Land land = new Land(1l, null, new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"),
				new BigDecimal(10000));

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's estate cannot be null");
	}

	@Test
	public void testEstateDefault() {
		Land land = new Land(1l, new Estate(), new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"),
				new BigDecimal(10000));

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's estate cannot be invalid");
	}

	@Test
	public void testAddressNull() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"), null, new BigDecimal(10000));

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's address cannot be null");
	}

	@Test
	public void testAddressdefault() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"), new Address(),
				new BigDecimal(10000));

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's address cannot be invalid");
	}

	// ffffffffffff
	@Test
	public void testLandAreaNull() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"),
				new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"), null);

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's land area cannot be null");
	}

	@Test
	public void testLandAreaZero() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"),
				new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"), BigDecimal.ZERO);

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's land area cannot be zero");
	}

	@Test
	public void testLandAreaNegative() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(5000), "puikiai"),
				new Address("Klaipėdos raj", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto"), new BigDecimal(-10000));

		Set<ConstraintViolation<Land>> violations = validator.validate(land);
		assertFalse(violations.isEmpty(), "Land's land area cannot be negative");
	}

}
