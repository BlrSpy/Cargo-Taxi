package com.taxi.cargo.dao;

import com.taxi.cargo.dao.impl.AdministratorDAOImpl;
import com.taxi.cargo.dao.impl.DriverDAOImpl;
import com.taxi.cargo.dao.impl.LogisticianDAOImpl;
import com.taxi.cargo.dao.impl.OrderDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    private final OrderDAO orderDAO = new OrderDAOImpl();
    private final AdministratorDAO adminDAO = new AdministratorDAOImpl();
    private final DriverDAO driverDAO = new DriverDAOImpl();
    private final LogisticianDAO logisticianDAO = new LogisticianDAOImpl();

    private DAOProvider() {}

    public static DAOProvider getInstance() {
        return instance;
    }

    public OrderDAO getOrderDAO() { return orderDAO; }
    public AdministratorDAO getAdminDAO() { return adminDAO; }
    public DriverDAO getDriverDAO() { return driverDAO; }
    public LogisticianDAO getLogisticianDAO() { return logisticianDAO; }
}
