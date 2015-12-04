package com.casoc.demo.security.service;

import com.casoc.demo.entity.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoUserDetailService implements UserDetailsService {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = hibernateTemplate.find("from User user where user.username = ?", s);
        User loginUser = users.get(0);
        Hibernate.initialize(loginUser.getAuthorities());
        return loginUser;
    }

}
