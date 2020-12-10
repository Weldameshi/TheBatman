package robson.jake.thebatmanapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import robson.jake.thebatmanapi.model.Person;

public interface PeopleRepository extends MongoRepository<Person, String>{
	
	List<Person> findByAiliasLike(String searchText);

	List<Person> findByClassificationLike(String searchText);

}
