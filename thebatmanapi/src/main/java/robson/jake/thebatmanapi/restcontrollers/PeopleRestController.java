package robson.jake.thebatmanapi.restcontrollers;

import java.util.List;
import java.util.Optional;

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

import com.fasterxml.jackson.annotation.JsonView;

import robson.jake.thebatmanapi.MyViews;
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
		peopleRepository.save(person);
		return person.get_id();
	}

	@RequestMapping(path="" , method=RequestMethod.GET)
	@JsonView(MyViews.PersonView.class)
	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	@JsonView(MyViews.PersonView.class)
	public Person findById(@PathVariable String id){
		return peopleRepository.findById(id).get();
	}
	@GetMapping(path = "/searchByAilias/{searchText}")
	@JsonView(MyViews.PersonView.class)
	public List<Person> searchByAilias(@PathVariable String searchText){
		return peopleRepository.queryByAiliasLike("%" + searchText + "%");
	}
	@GetMapping(path= "/searchByClassification/{searchText}")
	@JsonView(MyViews.PersonView.class)
	public List<Person> searchByClassification(@PathVariable String searchText){
		return peopleRepository.findByClassificationLike("%" + searchText + "%");
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		peopleRepository.deleteById(id);
	}
	
	@PutMapping("/addLair/{personId}/{lairId}")
	@Transactional
	public void addLairPersonRelationship(@PathVariable String personId, @PathVariable String lairId) {
		Person p = findById(personId);
		Lair l = lairRest.findById(lairId);
		p.getLairs().add(l);
		updatePersonEntry(p);
	}
	@PutMapping("/addVehicle/{personId}/{vehicleId}")
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	@Transactional
	public void addVehiclePersonRelationship(@PathVariable String personId, @PathVariable String vehicleId) {
		Person p = peopleRepository.findById(personId).get();
		System.out.println(p.get_id());
		Vehicle v = vehicleRest.findById(vehicleId);
		v.setPerson(p);
		vehicleRest.updateVehicleEntry(v);
	}
	
}