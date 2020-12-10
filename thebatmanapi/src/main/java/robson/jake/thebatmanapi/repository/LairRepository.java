package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import robson.jake.thebatmanapi.model.Lair;

public interface LairRepository extends MongoRepository<Lair, String>{
	
	List<Lair> findByNameLike(String searchText);

	List<Lair> findBySqrftIsGreaterThanEqual(int sqrft);

}
