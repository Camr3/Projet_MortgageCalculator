package org.projet.DAL;

public class QueryBox {
    public static final String FETCH_INTEREST_RATE_BY_BANK = "SELECT * FROM banks WHERE name LIKE ?";
    public static final String FETCH_BANK_LOWEST_INTEREST_RATE = "SELECT * FROM banks WHERE interest_rate = (SELECT MIN(interest_rate) FROM banks);";
    public static final String FETCH_SERVICE_BY_NAME = "SELECT * FROM services WHERE name like ?";
    public static final String FETCH_BANK_ID_BY_SERVICE_NAME = "SELECT * FROM banks b "
            + "JOIN bank_services bs ON b.bank_id = bs.bank_id "
            + "JOIN services s ON bs.service_id = s.service_id "
            + "WHERE s.name = ?";


}
