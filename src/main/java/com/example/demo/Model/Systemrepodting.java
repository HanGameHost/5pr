package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
public class Systemrepodting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Systemrepodting() {

    }

    public int getNumberofconnection() {
        return numberofconnection;
    }

    public void setNumberofconnection(int numberofconnection) {
        this.numberofconnection = numberofconnection;
    }

    public int getAverageonline() {
        return averageonline;
    }

    public void setAverageonline(int averageonline) {
        this.averageonline = averageonline;
    }

    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int numberofconnection,averageonline;

    public Systemrepodting(int numberofconnection, int averageonline, Server server, Sotrudnik sotrudnik, Tasks tasks, Collection<Accountingreport> tenants) {
        this.numberofconnection = numberofconnection;
        this.averageonline = averageonline;
        this.server = server;
        this.sotrudnik = sotrudnik;
        this.tasks = tasks;
        this.tenants = tenants;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Sotrudnik getSotrudnik() {
        return sotrudnik;
    }

    public void setSotrudnik(Sotrudnik sotrudnik) {
        this.sotrudnik = sotrudnik;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Server server;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Sotrudnik sotrudnik;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Tasks tasks;

    public Collection<Accountingreport> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Accountingreport> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "systemreporting", fetch = FetchType.EAGER)
    private Collection<Accountingreport> tenants;
}
