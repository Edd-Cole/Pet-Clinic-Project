package guru.springframework.petclinicproject.controllers;

import guru.springframework.petclinicproject.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
@Slf4j
public class OwnersController {
  private final OwnerService ownerService;
  
  public OwnersController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }
  
  @RequestMapping({"", "/", "/index", "/index.html"})
  public String listOwners(Model model) {
    log.debug("Processing owners...");
    model.addAttribute("owners", ownerService.findAll());
    return "owners/index";
  }
  
  @RequestMapping("/find")
  public String findOwners(Model model) {
    log.debug("Find Owners controller active");
    return "/notImplemented";
  }
}
