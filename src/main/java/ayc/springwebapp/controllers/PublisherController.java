package ayc.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ayc.springwebapp.repositories.PublisherRepository;

@Controller
public class PublisherController {

	private PublisherRepository publisherRepo;
	
	public PublisherController(PublisherRepository publisherRepo) {
		this.publisherRepo = publisherRepo;
	}
	
	@RequestMapping(value = "/publishers")
	public String getBooks(Model model) {
		model.addAttribute("publishers", publisherRepo.findAll());
		return "publisher";
		
	}
}
