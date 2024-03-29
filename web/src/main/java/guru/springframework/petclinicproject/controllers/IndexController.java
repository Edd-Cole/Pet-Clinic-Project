package guru.springframework.petclinicproject.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class IndexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        log.debug("Index controller active");
        return "index";
    }

    @RequestMapping("/oops")
    public String errorButton() {
        log.debug("Error controller active");
        return "notImplemented";
    }
}
