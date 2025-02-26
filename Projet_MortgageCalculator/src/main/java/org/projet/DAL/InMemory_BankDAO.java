package org.projet.DAL;

import org.projet.BLL.Model.Bank;
import org.projet.DL.InMemory_DB;

public class InMemory_BankDAO implements IBankDAO{
    InMemory_DB datastore;

    public InMemory_BankDAO() {
        this.datastore = InMemory_DB.getInstance();
    }

    public double fetchInterestRateByBankName(String bankName ){
        var banks =this.datastore.getBanks();
        for(var bank:banks){
            if(bank.getName().equals(bankName)){
                return bank.getInterestRate();
            }
        }
        return 0;
    }
    public Bank fetchLowestInterestRate(){
        var banks =this.datastore.getBanks();
        double lowestInterestRate = banks.get(0).getInterestRate();
        Bank lowestBank = banks.get(0);
        for(var bank:banks){
            if(bank.getInterestRate()<lowestInterestRate){
                lowestInterestRate = bank.getInterestRate();
                lowestBank = bank;
            }

        }return lowestBank;
    }
}
