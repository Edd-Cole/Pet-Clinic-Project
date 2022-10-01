package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
