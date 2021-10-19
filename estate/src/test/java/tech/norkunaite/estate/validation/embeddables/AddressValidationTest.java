package tech.norkunaite.estate.validation.embeddables;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.validation.EstateValidator;

public class AddressValidationTest {

	private EstateValidator validator;
	private Address address;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		address = new Address("Klaipėdos raj.", "Šiauliai", "Ąžuolija", "Lukšos-Daumanto");
	}

	@Test
	public void testDistrictMunicipalityNull() {	
		address.setDistrictMunicipality(null);
		assertTrue(validator.validatesSuccessfully(address), "Address's district minicipality cannot be null");	
	}

	@Test
	public void testDistrictMunicipalityEmpty() {
		address.setDistrictMunicipality("");
		assertTrue(validator.validatesSuccessfully(address), "Address's district minicipality cannot be empty");	
	}

	@Test
	public void testDistrictMunicipalitySpace() {
		address.setDistrictMunicipality(" ");
		assertTrue(validator.validatesSuccessfully(address), "Address's district minicipality cannot be space");	
	}

	@Test
	public void testTownNull() {
		address.setTown(null);
		assertTrue(validator.validatesSuccessfully(address), "Address's town cannot be null");
	}

	@Test
	public void testTownEmpty() {
		address.setTown("");
		assertTrue(validator.validatesSuccessfully(address), "Address's town cannot be empty");
	}

	@Test
	public void testTownSpace() {
		address.setTown(" ");
		assertTrue(validator.validatesSuccessfully(address), "Address's town cannot be space");
	}

	@Test
	public void testMicrodistrictNull() {
		address.setMicrodistrict(null);
		assertTrue(validator.validatesSuccessfully(address), "Address's microdistrict cannot be null");
	}

	@Test
	public void testMicrodistrictEmpty() {
		address.setMicrodistrict("");
		assertTrue(validator.validatesSuccessfully(address), "Address's microdistrict cannot be empty");
	}

	@Test
	public void testMicrodistrictSpace() {
		address.setMicrodistrict(" ");
		assertTrue(validator.validatesSuccessfully(address), "Address's microdistrict cannot be space");
	}

	@Test
	public void testStreetNull() {
		address.setStreet(null);
		assertTrue(validator.validatesSuccessfully(address), "Address's street cannot be null");
	}

	@Test
	public void testStreetEmpty() {
		address.setStreet("");
		assertTrue(validator.validatesSuccessfully(address), "Address's street cannot be empty");
	}

	@Test
	public void testStreetSpace() {
		address.setStreet(" ");
		assertTrue(validator.validatesSuccessfully(address), "Address's street cannot be space");
	}
}
