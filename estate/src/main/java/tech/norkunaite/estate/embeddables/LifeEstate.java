package tech.norkunaite.estate.embeddables;

import javax.persistence.Embeddable;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LifeEstate {

	@Positive(message = "Bedroom must be positive number")
	private int bedroom;

	@Positive(message = "Floor must be positive number")
	private int floor;

	// aukstu kiekis
	@Positive(message = "Building's floor quantity must be positive number")
	private int maxFloor;

}
