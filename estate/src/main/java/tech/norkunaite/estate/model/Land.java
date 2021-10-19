package tech.norkunaite.estate.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Estate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Land {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	@Valid
	@NotNull
	private Estate estate;

	@Embedded
	@Valid
	@NotNull
	private Address address;

	@Positive(message = "Land area must be a positive number")
	@NotNull
	private BigDecimal landArea;

	public void updateLand(Land land) {
		this.estate = land.getEstate();
		this.address = land.getAddress();
		this.landArea = land.getLandArea();
	}

	

}
