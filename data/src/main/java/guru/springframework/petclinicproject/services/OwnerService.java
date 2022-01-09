package guru.springframework.petclinicproject.services;

import guru.springframework.petclinicproject.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}
