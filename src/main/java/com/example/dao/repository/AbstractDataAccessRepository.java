package com.example.dao.repository;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * AbstractDataAccessRepository
 */
public abstract class AbstractDataAccessRepository<T> implements DataAccessRepository<T> {

    String driver;
    String dburl;
    String username;
    String password;
    Connection con;

    // Initializer Block
    {
        try {
            FileReader reader = new FileReader(
                    "src/main/resources/connection.properties");
            Properties p = new Properties();
            p.load(reader);

            driver = p.getProperty("db.driver");
            username = p.getProperty("db.user");
            password = p.getProperty("db.password");
            dburl = p.getProperty("db.url");

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}