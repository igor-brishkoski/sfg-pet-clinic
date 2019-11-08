package brishko.com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VetsController {

    @GetMapping(path = {"/vets", "vets/index", "vets/index.html"})
    public String listVets() {
        return "vets/index";
    }
}
