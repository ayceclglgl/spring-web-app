package ayc.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ayc.springwebapp.repositories.AuthorRepository;

@Controller
public class AuthorController {
	
	AuthorRepository authorRepo;
	
	public AuthorController(AuthorRepository authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	@RequestMapping(value="/authors")
	public String authors(Model model) {
		model.addAttribute("authors", authorRepo.findAll());
		return "authors";
	}

}
