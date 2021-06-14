package tech.norkunaite.estate.embeddables;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.norkunaite.estate.enums.Action;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Estate {
	
	private Action action;
	
	private BigDecimal price;
	
	@Lob
	private String decription;

}
