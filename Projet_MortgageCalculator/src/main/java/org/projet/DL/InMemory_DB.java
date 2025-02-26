package org.projet.DL;

import org.projet.BLL.Model.Bank;
import org.projet.BLL.Model.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemory_DB {
    private static InMemory_DB datastore = null;
    private List<Bank> banks;
    private List<Service> services;


    private InMemory_DB() {
        Service service1 = new Service("Mortgage");
        Service service2 = new Service("Insurance");
        Service service3 = new Service("Savings account");
        Service service4 = new Service("Checking account");
        Service service5 = new Service("Credit card");

        this.services = new ArrayList<>();
        this.services.add(service1);
        this.services.add(service2);
        this.services.add(service3);
        this.services.add(service4);
        this.services.add(service5);

        Bank bank1 = new Bank("RBC", 0.05, 0.005);
        Bank bank2 = (new Bank("TD", 0.03, 0.007));
        Bank bank3 = (new Bank("Scotiabank", 0.07, 0.003));
        Bank bank4 = (new Bank("Citibank", 0.06, 0.004));
        Bank bank5 = (new Bank("Bank of America", 0.04, 0.006));

        this.banks = new ArrayList<>();
        this.banks.add(bank1);
        this.banks.add(bank2);
        this.banks.add(bank3);
        this.banks.add(bank4);
        this.banks.add(bank5);

        bank1.addService(service1);
        bank2.addService(service1);
        bank3.addService(service1);
        bank4.addService(service1);
        bank5.addService(service1);

        bank1.addService(service2);
        bank2.addService(service2);
        bank3.addService(service2);
        bank4.addService(service2);
        bank5.addService(service2);

        bank1.addService(service3);
        bank2.addService(service3);

        bank2.addService(service4);
        bank3.addService(service4);

        bank4.addService(service5);
        bank5.addService(service5);
    }

    public static InMemory_DB getInstance() {
        if (datastore == null) {
            datastore = new InMemory_DB();
        }
        return datastore;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public List<Service> getServices() {
        return services;
    }

}

