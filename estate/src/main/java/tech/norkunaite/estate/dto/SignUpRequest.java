package tech.norkunaite.estate.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.norkunaite.estate.annotations.StrongPassword;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

	@NotBlank(message = "Username cannot be blank")
	private String username;
	@Email(message = "Email must be valid")
	@NotBlank(message = "Email cannot be blank")
	private String email;
	@StrongPassword(message = "Pasword must contain at least 8 symbols, have a number, have an upper-case letter, lower-case letter and a special symbol")
	private String password;
	@StrongPassword(message = "Confirm pasword must contain at least 8 symbols, have a number, have an upper-case letter, lower-case letter and a special symbol")
	private String confirmPassword;

	public boolean passwordsMatch() {
		return password.equals(confirmPassword);
	}

}
