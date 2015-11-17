package com.casoc.demo.website.admin.usermanage;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
@Secured({"ROLE_SUPER"})
public class AdminUserManageController {

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String listUsers() {
        return "admin/admin";
    }
}
