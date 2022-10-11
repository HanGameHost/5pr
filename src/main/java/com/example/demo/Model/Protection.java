package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Protection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String name, typeprotection,levelprotection;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeprotection() {
        return typeprotection;
    }

    public void setTypeprotection(String typeprotection) {
        this.typeprotection = typeprotection;
    }

    public String getLevelprotection() {
        return levelprotection;
    }

    public void setLevelprotection(String levelprotection) {
        this.levelprotection = levelprotection;
    }

    public Collection<Server> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Server> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "protection", fetch = FetchType.EAGER)
    private Collection<Server> tenants;
}
