package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.validation.EstateValidator;

public class EstateValidationTest {

	private EstateValidator validator;
	private Estate estate;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		estate = new Estate(Action.BUY, new BigDecimal(5000), "puikiai");
	}

	@Test
	public void testActionNull() {
		estate.setAction(null);
		assertTrue(validator.validatesSuccessfully(estate), "Estate's action cannot be null");
	}

	@Test
	public void testPriceNull() {
		estate.setPrice(null);
		assertTrue(validator.validatesSuccessfully(estate), "Estate's price cannot be null");
	}

	@Test
	public void testPriceZero() {
		estate.setPrice(BigDecimal.ZERO);
		assertTrue(validator.validatesSuccessfully(estate), "Estate's price cannot be zero");
	}

	@Test
	public void testPriceNegative() {
		estate.setPrice(new BigDecimal(-5000));
		assertTrue(validator.validatesSuccessfully(estate), "Estate's price cannot be negative");
	}

	@Test
	public void testDescriptionNull() {
		estate.setDecription(null);
		assertTrue(validator.validatesSuccessfully(estate), "Estate's description cannot be null");
	}

	@Test
	public void testDescriptionEmpty() {
		estate.setDecription("");
		assertTrue(validator.validatesSuccessfully(estate), "Estate's description cannot be empty");
	}

	@Test
	public void testDescriptionSpace() {
		estate.setDecription(" ");
		assertTrue(validator.validatesSuccessfully(estate), "Estate's description cannot be space");
	}

}
