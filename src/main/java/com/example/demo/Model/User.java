package com.example.demo.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String name,surname,middlename;

    public User() {

    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String username;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int passportseries,passportnumber,numberonlinewallet;

    public User(String name, String surname, String middlename, String username, String password, boolean active, Set<Role> roles, int passportseries, int passportnumber, int numberonlinewallet, Onlinewallet onlinewallet) {
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.passportseries = passportseries;
        this.passportnumber = passportnumber;
        this.numberonlinewallet = numberonlinewallet;
        this.onlinewallet = onlinewallet;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Onlinewallet onlinewallet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
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

    public int getNumberonlinewallet() {
        return numberonlinewallet;
    }

    public void setNumberonlinewallet(int numberonlinewallet) {
        this.numberonlinewallet = numberonlinewallet;
    }

    public Onlinewallet getOnlinewallet() {
        return onlinewallet;
    }

    public void setOnlinewallet(Onlinewallet onlinewallet) {
        this.onlinewallet = onlinewallet;
    }


//    public Collection<Transaction> getTenant() {
//        return tenant;
//    }
//
//    public void setTenant(Collection<Transaction> tenant) {
//        this.tenant = tenant;
//    }
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private Collection<Transaction> tenant;
}
