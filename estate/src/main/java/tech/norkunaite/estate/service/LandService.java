package tech.norkunaite.estate.service;

import java.util.Collection;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.repository.LandRepository;

@Service
public class LandService {

	@Autowired
	private LandRepository landRepository;

	public Collection<Land> returnAllLands() {
		return (Collection<Land>) landRepository.findAll();
	}

	public Land createLand(Land land) {
		return landRepository.save(land);
	}
	
	public void deleteById(Long id) {
		landRepository.deleteById(id);
	}
	
	public Land getLandById(Long id) {
		return landRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no land with id: "+ id));
	}
	
	public Land updateLand(Long id, Land updatedLand) {
		Land landFromDB=landRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no land with such id"));
		landFromDB.updateLand(updatedLand);
		landRepository.save(landFromDB);
		return landFromDB;
	}

}
