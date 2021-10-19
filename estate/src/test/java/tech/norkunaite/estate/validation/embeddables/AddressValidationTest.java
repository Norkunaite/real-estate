package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Address;

public class AddressValidationTest {

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testDistrictMunicipalityNull() {
		Address adress = new Address(null, "Šiauliai", "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's district minicipality cannot be null");
	}

	@Test
	public void testDistrictMunicipalityEmpty() {
		Address adress = new Address("", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's district minicipality cannot be empty");
	}

	@Test
	public void testDistrictMunicipalitySpace() {
		Address adress = new Address(" ", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's district minicipality cannot be space");
	}

	@Test
	public void testTownNull() {
		Address adress = new Address("Klaipėdos raj.", null, "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's town cannot be null");
	}

	@Test
	public void testTownEmpty() {
		Address adress = new Address("Klaipėdos raj.", "", "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's town cannot be empty");
	}

	@Test
	public void testTownSpace() {
		Address adress = new Address("Klaipėdos raj.", " ", "Ąžuolija", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's town cannot be space");
	}

	@Test
	public void testMicrodistrictNull() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", null, "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's microdistrict cannot be null");
	}

	@Test
	public void testMicrodistrictEmpty() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", "", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's microdistrict cannot be empty");
	}

	@Test
	public void testMicrodistrictSpace() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", " ", "Lukšos-Daumanto");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's microdistrict cannot be space");
	}

	@Test
	public void testStreetNull() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", "Ąžuolija", null);

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's street cannot be null");
	}

	@Test
	public void testStreetEmpty() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", "Ąžuolija", "");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's street cannot be empty");
	}

	@Test
	public void testStreetSpace() {
		Address adress = new Address("Klaipėdos raj.", "Šiauliai", "Ąžuolija", " ");

		Set<ConstraintViolation<Address>> violations = validator.validate(adress);
		assertFalse(violations.isEmpty(), "Address's street cannot be space");
	}
}
