package com.taxi.cargo.dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

    private final Vector<Connection> availableConnections = new Vector<>();
    private final Vector<Connection> usedConnections = new Vector<>();


    public ConnectionPool() throws DAOException {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        for (int i = 0; i < 10; i++) {
            availableConnections.addElement(getConnection());
        }
    }

    private Connection getConnection() throws DAOException {

        Connection conn;
        final String URL = "jdbc:mysql://localhost:3306/db";
        final String USERNAME = "root";
        final String PASSWORD = "gp29RRid62kjF43ds1H";

        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return conn;
    }

    public synchronized Connection retrieve() throws DAOException {
        Connection newConnection;
        if (availableConnections.size() == 0) {
            newConnection = getConnection();
        } else {
            newConnection = availableConnections.lastElement();
            availableConnections.removeElement(newConnection);
        }
        usedConnections.addElement(newConnection);
        return newConnection;
    }

    public synchronized void putBack(Connection c) throws DAOException {
        if (c != null) {
            if (usedConnections.removeElement(c)) {
                availableConnections.addElement(c);
            } else {
                throw new DAOException("Connection not in the usedConnections. ");
            }
        }
    }
}
