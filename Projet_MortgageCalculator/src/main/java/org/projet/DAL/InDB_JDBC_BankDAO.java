package org.projet.DAL;

import org.projet.BLL.Model.Bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InDB_JDBC_BankDAO implements IBankDAO {

    DBConnector connector;
    public InDB_JDBC_BankDAO() {
        this.connector = DBConnector.getInstance();
    }
    @Override
    public double fetchInterestRateByBankName(String bankName) {
        String sql = QueryBox.FETCH_INTEREST_RATE_BY_BANK;
        try{
            PreparedStatement pst =this.connector.getConnection().prepareStatement(sql);
            pst.setString(1, bankName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
            double interestRate = rs.getDouble(3);
            return interestRate;
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public Bank fetchLowestInterestRate() {
        String sql = QueryBox.FETCH_BANK_LOWEST_INTEREST_RATE;
        try{
            PreparedStatement pst =this.connector.getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                int code = rs.getInt(1);
                String bankName = rs.getString(2);
                double interestRate = rs.getDouble(3);
                double insuranceRate = rs.getDouble(4);
                Bank bank = new Bank(code, bankName, interestRate, insuranceRate);
                return bank;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
