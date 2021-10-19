package tech.norkunaite.estate.embeddables;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.norkunaite.estate.enums.Action;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estate {

	@NotNull(message = "Action cannot be null")
	private Action action;

	@NotNull(message = "Price cannot be null")
	@Positive(message = "Price must be positive number")
	private BigDecimal price;

	@Lob
	@NotBlank(message = "Description cannot be blank")
	private String decription;

}
