package robson.jake.thebatmanapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import robson.jake.thebatmanapi.model.Vehicle;

public interface VehicleRepository extends MongoRepository<Vehicle, String>{

}
