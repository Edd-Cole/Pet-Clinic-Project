package guru.springframework.petclinicproject.services.map;

import guru.springframework.petclinicproject.model.Owner;
import guru.springframework.petclinicproject.model.Pet;
import guru.springframework.petclinicproject.model.PetType;
import guru.springframework.petclinicproject.services.PetService;
import guru.springframework.petclinicproject.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerServiceMapTest {
  
  OwnerServiceMap ownerServiceMap;
  PetTypeService petTypeServiceMock = mock(PetTypeService.class);
  PetService petServiceMock = mock(PetService.class);
  
  Owner owner = new Owner();
  Long id = 1L;
  String lastName = "Cooper";
  
  
  @BeforeEach
  public void setUp() {
    ownerServiceMap = new OwnerServiceMap(petTypeServiceMock, petServiceMock);
    owner.setId(id);
    owner.setLastName(lastName);
    ownerServiceMap.save(owner);
  }
  
  @Test
  void findAll() {
    assertThat(ownerServiceMap.findAll())
        .isEqualTo(Set.of(owner));
  }
  
  @Test
  void deleteById() {
    ownerServiceMap.deleteById(id);
    assertThat(ownerServiceMap.findAll())
        .returns(false, owners -> owners.contains(owner));
  }
  
  @Test
  void delete() {
    ownerServiceMap.delete(owner);
    assertThat(ownerServiceMap.findAll())
        .returns(false, owners -> owners.contains(owner));
  }
  
  @Test
  void save() {
    ownerServiceMap.deleteById(id);
    
    PetType petType = new PetType();
    petType.setName("Dog");
    petType.setId(id);
    
    Pet pet = new Pet();
    pet.setPetType(petType);
    pet.setName("Rocky");
    pet.setVisits(new HashSet<>());
    pet.setBirthDate(LocalDate.of(2020, 1, 1));
    pet.setOwner(owner);
    owner.setPets(Set.of(pet));
    
    when(petServiceMock.save(any())).thenReturn(pet);
    when(petTypeServiceMock.save(any())).thenReturn(petType);
    
    ownerServiceMap.save(owner);
    
    assertThat(ownerServiceMap.findAll()).isEqualTo(Set.of(owner));
    verify(petServiceMock, times(1)).save(pet);
    verify(petTypeServiceMock, times(1)).save(petType);
  }
  
  @Test
  void findById() {
    assertThat(ownerServiceMap.findById(id))
        .isEqualTo(owner);
  }
  
  @Test
  void findByLastName() {
    assertThat(ownerServiceMap.findByLastName(lastName))
        .isEqualTo(owner);
  }
}