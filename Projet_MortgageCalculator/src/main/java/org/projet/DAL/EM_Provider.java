package org.projet.DAL;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.projet.DL.BankPersistenceUnitInfo;

import java.util.HashMap;

public class EM_Provider {
    private static EM_Provider instance;

    //Best practice : One Factory for each PU
    private EntityManagerFactory factory = null;

    private EM_Provider() {
        initializeFactory_usingPUDefinedInClass();
    }


    private void initializeFactory_usingPUDefinedInClass() {
        PersistenceUnitInfo BankPersistenceUNitInfo = new BankPersistenceUnitInfo();
        this.factory = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(BankPersistenceUNitInfo, new HashMap<>());
    }

    public static EM_Provider getInstance() {
        if (instance == null)
            EM_Provider.instance = new EM_Provider();
        return EM_Provider.instance;
    }

    public EntityManagerFactory getFactory() {
        //YOu can have as much EM as DAO
        return this.factory;
    }
}