package org.projet.BLL.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name= "services")
public class Service {
    private static int AUTO_ID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int serviceID;

    @Column(unique=true)
    private String name;

    @ManyToMany(mappedBy = "services")
    private List<Bank> banks = new ArrayList<>();

    //Constructors
    public Service() {}

    public Service(int serviceID, String name) {
        this.serviceID = serviceID;
        this.name = name;
    }
    public Service(String name) {
        this.serviceID = AUTO_ID++;
        this.name = name;
    }
//Setters & Getters
    public int getServiceID() {
        return serviceID;
    }
    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Bank> getBanks() {
        return banks;
    }
    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
//Methods to manage banks
    public void addBank(Bank bank) {
        banks.add(bank);
        bank.getService().add(this);
    }
    public void removeBank(Bank bank) {
        banks.remove(bank);
        bank.getService().remove(this);
    }
    //ToString method
    @Override
    public String toString() {
        return "Service{" + "serviceID=" + serviceID + ", name=" + name + '}';
    }
}
