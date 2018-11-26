package ayc.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ayc.springwebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
