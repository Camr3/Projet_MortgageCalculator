package org.projet.DAL;

import org.projet.BLL.Model.Bank;

public interface IBankDAO {
    public double fetchInterestRateByBankName(String bankName );
    public Bank fetchLowestInterestRate();
}
