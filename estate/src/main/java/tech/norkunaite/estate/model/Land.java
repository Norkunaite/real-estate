package tech.norkunaite.estate.model;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private Estate estate;
	
	@Embedded
	private Address address;
	
	private BigDecimal landArea;
	
	public void updateLand(Land land) {
		this.estate=land.getEstate();
		this.address=land.getAddress();
		this.landArea=land.getLandArea();
	}


}
