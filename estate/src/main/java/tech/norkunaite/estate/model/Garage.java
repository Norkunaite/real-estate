package tech.norkunaite.estate.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Building;
import tech.norkunaite.estate.embeddables.Estate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Embedded
	private Estate estate;

	@Embedded
	private Address address;

	@Embedded
	private Building building;

}
