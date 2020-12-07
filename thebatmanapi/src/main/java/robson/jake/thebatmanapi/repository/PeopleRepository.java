package robson.jake.thebatmanapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import robson.jake.thebatmanapi.model.Person;

public interface PeopleRepository extends MongoRepository<Person, String>{
	
}
