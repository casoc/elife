package com.casoc.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoUserDetailService implements UserDetailsService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String FIND_USER_BY_USER_NAEM = "SELECT * FROM users WHERE username = ?";

    @Transactional(value = "jdbcTransactionManager", readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return jdbcTemplate.queryForObject(FIND_USER_BY_USER_NAEM, new Object[] {s}, User.class);
    }

}
