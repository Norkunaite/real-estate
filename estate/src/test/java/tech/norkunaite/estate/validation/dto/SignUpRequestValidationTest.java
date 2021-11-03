package tech.norkunaite.estate.validation.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tech.norkunaite.estate.dto.SignUpRequest;
import tech.norkunaite.estate.validation.EstateValidator;

public class SignUpRequestValidationTest {

	private EstateValidator validator;
	private SignUpRequest request;

	@BeforeEach
	public void setUp() {
		validator = new EstateValidator();
		request = new SignUpRequest("test", "test@test.lt", "Uztrauktukas1!", "Uztrauktukas1!");
	}

	@Test
	public void testUsernameNull() {
		request.setUsername(null);
		assertTrue(validator.validatesSuccessfully(request), "Username cannot be null");
	}

	@Test
	public void testUsernameEmpty() {
		request.setUsername("");
		assertTrue(validator.validatesSuccessfully(request), "Username cannot be empty");
	}

	@Test
	public void testUsernameSpace() {
		request.setUsername(" ");
		assertTrue(validator.validatesSuccessfully(request), "Username cannot be space");
	}

	@Test
	public void testEmailNull() {
		request.setEmail(null);
		assertTrue(validator.validatesSuccessfully(request), "Email cannot be null");
	}

	@Test
	public void testEmailEmpty() {
		request.setEmail("");
		assertTrue(validator.validatesSuccessfully(request), "Email cannot be empty");
	}

	@Test
	public void testEmailSpace() {
		request.setEmail(" ");
		;
		assertTrue(validator.validatesSuccessfully(request), "Email cannot be space");
	}

	@Test
	public void testEmailPatternLocalPartExists() {
		request.setEmail("@test.lt");
		assertTrue(validator.validatesSuccessfully(request), "Local-part has to exist in an email");
	}

	@Test
	public void testEmailPatternDomainExists() {
		request.setEmail("test@");
		assertTrue(validator.validatesSuccessfully(request), "Domain has to exist in an email");
	}

	@Test
	public void testEmailPatternAtSignExists() {
		request.setEmail("testtest.lt");
		assertTrue(validator.validatesSuccessfully(request), "@-sign has to exist in an email");
	}
	
	@Test
	public void testPasswordLengthAtLeast8() {
		request.setPassword("u");
		assertTrue(validator.validatesSuccessfully(request), "Password must contain at least 8 symbols");
	}
	
	@Test
	public void testPasswordHasUpperCase() {
		request.setPassword("uztrauktukas1!");
		assertTrue(validator.validatesSuccessfully(request), "Password must contain an upper case letter");
	}
	
	@Test
	public void testPasswordHasLowerCase() {
		request.setPassword("UZTRAUKTUKAS1!");
		assertTrue(validator.validatesSuccessfully(request), "Password must contain a lower case letter");
	}
	
	@Test
	public void testPasswordHasDigit() {
		request.setPassword("Uztrauktukas!");
		assertTrue(validator.validatesSuccessfully(request), "Password must contain a digit");
	}
	
	@Test
	public void testPasswordHasSpecialSymbol() {
		request.setPassword("uztrauktukas1");
		assertTrue(validator.validatesSuccessfully(request), "Password must contain a special symbol");
	}
		
	@Test
	public void testConfirmPasswordLengthAtLeast8() {
		request.setConfirmPassword("u");
		assertTrue(validator.validatesSuccessfully(request), "Confirm password must contain at least 8 symbols");
	}
	
	@Test
	public void testConfirmPasswordHasUpperCase() {
		request.setConfirmPassword("uztrauktukas1!");
		assertTrue(validator.validatesSuccessfully(request), "Confirm password must contain an upper case letter");
	}
	
	@Test
	public void testConfirmPasswordHasLowerCase() {
		request.setConfirmPassword("UZTRAUKTUKAS1!");
		assertTrue(validator.validatesSuccessfully(request), "Confirm password must contain a lower case letter");
	}
	
	@Test
	public void testConfirmPasswordHasDigit() {
		request.setConfirmPassword("Uztrauktukas!");
		assertTrue(validator.validatesSuccessfully(request), "Confirm password must contain a digit");
	}
	
	@Test
	public void testConfirmPasswordHasSpecialSymbol() {
		request.setConfirmPassword("uztrauktukas1");
		assertTrue(validator.validatesSuccessfully(request), "Confirm password must contain a special symbol");
	}
	
}
