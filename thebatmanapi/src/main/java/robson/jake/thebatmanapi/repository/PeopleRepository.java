package robson.jake.thebatmanapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import robson.jake.thebatmanapi.model.Person;

public interface PeopleRepository extends JpaRepository<Person, String>{
	List<Person> findByAiliasLike(String searchText);
	
	@Query("SELECT l FROM Lair l Where l.name LIKE :searchText")
	List<Person> queryByAiliasLike(@Param("searchText") String searchText);
}
