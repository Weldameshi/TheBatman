package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import robson.jake.thebatmanapi.model.Tech;

public interface TechRepository extends JpaRepository<Tech, String>{
	
	@Query("SELECT l FROM Tech l Where l.name LIKE :searchText")
	List<Tech> queryByNameLike(@Param("searchText") String searchText);


	List<Tech> findByName(String searchText);
}
