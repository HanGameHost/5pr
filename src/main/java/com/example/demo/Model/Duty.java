package com.example.demo.Model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Duty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getNameDuty() {
        return nameDuty;
    }

    public void setNameDuty(String nameDuty) {
        this.nameDuty = nameDuty;
    }

    private String nameDuty;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Access access;

    public Collection<Sotrudnik> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Sotrudnik> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "duty", fetch = FetchType.EAGER)
    private Collection<Sotrudnik> tenants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Jobtitle getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(Jobtitle jobtitle) {
        this.jobtitle = jobtitle;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Jobtitle jobtitle;
}
