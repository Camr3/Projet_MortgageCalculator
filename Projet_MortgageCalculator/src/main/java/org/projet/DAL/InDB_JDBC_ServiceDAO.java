package org.projet.DAL;

import org.projet.BLL.Model.Bank;
import org.projet.BLL.Model.Service;
import org.projet.DL.InMemory_DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InDB_JDBC_ServiceDAO implements IService {

    DBConnector connector;

    public InDB_JDBC_ServiceDAO() {
        this.connector = DBConnector.getInstance();
    }

    @Override
    public List<Bank> fetchBanksByService(String serviceName) {
        List<Bank> banks = new ArrayList<>();
        String sql = QueryBox.FETCH_BANK_ID_BY_SERVICE_NAME;
        try {
            PreparedStatement pst = this.connector.getConnection().prepareStatement(sql);
            pst.setString(1, serviceName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double interest = rs.getDouble(3);
                double insurance = rs.getDouble(4);
                banks.add(new Bank(id, name, interest, insurance));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return banks;

    }
}
