package guru.springframework.petclinicproject.bootstrap;

import guru.springframework.petclinicproject.model.Owner;
import guru.springframework.petclinicproject.model.Pet;
import guru.springframework.petclinicproject.model.PetType;
import guru.springframework.petclinicproject.model.Speciality;
import guru.springframework.petclinicproject.model.Vet;
import guru.springframework.petclinicproject.model.Visit;
import guru.springframework.petclinicproject.services.OwnerService;
import guru.springframework.petclinicproject.services.PetTypeService;
import guru.springframework.petclinicproject.services.SpecialityService;
import guru.springframework.petclinicproject.services.VetService;
import guru.springframework.petclinicproject.services.VisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class DataLoader implements CommandLineRunner {
  private final OwnerService ownerService;
  private final VetService vetService;
  private final PetTypeService petTypeService;
  private final SpecialityService specialityService;
  private final VisitService visitService;
  
  public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
    this.ownerService = ownerService;
    this.vetService = vetService;
    this.petTypeService = petTypeService;
    this.specialityService = specialityService;
    this.visitService = visitService;
  }
  
  @Override
  public void run(String... args) throws Exception {
    log.info("Beginning data loading");
    int count = petTypeService.findAll().size();
    if (count == 0) {
      loadData();
    }
  }
  
  private void loadData() {
    log.debug("Loading data");
    PetType dog = new PetType();
    dog.setName("Dog");
    PetType savedDogPetType = petTypeService.save(dog);
    PetType cat = new PetType();
    cat.setName("Cat");
    PetType savedCatPetType = petTypeService.save(cat);
    
    Speciality radiology = new Speciality();
    radiology.setDescription("Radiology");
    Speciality surgery = new Speciality();
    surgery.setDescription("Surgery");
    Speciality dentistry = new Speciality();
    dentistry.setDescription("Dentistry");
    
    Speciality savedRadiology = specialityService.save(radiology);
    Speciality savedSurgery = specialityService.save(surgery);
    Speciality savedDentistry = specialityService.save(dentistry);
    
    Owner owner1 = new Owner();
    owner1.setFirstName("Michael");
    owner1.setLastName("Weston");
    owner1.setAddress("123 Brickerel");
    owner1.setCity("Miami");
    owner1.setTelephone("1231231234");
    ownerService.save(owner1);
    
    Pet mikesPet = new Pet();
    mikesPet.setPetType(savedDogPetType);
    mikesPet.setOwner(owner1);
    mikesPet.setBirthDate(LocalDate.now());
    mikesPet.setName("Rosco");
    owner1.getPets().add(mikesPet);
    
    Owner owner2 = new Owner();
    owner2.setFirstName("Fiona");
    owner2.setLastName("Glenane");
    owner2.setAddress("123 Brickerel");
    owner2.setCity("Miami");
    owner2.setTelephone("1231231234");
    ownerService.save(owner2);
    
    Pet fionasCat = new Pet();
    fionasCat.setBirthDate(LocalDate.now());
    fionasCat.setPetType(savedCatPetType);
    fionasCat.setOwner(owner2);
    fionasCat.setName("Joel");
    owner2.getPets().add(fionasCat);
    
    log.info("Loaded Owners...");
  
    Visit catVisit = new Visit();
    catVisit.setDescription("Sneezy cat");
    catVisit.setDate(LocalDate.now());
    catVisit.setPet(fionasCat);
    
    Vet vet1 = new Vet();
    vet1.setFirstName("Sam");
    vet1.setLastName("Axe");
    vet1.getSpecialities().add(savedRadiology);
    vetService.save(vet1);
    
    Vet vet2 = new Vet();
    vet2.setFirstName("Jessie");
    vet2.setLastName("Porter");
    vet2.getSpecialities().add(savedSurgery);
    vetService.save(vet2);
    log.info("Loaded Vets...");
  }
}
