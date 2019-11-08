package brishko.com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "owners")
public class OwnerController {

    @GetMapping(path = {"", "/", "/index", "/index.html"})
    public String ownerList() {
        return "owners/index";
    }
}
