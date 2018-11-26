package ayc.springwebapp.repositories;

import org.springframework.data.repository.CrudRepository;

import ayc.springwebapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
