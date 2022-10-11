package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Typeopeation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String nameoperation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameoperation() {
        return nameoperation;
    }

    public void setNameoperation(String nameoperation) {
        this.nameoperation = nameoperation;
    }

    public Collection<Operation> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Operation> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "typeoperation", fetch = FetchType.EAGER)
    private Collection<Operation> tenants;
}
