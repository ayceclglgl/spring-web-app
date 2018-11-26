package ayc.springwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ayc.springwebapp.repositories.BookRepository;

@Controller
public class BookController {

	private BookRepository bookRepo;
	
	public BookController(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
		model.addAttribute("books", bookRepo.findAll());
		return "books"; //We are just giving the view name
		
	}
}
