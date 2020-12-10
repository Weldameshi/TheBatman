package robson.jake.thebatmanapi.restcontrollers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import robson.jake.thebatmanapi.model.User;

@RestController
public class LoginRestControler{
	
	@RequestMapping(path="login", method=RequestMethod.POST)
	public String login(@RequestBody User user) {
		return "login";
		
	}
	
	/*
	 * @RequestMapping(path="logout" , method=RequestMethod.POST) public void
	 * findAll(HttpServletRequest request, HttpServletResponse response){
	 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	 * if (auth != null){ new SecurityContextLogoutHandler().logout(request,
	 * response, auth); } }
	 */
}