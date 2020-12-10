package robson.jake.thebatmanapi.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.Lair;
import robson.jake.thebatmanapi.model.Vehicle;
import robson.jake.thebatmanapi.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleRestController{
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String createPersonEntry(@RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return vehicle.get_id();
		
	}
	
	@RequestMapping(path="", method=RequestMethod.PATCH)
	@Transactional
	public String updateVehicleEntry(@RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
		return vehicle.get_id();
		
	}
	
	@RequestMapping(path="" , method=RequestMethod.GET)
	public List<Vehicle> findAll(){
		return vehicleRepository.findAll();
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	public Vehicle findById(@PathVariable String id){
		return vehicleRepository.findById(id).get();
	}
	@GetMapping(path = "/searchByName/{searchText}")
	public List<Vehicle> searchByName(@PathVariable String searchText){
		return vehicleRepository.queryByNameLike("%" + searchText + "%");
	}
	@GetMapping(path= "/searchByMph/{mph}")
	public List<Vehicle> searchByMph(@PathVariable int mph){
		return vehicleRepository.findByMphIsGreaterThanEqual(mph);
	}
	
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		vehicleRepository.deleteById(id);
	}
}
