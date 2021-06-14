package tech.norkunaite.estate.embeddables;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Address {
	
	private String districtMunicipality;
	
	private String town;
	
	private String microdistrict;
	
	private String street;

}
