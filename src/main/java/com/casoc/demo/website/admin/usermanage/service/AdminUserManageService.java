package com.casoc.demo.website.admin.usermanage.service;

import com.casoc.demo.common.FreeMarkerUtil;
import com.casoc.demo.entity.User;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ch.lambdaj.Lambda.forEach;

@Service
public class AdminUserManageService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<User> getAllUsers() {
        return hibernateTemplate.find("from User user");
    }

    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public List<User> getAllUsersWithAuthorities() {
        List<User> allUsers = getAllUsers();
        forEach(allUsers).loadAuthorities();
        return allUsers;
    }

    public List<User> getAllEnabledUsers() {
        return hibernateTemplate.find("from User user where user.enabled = '1'");
    }

    public User findUserByUserName(String username) {
        return (User) hibernateTemplate.find("from User user where user.username = ?", username).get(0);
    }

    public void createUser(User user) {
        user.setPassword(User.DEFAULT_PASSWORD);
        hibernateTemplate.save(user);
    }

    public void updateUser(User user) {
        user.setPassword(User.DEFAULT_PASSWORD);
        hibernateTemplate.update(user);
    }

    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    public void deleteUserByUserName(String username) {
        deleteUser(findUserByUserName(username));
    }

    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public ResponseEntity<String> getUsersPdf() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "users.html");
        headers.setContentType(MediaType.TEXT_HTML);
        try {
            Template template = FreeMarkerUtil.getTemplate("users.ftl");
            Map<String, List<User>> map = new HashMap<String, List<User>>();
            map.put("users", getAllUsersWithAuthorities());
            return new ResponseEntity<String>(FreeMarkerUtil.getHtml(template, map), headers, HttpStatus.CREATED);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return null;
    }

}
