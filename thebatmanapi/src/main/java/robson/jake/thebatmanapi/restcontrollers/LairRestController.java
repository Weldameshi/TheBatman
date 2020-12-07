package robson.jake.thebatmanapi.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.Lair;
import robson.jake.thebatmanapi.repository.LairRepository;

@RestController
@RequestMapping("/lair")
public class LairRestController{
	
	@Autowired
	private LairRepository lairRepository;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String createPersonEntry(@RequestBody Lair lair) {
		lairRepository.save(lair);
		return lair.get_id();
		
	}
	@RequestMapping(path="", method=RequestMethod.PATCH)
	public String updatePersonEntry(@RequestBody Lair lair) {
		lairRepository.deleteById(lair.get_id());
		lairRepository.save(lair);
		return lair.get_id();
		
	}
	
	@RequestMapping(path="" , method=RequestMethod.GET)
	public List<Lair> findAll(){
		return lairRepository.findAll();
	}
	@RequestMapping(path="/{id}" , method=RequestMethod.GET)
	public Optional<Lair> findById(@PathVariable String id){
		return lairRepository.findById(id);
	}
	@RequestMapping(path="/{id}" , method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id){
		lairRepository.deleteById(id);
	}
}