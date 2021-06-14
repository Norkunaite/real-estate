package tech.norkunaite.estate.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tech.norkunaite.estate.embeddables.Address;
import tech.norkunaite.estate.embeddables.Estate;
import tech.norkunaite.estate.enums.Action;
import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.repository.LandRepository;
import tech.norkunaite.estate.service.LandService;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)

public class EstateControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	private LandService landService;

	@MockBean
	private LandRepository landRepository;

	@Test
	public void getAllLandsTest() throws Exception {
		mockMvc.perform(get("/api/estates/lands")).andExpect(status().isOk());
		verify(landService, times(1).description("Method should call all elements retrieving method from service class")).returnAllLands();
	}

	@Test
	public void createLandTest() throws JsonProcessingException, Exception {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));
		mockMvc.perform(post("/api/estates/lands").contentType("Application/json")
				.content(objectMapper.writeValueAsString(land))).andExpect(status().isCreated());
		verify(landService, times(1).description("Method should call element creating method from service"))
				.createLand(ArgumentMatchers.any(Land.class));
	}

	@Test
	public void deleteLandByIdTest() throws Exception {
		mockMvc.perform(delete("/api/estates/lands/{id}", ArgumentMatchers.anyLong())).andExpect(status().isOk());
		verify(landService, times(1).description("Method should call element deleting method from service"))
				.deleteById(ArgumentMatchers.anyLong());

	}

	@Test
	public void GetLandByIdTest() throws Exception {
		mockMvc.perform(get("/api/estates/lands/{id}", ArgumentMatchers.anyLong())).andExpect(status().isOk());
		verify(landService, times(1).description("Method should call element retrieving by id from service"))
		.getLandById(ArgumentMatchers.anyLong());
	}

	@Test
	public void updateLandTest() throws Exception {
		Land land = new Land(1l, new Estate(Action.BUY, new BigDecimal(25000), "Sklypas nacionaliniame parke"),
				new Address("Ignalinos rajonas", "Stripeikiai", "Stripeikiai", "Muziejaus"), new BigDecimal(12));
		
		mockMvc.perform(put("/api/estates/lands/{id}", 1l).contentType("Application/json")
				.content(objectMapper.writeValueAsString(land))).andExpect(status().isOk());

		verify(landService, times(1).description("Method should call updating method from service"))
				.updateLand(ArgumentMatchers.anyLong(), ArgumentMatchers.any(Land.class));
	}

}
