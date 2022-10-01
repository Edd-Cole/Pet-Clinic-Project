package guru.springframework.petclinicproject.repositories;

import guru.springframework.petclinicproject.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
