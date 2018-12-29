package ayc.springwebapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ayc.springwebapp.model.Author;
import ayc.springwebapp.model.Book;
import ayc.springwebapp.model.Publisher;
import ayc.springwebapp.repositories.AuthorRepository;
import ayc.springwebapp.repositories.BookRepository;
import ayc.springwebapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	AuthorRepository authorRepo;
	BookRepository bookRepo;
	PublisherRepository publisherRepo;
	
	public DevBootstrap(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Publisher publisherDdd = new Publisher("Harper Collins", "address");
		Book ddd = new Book("Domain Dirven Design", "12345", publisherDdd);
		eric.getBooks().add(ddd);
		ddd.getAuthors().add(eric);
		authorRepo.save(eric);
		publisherRepo.save(publisherDdd);
		bookRepo.save(ddd);
		
		Author rod = new Author("Rod", "Johnson");
		Publisher publisherNoEJB = new Publisher("Worx", "address2");
		Book noEJB = new Book("J2EE Development Without EJB", "23444", publisherNoEJB);
		rod.getBooks().add(noEJB);
		authorRepo.save(rod);
		publisherRepo.save(publisherNoEJB);
		bookRepo.save(noEJB);
	}

}
