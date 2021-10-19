package tech.norkunaite.estate.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class EstateValidator {
	
	private Validator validator;

	public EstateValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	public <T> boolean validatesSuccessfully(T object) {
		Set<ConstraintViolation<T>> violations = validator.validate(object);
		return !violations.isEmpty();
	}
	

}
