package robson.jake.thebatmanapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import robson.jake.thebatmanapi.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String>{

	List<Vehicle> findByNameLike(String searchText);
	
	@Query("SELECT l FROM Lair l Where l.name LIKE :searchText")
	List<Vehicle> queryByNameLike(@Param("searchText") String searchText);
}
