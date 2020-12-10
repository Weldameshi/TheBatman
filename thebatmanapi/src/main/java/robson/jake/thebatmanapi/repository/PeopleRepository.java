package robson.jake.thebatmanapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import robson.jake.thebatmanapi.model.Person;

public interface PeopleRepository extends JpaRepository<Person, String>{
	
	@Query("SELECT l FROM Person l Where l.ailias LIKE :searchText")
	List<Person> queryByAiliasLike(@Param("searchText") String searchText);

	List<Person> findByClassificationLike(String searchText);

}
