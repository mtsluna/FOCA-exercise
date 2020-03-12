package ml.corp.main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ml.corp.main.entities.Stats;
import ml.corp.main.errors.Error;
import ml.corp.main.services.StatsService;

@RestController
@RequestMapping(path = "api/stats")
@CrossOrigin(origins = "*")
public class StatsController {

	@Autowired
	private StatsService statsService;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Object> getById(@PathVariable int id) {

		try {
			
			Stats stats = this.statsService.findStatsById(id);
			return ResponseEntity.status(HttpStatus.OK).body(stats);
			
		} catch (Exception e) {

			return Error.getErrorMessage(e.getMessage());
			
		}
		
	}
	
	@GetMapping(path = "")
	public ResponseEntity<Object> getAll() {
		
		try {
			
			return ResponseEntity.status(200).body(this.statsService.findAllStats());	
			
		} catch (Exception e) {

			return Error.getErrorMessage(e.getMessage());
			
		}		
	
	}
	
}
