package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
