package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 10,message = "Размер данного поля должен быть в диапазоне от 2 до 10")
    @Pattern(regexp = "^([0-9]+)$",
            message = "Значение должно содержать цифры")
    private String quanity;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Cryptocurrency cryptocurrency;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Typeopeation typeoperation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuanity() {
        return quanity;
    }

    public void setQuanity(String quanity) {
        this.quanity = quanity;
    }

    public Cryptocurrency getCryptocurrency() {
        return cryptocurrency;
    }

    public void setCryptocurrency(Cryptocurrency cryptocurrency) {
        this.cryptocurrency = cryptocurrency;
    }

    public Typeopeation getTypeoperation() {
        return typeoperation;
    }

    public void setTypeoperation(Typeopeation typeoperation) {
        this.typeoperation = typeoperation;
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
