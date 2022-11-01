package guru.springframework.petclinicproject.services.springdatajpa;

import guru.springframework.petclinicproject.model.Owner;
import guru.springframework.petclinicproject.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
  @Mock
  OwnerRepository ownerRepository;
  
  @InjectMocks
  OwnerSDJpaService service;
  
  Owner testOwner;
  final long id = 1L;
  final String firstName = "John";
  final String lastName = "Smith";
  final String address = "123 Test Road";
  final String city = "Testville";
  final String number = "0123456789";
  
  @BeforeEach
  void setUp() {
    testOwner = Owner.builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .address(address)
        .city(city)
        .telephone(number)
        .build();
  }
  
  @Test
  void findAll() {
    when(ownerRepository.findAll()).thenReturn(Set.of(testOwner));
    assertThat(service).returns(Set.of(testOwner), OwnerSDJpaService::findAll);
  }
  
  @Test
  void findById() {
    when(ownerRepository.findById(any())).thenReturn(Optional.of(testOwner));
    assertThat(service.findById(id)).isEqualTo(testOwner);
  }
  
  @Test
  void findByIdNotFound() {
    when(ownerRepository.findById(any())).thenReturn(Optional.empty());
    assertNull(service.findById(id));
  }
  
  @Test
  void save() {
    when(ownerRepository.save(any())).thenReturn(testOwner);
    assertThat(service.save(testOwner)).isEqualTo(testOwner);
    verify(ownerRepository).save(any());
  }
  
  @Test
  void delete() {
    service.delete(testOwner);
    verify(ownerRepository).delete(any());
  }
  
  @Test
  void deleteById() {
    service.deleteById(id);
    verify(ownerRepository).deleteById(any());
  }
  
  @Test
  void findByLastName() {
    when(ownerRepository.findByLastName(any())).thenReturn(testOwner);
    assertThat(service.findByLastName(lastName)).isEqualTo(testOwner);
  }
}