package com.taxi.cargo.dao.impl;

import com.taxi.cargo.bean.impl.Driver;
import com.taxi.cargo.dao.ConnectionPool;
import com.taxi.cargo.dao.DAOException;
import com.taxi.cargo.dao.DriverDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverDAOImpl implements DriverDAO {

    @Override
    public List<Driver> getAllEntity() throws DAOException {
        final String SELECT_ALL_DRIVERS = "SELECT * FROM drivers";

        List<Driver> list = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_DRIVERS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Driver driver = new Driver();

                driver.setDriverId(resultSet.getInt("driverId"));
                driver.setName(resultSet.getString("name"));
                driver.setSurname(resultSet.getString("surname"));
                driver.setLogin(resultSet.getString("login"));
                driver.setPassword(resultSet.getString("password"));
                driver.setMobilePhone(resultSet.getString("mobilePhone"));
                driver.setEmail(resultSet.getString("email"));
                driver.setCar(resultSet.getString("car"));
                driver.setCarMaxWeightKg(resultSet.getInt("carMaxWeightKg"));
                driver.setCarBodyLengthM(resultSet.getDouble("carBodyLengthM"));
                driver.setCarBodyWidthM(resultSet.getDouble("carBodyWidthM"));
                driver.setCarBodyHeightM(resultSet.getDouble("carBodyHeightM"));

                list.add(driver);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    @Override
    public Optional<Driver> getEntityById(Long id) throws DAOException {
        final String FIND_BY_ID = "SELECT * FROM drivers WHERE id='"
                + id + "'";

        Driver driver;
        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet;
            preparedStatement = getPrepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            driver = new Driver();

            driver.setDriverId(resultSet.getInt("driverId"));
            driver.setName(resultSet.getString("name"));
            driver.setSurname(resultSet.getString("surname"));
            driver.setLogin(resultSet.getString("login"));
            driver.setPassword(resultSet.getString("password"));
            driver.setMobilePhone(resultSet.getString("mobilePhone"));
            driver.setEmail(resultSet.getString("email"));
            driver.setCar(resultSet.getString("car"));
            driver.setCarMaxWeightKg(resultSet.getInt("carMaxWeightKg"));
            driver.setCarBodyLengthM(resultSet.getDouble("carBodyLengthM"));
            driver.setCarBodyWidthM(resultSet.getDouble("carBodyWidthM"));
            driver.setCarBodyHeightM(resultSet.getDouble("carBodyHeightM"));

            resultSet.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return Optional.ofNullable(driver);
    }

    @Override
    public void getUpdate(Driver entity) throws DAOException {
        final String UPDATE_DRIVER = "UPDATE drivers SET name = '" +
                entity.getName()
                + "', surname = '" + entity.getSurname()
                + "', login = '" + entity.getLogin()
                + "', password =  '" + entity.getPassword()
                + "', mobilePhone =  '" + entity.getMobilePhone()
                + "', email =  '" + entity.getEmail()
                + "', car =  '" + entity.getCar()
                + "', carMaxWeightKg =  '" + entity.getCarMaxWeightKg()
                + "', carBodyLengthM =  '" + entity.getCarBodyLengthM()
                + "', carBodyWidthM =  '" + entity.getCarBodyWidthM()
                + "', carBodyHeightM =  '" + entity.getCarBodyHeightM()
                + "' WHERE id = " + entity.getDriverId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_DRIVER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getDelete(Long id) throws DAOException {
        final String DELETE_DRIVER = "DELETE FROM drivers WHERE id = "
                + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_DRIVER);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getCreate(Driver entity) throws DAOException {
        final String INSERT_DRIVER =
                "INSERT INTO drivers " +
                        "(name, surname, login, password, mobilePhone, " +
                        "email, car, carMaxWeightKg, carBodyLengthM," +
                        "carBodyWidthM, carBodyHeightM) values ('"
                        + entity.getName()
                        + "', '" + entity.getSurname()
                        + "', '" + entity.getLogin()
                        + "', '" + entity.getPassword()
                        + "', '" + entity.getMobilePhone()
                        + "', '" + entity.getEmail()
                        + "', '" + entity.getCar()
                        + "', '" + entity.getCarMaxWeightKg()
                        + "', '" + entity.getCarBodyLengthM()
                        + "', '" + entity.getCarBodyWidthM()
                        + "', '" + entity.getCarBodyHeightM() + "')";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_DRIVER);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void returnConnectionInPool() throws DAOException {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.retrieve();
        connectionPool.putBack(connection);
    }

    @Override
    public PreparedStatement getPrepareStatement(String sql) throws DAOException {
        PreparedStatement ps;
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.retrieve();
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        return ps;
    }

    @Override
    public void closePrepareStatement(PreparedStatement ps) throws DAOException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }
    }
}