package robson.jake.thebatmanapi.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.Person;
import robson.jake.thebatmanapi.repository.PeopleRepository;


@RestController
@RequestMapping("/people")
public class PeopleRestController{
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String createPersonEntry(@RequestBody Person person) {
		peopleRepository.save(person);
		return person.get_id();
	}
	
	@RequestMapping(path="", method=RequestMethod.PATCH)
	@Transactional
	public String updatePersonEntry(@RequestBody Person person) {
		peopleRepository.save(person);
		return person.get_id();
	}

	@RequestMapping(path="" , method=RequestMethod.GET)
	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	public Person findById(@PathVariable String id){
		return peopleRepository.findById(id).get();
	}
	@GetMapping(path = "/searchByAilias/{searchText}")
	public List<Person> searchByAilias(@PathVariable String searchText){
		return peopleRepository.findByAiliasLike(searchText);
	}
	@GetMapping(path= "/searchByClassification/{searchText}")
	public List<Person> searchByClassification(@PathVariable String searchText){
		return peopleRepository.findByClassificationLike(searchText);
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		peopleRepository.deleteById(id);
	}
	
	@PutMapping("/addLair/{personId}/{lairId}")
	@Transactional
	public void addLairPersonRelationship(@PathVariable String personId, @PathVariable String lairId) {
		Person p = findById(personId);
		p.getLairsLivedIn().add(lairId);
		updatePersonEntry(p);
	}
	@PutMapping("/addVehicle/{personId}/{vehicleId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@Transactional
	public void addVehiclePersonRelationship(@PathVariable String personId, @PathVariable String vehicleId) {
		Person p = peopleRepository.findById(personId).get();
		p.getVehiclesOwned().add(vehicleId);
		updatePersonEntry(p);
	}
	
}