package ml.corp.main.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ml.corp.main.entities.Stats;

@Repository
public interface StatsRepository extends JpaRepository<Stats, UUID>{

	@Query("SELECT ((SELECT COUNT(*) FROM api_stats WHERE stats_hero_id = ?1)/COUNT(*))*100 FROM api_stats")
	public double averageById(int id);
	
	@Query("SELECT COUNT(*) FROM api_stats WHERE stats_hero_id = ?1")
	public int quantityById(int id);
	
	@Query("SELECT COUNT(*) AS quantity, heroId FROM api_stats GROUP BY heroId ORDER BY quantity DESC")
	public List<Object[]> obtainStats();
	
}
