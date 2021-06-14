package tech.norkunaite.estate.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.norkunaite.estate.model.Land;
import tech.norkunaite.estate.service.LandService;

@RestController
@RequestMapping("/api/estates")
public class EstateController {

	@Autowired
	private LandService landService;

	/* block of land controller */
	@GetMapping("/lands")
	public ResponseEntity<Collection<Land>> getAllLands() {
		return new ResponseEntity<Collection<Land>>(landService.returnAllLands(), HttpStatus.OK);
	}

	@PostMapping("/lands")
	public ResponseEntity<Land> createLand(@RequestBody Land land) {
		return new ResponseEntity<Land>(landService.createLand(land), HttpStatus.CREATED);
	}

	@DeleteMapping("/lands/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable Long id) {
		landService.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@GetMapping("/lands/{id}")
	public ResponseEntity<Land> getLandById(@PathVariable Long id) {
		Land l=landService.getLandById(id);
		return new ResponseEntity<Land>(l, HttpStatus.OK);
	}

	@PutMapping("/lands/{id}")
	public ResponseEntity<Land> update(@PathVariable Long id, @RequestBody Land updatedLand) {
		return new ResponseEntity<Land>(landService.updateLand(id, updatedLand), HttpStatus.OK);
	}
}
