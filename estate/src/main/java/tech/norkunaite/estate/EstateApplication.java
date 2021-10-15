package tech.norkunaite.estate;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tech.norkunaite.estate.dto.SignUpRequest;
import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.repository.LandRepository;
import tech.norkunaite.estate.service.AuthService;

@SpringBootApplication
public class EstateApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstateApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner demo(LandRepository landRepo, AuthService authService) {
//		return (args) -> {
//
//			landRepo.save(new Land(1l, new Estate(Action.BUY, new BigDecimal(5), "puiki grycia"),
//					new Address("Vilniaus m", "Vilnius", "rasos", "rasu g"), new BigDecimal(5)));
//			
//			authService.signup(new SignUpRequest("test", "test", "test"));
//
//		};
//	}

}
