package com.example.demo.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String levelaccess;

    public Collection<Duty> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Duty> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "access", fetch = FetchType.EAGER)
    private Collection<Duty> tenants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevelaccess() {
        return levelaccess;
    }

    public void setLevelaccess(String levelaccess) {
        this.levelaccess = levelaccess;
    }



}
