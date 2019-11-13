package brishko.com.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    // maps all those paths to index.html
    // value is alias for path
    @RequestMapping(path = {"", "/", "index", "index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/oups")
    public String oops() {
        return "notimplemented";
    }
}
