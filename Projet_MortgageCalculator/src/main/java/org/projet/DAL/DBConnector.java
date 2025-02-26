package org.projet.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private final String DB_HOST = "mysql-camilomantilla.alwaysdata.net";
    private final String DB_NAME ="camilomantilla_bdeb";
    private final String DB_USER ="389935_bdeb";
    private final String DB_PASSWORD ="6284588";
    private final String DB_URL = "jdbc:mariadb://"+DB_HOST+"/"+DB_NAME;
    private Connection conn = null;
    private static DBConnector instance = null;


    public static DBConnector getInstance() {
        if (DBConnector.instance == null)
            DBConnector.instance = new DBConnector();
        return DBConnector.instance;
    }

    private DBConnector() {
        //load connection infos from properties file
        try {
            this.conn = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
}
