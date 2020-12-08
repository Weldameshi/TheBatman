package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import robson.jake.thebatmanapi.model.Lair;

public interface LairRepository extends JpaRepository<Lair, String>{

	List<Lair> findByNameLike(String searchText);
	
	@Query("SELECT l FROM Lair l Where l.name LIKE :searchText")
	List<Lair> queryByNameLike(@Param("searchText") String searchText);

}
