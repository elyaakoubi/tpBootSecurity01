package ma.ensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ma.ensa.entities.Conference;
import ma.ensa.entities.ConferenceEvent;
import ma.ensa.repositories.ConfRepo;
import ma.ensa.service.ConfService;

@RestController
public class ConfController {
	
	@Autowired
	ConfService confService;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/conferences")
	public List<Conference> conferencesView() {
		return confService.findAll();
	}
	
	@GetMapping("/conferences/{id}")
	public Conference getConf(@PathVariable("id") Long id) {
		return confService.findByIdConference(id);
	}
	
	@PostMapping(value="/conferences")
	public Conference addConf(@RequestBody Conference conference)
	{
		return confService.save(conference);
	}
	
	@PutMapping("/conferences/{id}")
	public String update(@PathVariable("id") Long id,@RequestBody Conference conference) {
		Conference confrest= confService.findByIdConference(id);
		confrest.setSubject(conference.getSubject());
		confrest.setTitle(conference.getTitle());
		confService.save(confrest);
		return confrest.getTitle();
	}
	
	@DeleteMapping("/conferences/{id}")
	public String delete(@PathVariable("id") Long id)
	{
		Conference confrest= confService.findByIdConference(id);
		confService.delete(confrest);
		return "delete";
	}
	
	@GetMapping("/conferences/{id}/events")
	public List<ConferenceEvent> getEvents(@PathVariable("id") Long id) {
		return confService.findEventsById(id);
	}
	
}
