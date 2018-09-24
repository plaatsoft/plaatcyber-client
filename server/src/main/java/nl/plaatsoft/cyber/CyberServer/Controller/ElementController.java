package nl.plaatsoft.cyber.CyberServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import nl.plaatsoft.cyber.CyberServer.Model.Element;
import nl.plaatsoft.cyber.CyberServer.Model.ElementRepository;

@Controller    
@RequestMapping(path="/element")
public class ElementController {
	
	@Autowired 
	private ElementRepository elementRepository;

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Element> getAllElements() {
		
		// This returns a JSON or XML with the users
		return elementRepository.findAll();
	}
}