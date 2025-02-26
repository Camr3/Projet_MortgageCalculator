package org.projet.DAL;

import org.projet.BLL.Model.Bank;
import org.projet.BLL.Model.Service;
import org.projet.DL.InMemory_DB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InMemory_ServiceDAO implements IService{
    InMemory_DB datastore;

    public InMemory_ServiceDAO() {
        this.datastore = InMemory_DB.getInstance();
    }

    public List<Bank> fetchBanksByService(String nameService){
        List<Bank> banks =  new ArrayList<>();
        Service serviceTrouve = null;
        for(Service service : datastore.getServices()){
            if(service.getName().equals(nameService)){
                serviceTrouve = service;
            }
        }
        if(serviceTrouve != null){
            banks = serviceTrouve.getBanks();

        }
        return banks;

    }

}
