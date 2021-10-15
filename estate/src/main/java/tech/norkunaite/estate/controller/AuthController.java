package tech.norkunaite.estate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.norkunaite.estate.dto.AuthenticationResponse;
import tech.norkunaite.estate.dto.LoginRequest;
import tech.norkunaite.estate.dto.SignUpRequest;
import tech.norkunaite.estate.service.AuthService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/signup")
	public ResponseEntity<Object> signup(@RequestBody SignUpRequest signUpRequest) {
		authService.signup(signUpRequest);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public AuthenticationResponse login(@RequestBody LoginRequest loginRequest){
		return authService.login(loginRequest);
		

	}

}
