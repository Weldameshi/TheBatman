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

import robson.jake.thebatmanapi.model.Tech;
import robson.jake.thebatmanapi.repository.TechRepository;

@RestController
@RequestMapping("/tech")
public class TechRestController{
	
	@Autowired
	private TechRepository techRepository;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String createPersonEntry(@RequestBody Tech tech) {
		techRepository.save(tech);
		return tech.get_id();
	}
	@RequestMapping(path="", method=RequestMethod.PATCH)
	@Transactional
	public String updatePersonEntry(@RequestBody Tech tech) {
		techRepository.deleteById(tech.get_id());
		techRepository.save(tech);
		return tech.get_id();
	}
	
	@RequestMapping(path="" , method=RequestMethod.GET)
	public List<Tech> findAll(){
		return techRepository.findAll();
	}
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	public Optional<Tech> findById(@PathVariable String id){
		return techRepository.findById(id);
	}
	@GetMapping(path = "/searchByName/{searchText}")
	public List<Tech> searchByName(@PathVariable String searchText){
		return techRepository.findByNameLike("%" + searchText + "%");
	}
	@GetMapping(path= "/searchByNameExact/{searchText}")
	public List<Tech> searchByNameExact(@PathVariable String searchText){
		return techRepository.findByName(searchText);
	}
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		techRepository.deleteById(id);
	}
}
