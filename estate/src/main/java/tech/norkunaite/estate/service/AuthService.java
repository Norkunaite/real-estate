package tech.norkunaite.estate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tech.norkunaite.estate.dto.AuthenticationResponse;
import tech.norkunaite.estate.dto.LoginRequest;
import tech.norkunaite.estate.dto.SignUpRequest;
import tech.norkunaite.estate.model.User;
import tech.norkunaite.estate.repository.UserRepository;
import tech.norkunaite.estate.security.JwtProvider;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	public void signup(SignUpRequest signUpRequest) {
		User user = new User(signUpRequest);
		user.setPassword(encodePassword(signUpRequest.getPassword()));

		userRepository.save(user);
	}

	public AuthenticationResponse login(LoginRequest loginRequest) {

		Authentication authention = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authention);
		return new AuthenticationResponse(jwtProvider.generateToken(authention), loginRequest.getUsername());
	}

	private String encodePassword(String password) {
		return passwordEncoder.encode(password);
	}

}
