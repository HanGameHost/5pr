package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
public class Jobtitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String jobtitle;

    public Collection<Duty> getTenant() {
        return tenant;
    }

    public void setTenant(Collection<Duty> tenant) {
        this.tenant = tenant;
    }

    @OneToMany(mappedBy = "jobtitle", fetch = FetchType.EAGER)
    private Collection<Duty> tenant;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

}
