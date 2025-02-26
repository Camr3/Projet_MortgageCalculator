package org.projet.DAL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.projet.BLL.Model.Bank;

import java.util.List;

public class InDB_JPA_ServiceDAO implements IService{
    EntityManager entityManager=null;

    public InDB_JPA_ServiceDAO() {
        this.entityManager = EM_Provider
                .getInstance()
                .getFactory()
                .createEntityManager();
    }

    @Override
    public List<Bank> fetchBanksByService(String nameService) {
        List<Bank> bankList = null;
        try{
            entityManager.getTransaction().begin();
            String sql = "SELECT * FROM banks b "
                    + "JOIN bank_services bs ON b.bank_id = bs.bank_id "
                    + "JOIN services s ON bs.service_id = s.service_id "
                    + "WHERE s.name = ?";
            Query nativeQuery = this.entityManager.createNativeQuery(sql, Bank.class);
            nativeQuery.setParameter(1, nameService);
            bankList = nativeQuery.getResultList();
            this.entityManager.getTransaction().commit();

        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
        }
        return bankList;
    }
}
