package tech.norkunaite.estate.sevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.repository.LandRepository;
import tech.norkunaite.estate.service.LandService;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class LandServiceTest {

	@MockBean
	private LandRepository landRepository;

	@InjectMocks
	private LandService landService;

	@Test
	public void shouldReturnAllLands() {

		Collection<Land> landList = new ArrayList<Land>();
		landList.add(new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12)));
		landList.add(new Land(2l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas Vilniaus rajone"),
				new Address("Vilniaus rajonas", "Nemezis", "Nemezis", "Parko"), new BigDecimal(12)));

		when(landRepository.findAll()).thenReturn(landList);

		Collection<Land> expected = landService.returnAllLands();
		verify(landRepository, times(1).description("Method should call all elements returning method from repository once")).findAll();
		assertEquals(expected, landList, "Method should retrieve all lands from repository");

	}

	@Test
	public void whenSaveLand_shouldReturnLand() {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));
		when(landRepository.save(ArgumentMatchers.any(Land.class))).thenReturn(land);

		Land expected = landService.createLand(land);

		verify(landRepository, times(1).description("Method should save in repository once"))
				.save(ArgumentMatchers.any(Land.class));
		assertEquals(expected, land, "Method should save the same object");

	}

	@Test
	public void whenGivenId_shouldDeleteLand() {
		Long id = 1l;
		landService.deleteById(id);
		verify(landRepository, times(1).description("Method should delete from repository once")).deleteById(id);
	}

	@Test
	public void whenGivenId_shouldReturnLand() {
		Long id = 1l;
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));

		when(landRepository.findById(id)).thenReturn(Optional.of(land));
		Land expected = landService.getLandById(id);

		verify(landRepository, times(1).description("Method should call one element by id returning method once")).findById(id);
		assertEquals(expected, land, "Method should retrive an element from repository");
	}

	@Test
	public void whenGivenId_shouldUpdateLand() {
		Long id = 1l;
		Land landFromDb = new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));
		Land updatedLand = new Land(1l, new Estate(Action.BUY, new BigDecimal(30000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));

		when(landRepository.findById(id)).thenReturn(Optional.of(landFromDb));

		Land expected = landService.updateLand(id, updatedLand);

		verify(landRepository, times(1).description("Method should find element in repository")).findById(id);
		verify(landRepository, times(1).description("Method should should save updated entity"))
				.save(ArgumentMatchers.any(Land.class));

		assertEquals(expected, landFromDb, "Method should return updated land");

	}

}
