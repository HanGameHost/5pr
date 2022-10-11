package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Onlinewallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public String getNamewell() {
        return namewell;
    }

    public void setNamewell(String namewell) {
        this.namewell = namewell;
    }

    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String namewell;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Collection<User> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<User> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "onlinewallet", fetch = FetchType.EAGER)
    private Collection<User> tenants;
}
