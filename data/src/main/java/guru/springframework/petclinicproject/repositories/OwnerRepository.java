package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
