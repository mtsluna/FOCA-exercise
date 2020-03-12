package ml.corp.main.services;

import java.util.ArrayList;
import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import ml.corp.main.entities.SuperHero;

@Service
public class SuperHeroService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private StatsService statsService;

	private final String URL = "https://superheroapi.com/api/999342417127663";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public SuperHero searchByName(String name) throws Exception {

		try {

			ResponseEntity<HashMap> response = restTemplate.exchange(URL + "/search/" + name, HttpMethod.GET,
					getCommonHeaders(), HashMap.class);
			if (response.getStatusCode() == HttpStatus.OK && !response.getBody().containsKey("error")) {
				
				SuperHero hero = new ObjectMapper().convertValue(
						((ArrayList<SuperHero>) response.getBody().get("results")).get(0), SuperHero.class);
				SuperHero heroTransformed = modelMapper.map(hero, SuperHero.class);
				
				if(heroTransformed.getId() == 0) {
					throw new Exception("hero not found");}
								
				//Save stats
				statsService.saveStats(heroTransformed.getId());
				
				return heroTransformed;
				
			} else {
				
				throw new Exception("hero not found");
				
			}

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	public SuperHero searchById(int id) throws Exception {

		try {

			ResponseEntity<SuperHero> response = restTemplate.exchange(URL + "/" + id, HttpMethod.GET,
					getCommonHeaders(), SuperHero.class);
			if (response.getStatusCode() == HttpStatus.OK) {
								
				if(response.getBody().getId() == 0) 
					throw new Exception("hero not found");
				
				//Save stats
				statsService.saveStats(response.getBody().getId());
				
				return response.getBody();
				
			} else {
				throw new Exception("Invalid petition");
			}

		} catch (Exception e) {

			throw new Exception(e.getMessage());

		}

	}

	public HttpEntity<MultiValueMap<String, Object>> getCommonHeaders() {
		HttpHeaders headers = new HttpHeaders();
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return new HttpEntity<>(map, headers);
	}

}
