package tech.norkunaite.estate.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import tech.norkunaite.estate.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
