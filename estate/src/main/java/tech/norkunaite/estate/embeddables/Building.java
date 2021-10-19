package tech.norkunaite.estate.embeddables;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Building {

	@Positive(message = "Building area must be positive number")
	private double area;

	// irengimas
	@NotBlank(message = "Equipment cannot be blank")
	private String equipment;

	@Range(min = 1000, message = "Building year cannot be less than 1000")
	private int year;

}
