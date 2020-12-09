package robson.jake.thebatmanapi.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.Lair;
import robson.jake.thebatmanapi.model.Person;
import robson.jake.thebatmanapi.model.Vehicle;
import robson.jake.thebatmanapi.repository.PeopleRepository;


@RestController
@RequestMapping("/people")
public class PeopleRestController{
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private LairRestController lairRest;
	
	@Autowired
	private VehicleRestController vehicleRest;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String createPersonEntry(@RequestBody Person person) {
		peopleRepository.save(person);
		return person.get_id();
	}
	
	@RequestMapping(path="", method=RequestMethod.PATCH)
	@Transactional
	public String updatePersonEntry(@RequestBody Person person) {
		peopleRepository.deleteById(person.get_id());
		peopleRepository.save(person);
		return person.get_id();
	}

	@RequestMapping(path="" , method=RequestMethod.GET)
	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	public Optional<Person> findById(@PathVariable String id){
		return peopleRepository.findById(id);
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		peopleRepository.deleteById(id);
	}
	
	@PutMapping("/addLair/{personId}/{lairId}")
	public void addLairPersonRelationship(@PathVariable String personId, @PathVariable String lairId) {
		Optional<Person> p = findById(personId);
		Optional<Lair> l = lairRest.findById(lairId);
		p.get().getLairs().add(l.get());
	}
	@PutMapping("/addVehicle/{personId}/{vehicleId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@Transactional
	public void addVehiclePersonRelationship(@PathVariable String personId, @PathVariable String vehicleId) {
		Optional<Person> p = findById(personId);
		Optional<Vehicle> v = vehicleRest.findById(vehicleId);
		v.get().setPerson(p.get());
		vehicleRest.updateVehicleEntry(v.get());
	}
	
}