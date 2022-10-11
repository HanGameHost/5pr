package com.example.demo.Model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
public class Server {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Заполните поле")
    @Size(min = 2, max = 20, message = "Размер: 2-50")
    private String ipaddress, energyconsumption;;
    @NotNull
    @Min(value = 0, message = "Минимальное: 1")
    private int physicaladdress;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Protection protection;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    private Provider provider;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public int getPhysicaladdress() {
        return physicaladdress;
    }

    public void setPhysicaladdress(int physicaladdress) {
        this.physicaladdress = physicaladdress;
    }

    public String getEnergyconsumption() {
        return energyconsumption;
    }

    public void setEnergyconsumption(String energyconsumption) {
        this.energyconsumption = energyconsumption;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection protection) {
        this.protection = protection;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Collection<Systemrepodting> getTenants() {
        return tenants;
    }

    public void setTenants(Collection<Systemrepodting> tenants) {
        this.tenants = tenants;
    }

    @OneToMany(mappedBy = "server", fetch = FetchType.EAGER)
    private Collection<Systemrepodting> tenants;


}
