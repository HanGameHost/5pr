package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Accountingreport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int efficency;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")

    private String action;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Systemrepodting systemreporting;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEfficency() {
        return efficency;
    }

    public void setEfficency(int efficency) {
        this.efficency = efficency;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Systemrepodting getSystemreporting() {
        return systemreporting;
    }

    public void setSystemreporting(Systemrepodting systemreporting) {
        this.systemreporting = systemreporting;
    }

    public Transaction getTrancation() {
        return trancation;
    }

    public void setTrancation(Transaction trancation) {
        this.trancation = trancation;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Transaction trancation;
}
