package tech.norkunaite.estate.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.norkunaite.estate.dto.SignUpRequest;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	private String email;
	private String password;
	
	public User(SignUpRequest signUpRequest){
		this.username=signUpRequest.getUsername();
		this.email=signUpRequest.getEmail();
	}

}
