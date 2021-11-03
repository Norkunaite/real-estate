package tech.norkunaite.estate.utils;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

import tech.norkunaite.estate.annotations.StrongPassword;

public class PasswordConstraintValidator implements ConstraintValidator<StrongPassword, String> {

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {

		PasswordValidator validator = new PasswordValidator(Arrays.asList(
				new LengthRule(8, Integer.MAX_VALUE) ,
				new CharacterRule(EnglishCharacterData.UpperCase, 1),
				new CharacterRule(EnglishCharacterData.LowerCase, 1),
				new CharacterRule(EnglishCharacterData.Digit, 1),
				new CharacterRule(EnglishCharacterData.Special, 1)
				));

		RuleResult result = validator.validate(new PasswordData(password));

		if (result.isValid()) {
			return true;
		}

		return false;

	}

}
