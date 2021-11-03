package tech.norkunaite.estate.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tech.norkunaite.estate.utils.PasswordConstraintValidator;

@Documented
@Target(ElementType.FIELD)
@Constraint(validatedBy = { PasswordConstraintValidator.class })
@Retention(RetentionPolicy.RUNTIME)
public @interface StrongPassword {

	String message() default "Invalid Password";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
