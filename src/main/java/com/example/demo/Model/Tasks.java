package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String typetasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypetasks() {
        return typetasks;
    }

    public void setTypetasks(String typetasks) {
        this.typetasks = typetasks;
    }

    public Collection<Systemrepodting> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Systemrepodting> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "tasks", fetch = FetchType.EAGER)
    private Collection<Systemrepodting> tenants;
}
