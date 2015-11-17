package com.casoc.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
public class Authority {

    @JoinColumn(referencedColumnName = "username", nullable = false, updatable = false)
    @OneToOne(optional = false, targetEntity = User.class)
    private String username;

    @Column(nullable = false, length = 50)
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
