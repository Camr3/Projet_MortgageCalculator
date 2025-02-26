package org.projet.DAL;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.projet.BLL.Model.Bank;

import java.util.List;

public class InDB_JPA_BankDAO implements IBankDAO {

    EntityManager entityManager=null;

    public InDB_JPA_BankDAO() {
        this.entityManager = EM_Provider
                .getInstance()
                .getFactory()
                .createEntityManager();
    }


    @Override
    public double fetchInterestRateByBankName(String bankName) {
        Bank result = null;
        try {
            this.entityManager.getTransaction().begin();
            String jpql = "SELECT b FROM Bank b WHERE b.name = :nom";
            TypedQuery<Bank> query = this.entityManager.createQuery(jpql, Bank.class);
            query.setParameter("nom", bankName);
            result = query.getSingleResult();
            System.out.println(result);
            this.entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        }
        return result.getInterestRate();

        /*Bank bank = this.entityManager.find(Bank.class, bankName);
        return bank.getInterestRate();*/
    }

    @Override
    public Bank fetchLowestInterestRate() {
       Bank result = null;
        try{
            this.entityManager.getTransaction().begin();
            String sql = "SELECT * FROM banks WHERE interest_rate = (SELECT MIN(interest_rate) FROM banks);";
            Query nativeQuery = this.entityManager.createNativeQuery(sql);
            result = (Bank) nativeQuery.getSingleResult();
        }catch(Exception e){
            this.entityManager.getTransaction().rollback();
        }
        return result;
    }
}
