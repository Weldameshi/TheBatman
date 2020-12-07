package robson.jake.thebatmanapi.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.User;
import robson.jake.thebatmanapi.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passEnc;
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public void createPersonEntry(@RequestBody User user) {
		user.setPassword(passEnc.encode(user.getPassword()));
		userRepository.save(user);
	}

}
