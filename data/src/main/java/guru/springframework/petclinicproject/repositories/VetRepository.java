package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
