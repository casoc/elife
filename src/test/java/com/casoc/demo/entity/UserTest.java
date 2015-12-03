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
public class UserTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public void shouldLoadAuthoritiesWhichUserHave() {
        User user = hibernateTemplate.load(User.class, 1);
        Authority authority = hibernateTemplate.load(Authority.class, 1);
        assertFalse(user.getAuthorities().isEmpty());
        assertTrue(user.getAuthorities().contains(authority));
    }
}