package nl.plaatsoft.cyber.CyberServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.plaatsoft.cyber.CyberServer.Model.User;
import nl.plaatsoft.cyber.CyberServer.Model.UserRepository;

@Controller    
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired 
	private UserRepository userRepository;

	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
    public @ResponseBody User getUser(@RequestParam(value="id", defaultValue="1") String id) {
		// This returns a JSON or XML with the users
		return userRepository.findById(Integer.parseInt(id));
    }
}