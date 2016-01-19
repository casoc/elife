package com.casoc.demo.security.service;

import com.casoc.demo.entity.User;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
public class DemoUserDetailService implements UserDetailsService {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private ReloadableResourceBundleMessageSource myResource;

    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<User> users = hibernateTemplate.find("from User user where user.username = ?", s);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException(myResource.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", null, Locale.getDefault()));
        }
        User loginUser = users.get(0);
        Hibernate.initialize(loginUser.getAuthorities());
        return loginUser;
    }

}
