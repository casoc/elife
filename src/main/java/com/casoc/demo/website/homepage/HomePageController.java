package com.casoc.demo.website.homepage;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured({"ROLE_ADVISER", "ROLE_SUPER"})
public class HomePageController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "homepage/index";
    }

}
