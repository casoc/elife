package com.casoc.demo.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-unit-test.xml" })
public class AuthorityTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    @Transactional("hibernateTransactionManager")
    public void shouldLoadUsersWhichHaveAuthority() {
        Authority authority = hibernateTemplate.load(Authority.class, 1);
        User user = hibernateTemplate.load(User.class, 1);
        assertFalse(authority.getUsers().isEmpty());
        assertTrue(authority.getUsers().contains(user));
    }

}