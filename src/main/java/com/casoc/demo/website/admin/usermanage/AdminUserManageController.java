package com.casoc.demo.website.admin.usermanage;

import com.casoc.demo.entity.User;
import com.casoc.demo.website.admin.usermanage.service.AdminUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@Secured({"ROLE_SUPER"})
public class AdminUserManageController {

    @Autowired
    private AdminUserManageService adminUserManageService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(Map<String, List<User>> map) {
        map.put("users", adminUserManageService.getAllUsers());
        return "admin/userManage/index";
    }

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String show(Map<String, User> map, @PathVariable String username) {
        map.put("user", adminUserManageService.findUserByUserName(username));
        return "admin/userManage/show";
    }

    @RequestMapping(value = "/user/{username}/edit", method = RequestMethod.GET)
    public String edit(Map<String, User> map, @PathVariable String username) {
        map.put("user", adminUserManageService.findUserByUserName(username));
        return "admin/userManage/edit";
    }

    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newPage(Map<String, User> map) {
        map.put("user", new User());
        return "admin/userManage/new";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String create(Map<String, List<User>> map, User user) {
        adminUserManageService.createUser(user);
        return index(map);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public String update(Map<String, User> map, User user) {
        adminUserManageService.updateUser(user);
        return show(map, user.getUsername());
    }

    @RequestMapping(value = "/user/{username}/delete", method = RequestMethod.GET)
    public String delete(Map<String, List<User>> map, @PathVariable String username) {
        adminUserManageService.deleteUserByUserName(username);
        return index(map);
    }

    @RequestMapping(value = "/users.pdf", method = RequestMethod.GET)
    public ResponseEntity<String> downloadUsersPdf() {
        return adminUserManageService.getUsersPdf();
    }
}
