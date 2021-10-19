package tech.norkunaite.estate.embeddables;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@NotBlank(message = "District municipality cannot be blank")
	private String districtMunicipality;

	@NotBlank(message = "Town cannot be blank")
	private String town;

	@NotBlank(message = "Microdistrict cannot be blank")
	private String microdistrict;

	@NotBlank(message = "Street cannot be blank")
	private String street;

}
