package tech.norkunaite.estate.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tech.norkunaite.estate.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		tech.norkunaite.estate.model.User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("There is no user with username " + username));

		return new User(user.getUsername(), user.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")) );
	}

}
