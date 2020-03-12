package ml.corp.main.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ml.corp.main.entities.SuperHero;
import ml.corp.main.errors.Error;
import ml.corp.main.services.SuperHeroService;

@RestController
@CrossOrigin(origins = "*")
public class SuperHeroController {

	@Autowired
	private SuperHeroService superHeroService;

	@GetMapping(path = "api/search/{name}")
	public ResponseEntity<Object> getByName(@PathVariable String name) {
		
		try {

			SuperHero hero = this.superHeroService.searchByName(name);
			return ResponseEntity.status(HttpStatus.OK).body(hero);

		} catch (Exception e) {

			return Error.getErrorMessage(e.getMessage());

		}
		
	}

	@GetMapping(path = "api/hero/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {

		try {

			SuperHero hero = this.superHeroService.searchById(id);
			return ResponseEntity.status(HttpStatus.OK).body(hero);

		} catch (Exception e) {

			return Error.getErrorMessage(e.getMessage());

		}

	}

}
