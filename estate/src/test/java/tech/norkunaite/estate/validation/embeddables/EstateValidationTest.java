package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.enums.Action;

public class EstateValidationTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testActionNull() {
		Estate estate = new Estate(null, new BigDecimal(5000), "puikiai");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's action cannot be null");
	}

	@Test
	public void testPriceNull() {
		Estate estate = new Estate(Action.BUY, null, "puikiai");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's price cannot be null");
	}

	@Test
	public void testPriceZero() {
		Estate estate = new Estate(Action.BUY, BigDecimal.ZERO, "puikiai");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's price cannot be zero");
	}

	@Test
	public void testPriceNegative() {
		Estate estate = new Estate(Action.BUY, new BigDecimal(-5000), "puikiai");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's price cannot be negative");
	}

	@Test
	public void testDescriptionNull() {
		Estate estate = new Estate(Action.BUY, new BigDecimal(5000), null);

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's description cannot be null");
	}

	@Test
	public void testDescriptionEmpty() {
		Estate estate = new Estate(Action.BUY, new BigDecimal(5000), "");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's description cannot be empty");
	}

	@Test
	public void testDescriptionSpace() {
		Estate estate = new Estate(Action.BUY, new BigDecimal(5000), " ");

		Set<ConstraintViolation<Estate>> violations = validator.validate(estate);
		assertFalse(violations.isEmpty(), "Estate's description cannot be space");
	}

}
