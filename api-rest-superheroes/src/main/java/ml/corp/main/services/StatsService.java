package ml.corp.main.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ml.corp.main.entities.Stats;
import ml.corp.main.entities.SuperHero;
import ml.corp.main.repositories.StatsRepository;

@Service
public class StatsService {
	
	@Autowired
	private StatsRepository statsRepository;

	public Stats findStatsById(int id) throws Exception {
		
		try {
			
			Stats stats = new Stats();
			stats.setAverage(this.statsRepository.averageById(id));
			stats.setQuantity(this.statsRepository.quantityById(id));
			return stats;
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
			
		}
		
	}
	
	public List<Stats> findAllStats() throws Exception{
		
		try {
			
			List<Stats> listOfStats = new ArrayList<Stats>();
			
			for (Object [] data : this.statsRepository.obtainStats()) {
				Stats stats = new Stats();		
				System.out.println(Integer.parseInt(data[0].toString()));
				stats.setQuantity(Integer.parseInt(data[0].toString()));
				stats.setHeroId(Integer.parseInt(data[1].toString()));
				listOfStats.add(stats);
			}
			
			return listOfStats;
			
		} catch (Exception e) {

			throw new Exception(e.getMessage());
			
		}
		
	}
	
	public void saveStats(int heroId) throws Exception {
		
		try {
			
			Stats stats = new Stats();
			stats.setHeroId(heroId);
			statsRepository.save(stats);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
			
		}
		
	}
	
}
