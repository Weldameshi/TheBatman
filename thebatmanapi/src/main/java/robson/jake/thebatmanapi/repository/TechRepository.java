package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import robson.jake.thebatmanapi.model.Tech;

public interface TechRepository extends MongoRepository<Tech, String>{
	
	List<Tech> findByNameLike(String searchText);


	List<Tech> findByName(String searchText);
}
