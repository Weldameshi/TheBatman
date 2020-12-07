package robson.jake.thebatmanapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import robson.jake.thebatmanapi.model.Tech;

public interface TechRepository extends MongoRepository<Tech, String>{

}
