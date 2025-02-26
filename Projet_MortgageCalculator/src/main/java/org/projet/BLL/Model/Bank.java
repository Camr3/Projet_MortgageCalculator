package org.projet.BLL.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name= "banks")
public class Bank {
    private static int AUTO_ID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int code;
    @Column(unique=true)
    private String name;

    private double interestRate;
    private double insuranceRate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "bank_services",
            joinColumns = @JoinColumn(name = "bank_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )

    private List<Service> services = new ArrayList<>();

//Constructors
    public Bank() {}

    public Bank(int code, String name, double interestRate, double insuranceRate) {
        this.code = code;
        this.name = name;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
    }
    public Bank(String name, double interestRate, double insuranceRate) {
        this.code = AUTO_ID++;
        this.name = name;
        this.interestRate = interestRate;
        this.insuranceRate = insuranceRate;
    }
    //Getters and Setters
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getInsuranceRate() {
        return insuranceRate;
    }
    public void setInsuranceRate(double insuranceRate) {
        this.insuranceRate = insuranceRate;
    }



    public List<Service> getService() {
        return services;
    }
    public void setService(List<Service> services) {
        this.services = services;
    }

    //Methods to manage services
    public void addService(Service service) {
        services.add(service);
        service.getBanks().add(this);
    }
    public void removeService(Service service) {
        services.remove(service);
        service.getBanks().remove(this);
    }

    //toString method
    @Override
    public String toString() {
        return "Bank{" + "code=" + code + ", name=" + name + ", interestRate=" + interestRate + ", insuranceRate=" + insuranceRate + '}';
    }

}
