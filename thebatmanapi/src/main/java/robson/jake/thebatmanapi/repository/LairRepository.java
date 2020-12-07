package robson.jake.thebatmanapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import robson.jake.thebatmanapi.model.Lair;

public interface LairRepository extends MongoRepository<Lair, String>{

}
