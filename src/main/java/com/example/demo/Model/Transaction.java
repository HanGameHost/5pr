package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int totalnumberofoperation;
    @OneToMany(mappedBy = "trancation", fetch = FetchType.EAGER)
    private Collection<Accountingreport> tenants;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalnumberofoperation() {
        return totalnumberofoperation;
    }

    public void setTotalnumberofoperation(int totalnumberofoperation) {
        this.totalnumberofoperation = totalnumberofoperation;
    }

    public Collection<Accountingreport> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Accountingreport> tenants) {
        this.tenants = tenants;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private User user;
}
