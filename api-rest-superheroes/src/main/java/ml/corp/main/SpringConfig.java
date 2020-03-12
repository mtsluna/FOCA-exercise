package ml.corp.main;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import ml.corp.main.entities.SuperHero;

@Configuration
public class SpringConfig {

	@Bean()
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean()
	public ModelMapper getModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.addMappings(new PropertyMap<SuperHero, SuperHero>() {
			@Override
			protected void configure() {
				skip(destination.getAppearance());
				skip(destination.getConnections());
				skip(destination.getPowerstats());
				skip(destination.getWork());
			}
		});
		
		return modelMapper;
	}
		
}
