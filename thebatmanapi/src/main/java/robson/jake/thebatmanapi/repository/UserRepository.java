package robson.jake.thebatmanapi.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import robson.jake.thebatmanapi.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
