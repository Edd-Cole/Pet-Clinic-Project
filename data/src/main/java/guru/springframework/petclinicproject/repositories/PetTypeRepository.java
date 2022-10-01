package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
