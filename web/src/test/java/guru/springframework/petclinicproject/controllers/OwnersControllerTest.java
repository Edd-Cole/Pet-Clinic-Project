package guru.springframework.petclinicproject.controllers;

import guru.springframework.petclinicproject.model.Owner;
import guru.springframework.petclinicproject.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {
  
  @Mock
  OwnerService ownerService;
  
  @InjectMocks
  OwnersController ownersController;
  
  Set<Owner> owners;
  Owner owner;
  
  MockMvc mockMvc;
  
  @BeforeEach
  void setup() {
    owner = Owner.builder()
        .id(1L)
        .firstName("John")
        .lastName("Smith")
        .build();
    owners = Set.of(owner);
    mockMvc = MockMvcBuilders.standaloneSetup(ownersController).build();
  }
  
  @Test
  void listOwners() throws Exception {
    when(ownerService.findAll()).thenReturn(owners);
    
    mockMvc.perform(get("/owners"))
        .andExpect(status().isOk())
        .andExpect(view().name("owners/index"))
        .andExpect(model().attribute("owners", hasSize(owners.size())));
  }
  
  @Test
  void findOwners() throws Exception {
    mockMvc.perform(get("/owners/find"))
        .andExpect(status().isOk())
        .andExpect(view().name("/notImplemented"));
    
    verifyNoInteractions(ownerService);
  }
}