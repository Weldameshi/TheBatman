package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import robson.jake.thebatmanapi.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String>{
	
	List<Vehicle> findByNameLike(String searchText);

	List<Vehicle> findByMphIsGreaterThanEqual(int mph);
}
