package robson.jake.thebatmanapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import robson.jake.thebatmanapi.model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
