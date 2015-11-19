package com.casoc.demo.website.admin.usermanage.service;

import com.casoc.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserManageService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<User> getAllUsers() {
        return hibernateTemplate.find("from User user");
    }

    public List<User> getAllEnabledUsers() {
        return hibernateTemplate.find("from User user where user.enabled = '1'");
    }

    public User findUserByUserName(String username) {
        return (User) hibernateTemplate.find("from User user where user.enabled = ?", username).get(0);
    }

    public void createUser(User user) {
        user.setPassword(User.DEFAULT_PASSWORD);
        hibernateTemplate.save(user);
    }

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }

    public void deleteUser(User user) {
        hibernateTemplate.delete(user);
    }

    public void deleteUserByUserName(String username) {
        deleteUser(findUserByUserName(username));
    }

}
