package tech.norkunaite.estate.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
}