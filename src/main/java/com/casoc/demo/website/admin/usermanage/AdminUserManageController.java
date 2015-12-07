package com.casoc.demo.website.admin.usermanage;

import com.casoc.demo.common.FreeMarkerUtil;
import com.casoc.demo.entity.User;
import com.casoc.demo.website.admin.usermanage.service.AdminUserManageService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "users.html");
        headers.setContentType(MediaType.TEXT_HTML);
        try {
            Template template = FreeMarkerUtil.getTemplate("users.ftl");
            Map<String, List<User>> map = new HashMap<String, List<User>>();
            map.put("users", adminUserManageService.getAllUsersWithAuthorities());
            return new ResponseEntity<String>(FreeMarkerUtil.getHtml(template, map), headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }
}
