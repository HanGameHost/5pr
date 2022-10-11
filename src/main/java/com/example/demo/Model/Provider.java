package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")

    private String name;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int  connectionspeed,price;

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

    public int getConnectionspeed() {
        return connectionspeed;
    }

    public void setConnectionspeed(int connectionspeed) {
        this.connectionspeed = connectionspeed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Collection<Server> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Server> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "provider", fetch = FetchType.EAGER)
    private Collection<Server> tenants;

}
