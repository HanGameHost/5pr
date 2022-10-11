package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Sotrudnik{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Sotrudnik() {

    }



    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String username,password,name,surname,middlename;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int passportseries,passportnumber,phonenumber;

    public void setDuty(Duty duty) {
        this.duty = duty;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Duty duty;
    public void setUsername(String username) {
        this.username = username;
    }

    public Duty getDuty() {
        return duty;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





    public Sotrudnik(String username, String password, String name, String surname, String middlename, int passportseries, int passportnumber, int phonenumber, Duty duty,  Collection<Systemrepodting> tenants) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.passportseries = passportseries;
        this.passportnumber = passportnumber;
        this.phonenumber = phonenumber;
        this.duty = duty;
        this.tenants = tenants;
    }

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public int getPassportseries() {
        return passportseries;
    }

    public void setPassportseries(int passportseries) {
        this.passportseries = passportseries;
    }

    public int getPassportnumber() {
        return passportnumber;
    }

    public void setPassportnumber(int passportnumber) {
        this.passportnumber = passportnumber;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Collection<Systemrepodting> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Systemrepodting> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "sotrudnik", fetch = FetchType.EAGER)
    private Collection<Systemrepodting> tenants;
}
