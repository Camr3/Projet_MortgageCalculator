package org.projet.BLL.Service;

import org.projet.BLL.Model.Bank;
import org.projet.DAL.*;

import java.util.List;

public class InsuranceRateService {

    public static double fetchInterestRateByBankNameUsingInMemoryDB(String bankName ){
        InMemory_BankDAO inMemory_BankDAO = new InMemory_BankDAO();
        double taux = inMemory_BankDAO.fetchInterestRateByBankName(bankName);
        return taux;
    }
    public static Bank fetchLowestInterestRateUsingInMemoryDB(){
        InMemory_BankDAO inMemory_BankDAO = new InMemory_BankDAO();
        Bank lowestInterestRate = inMemory_BankDAO.fetchLowestInterestRate();
        return lowestInterestRate;
    }
    public static double fetchInterestRateByBankNameUsingJDBC(String bankName ){
        InDB_JDBC_BankDAO inDB_JDBC_BankDAO = new InDB_JDBC_BankDAO();
        double taux = inDB_JDBC_BankDAO.fetchInterestRateByBankName(bankName);
        return taux;
    }
    public static Bank fetchLowestInterestRateUsingJDBC(){
        InDB_JDBC_BankDAO inDB_JDBC_BankDAO = new InDB_JDBC_BankDAO();
        Bank lowestInterestRate = inDB_JDBC_BankDAO.fetchLowestInterestRate();
        return lowestInterestRate;
    }
    public static List<Bank> fetchBanksByServiceUsingInMemoryDB(String nameService) {
    InMemory_ServiceDAO inMemory_ServiceDAO = new InMemory_ServiceDAO();
    List<Bank> banks = inMemory_ServiceDAO.fetchBanksByService(nameService);
    return banks;
    }
    public static List<Bank> fetchBanksByServiceUsingJDBC(String nameService) {
        InDB_JDBC_ServiceDAO inDB_JDBC_ServiceDAO = new InDB_JDBC_ServiceDAO();
        List<Bank> banks = inDB_JDBC_ServiceDAO.fetchBanksByService(nameService);
        return banks;
    }
    public static double fetchInterestRateByBankNameUsingJPA(String bankName ){
        InDB_JPA_BankDAO InDB_JPA_BankDAO  = new InDB_JPA_BankDAO();
        double taux = InDB_JPA_BankDAO.fetchInterestRateByBankName(bankName);
        return taux;
    }
    public static Bank fetchLowestInterestRateUsingJPA(){
        InDB_JPA_BankDAO InDB_JPA_BankDAO  = new InDB_JPA_BankDAO();
        Bank lowestInterestRate = InDB_JPA_BankDAO.fetchLowestInterestRate();
        return lowestInterestRate;
    }
    public static List<Bank> fetchBanksByServiceUsingJPA(String nameService) {
        InDB_JPA_ServiceDAO inDB_JPA_ServiceDAO = new InDB_JPA_ServiceDAO();
        List<Bank> banks = inDB_JPA_ServiceDAO.fetchBanksByService(nameService);
        return banks;
    }






    /*
    public double obtenirTauxAssurance(double pret,int nbMois){}  */
}
