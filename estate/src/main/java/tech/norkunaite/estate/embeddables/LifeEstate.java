package tech.norkunaite.estate.embeddables;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LifeEstate {
	
	private int bedroom;
	
	private int floor;
	
	//aukstu kiekis
	private int maxFloor;

}
