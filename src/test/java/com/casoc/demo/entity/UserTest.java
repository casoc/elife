package com.casoc.demo.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-unit-test.xml"})
public class UserTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private User user;

    @Test
    @Transactional(value = "hibernateTransactionManager", readOnly = true)
    public void shouldLoadAuthoritiesWhichUserHave() {
        User user = hibernateTemplate.load(User.class, 1);
        Authority authority = hibernateTemplate.load(Authority.class, 1);
        assertFalse(user.getAuthorities().isEmpty());
        assertTrue(user.getAuthorities().contains(authority));
    }

    @Test
    public void shouldFindOnlyOneUserByUsername() {
        jdbcTemplate.query("SELECT id, username, password, enabled FROM users WHERE username = ?", new Object[]{"super"}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                user.setId(resultSet.getInt(1));
            }
        });
        assertThat(user.getId(), is(1));
        assertThat(user.getUsername(), is("super"));
    }
}