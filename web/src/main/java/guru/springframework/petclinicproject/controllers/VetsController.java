package guru.springframework.petclinicproject.controllers;

import guru.springframework.petclinicproject.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class VetsController {
  private final VetService vetService;
  
  public VetsController(VetService vetService) {
    this.vetService = vetService;
  }
  
  @RequestMapping({"/vets", "/vets/index", "/vets/index.html", "/vets.html"})
  public String listVets(Model model) {
    log.debug("Processing vets...");
    model.addAttribute("vets", vetService.findAll());
    return "vets/index";
  }
}
