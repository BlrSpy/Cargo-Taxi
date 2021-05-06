package com.taxi.cargo.dao.impl;

import com.taxi.cargo.bean.impl.Logistician;
import com.taxi.cargo.dao.ConnectionPool;
import com.taxi.cargo.dao.DAOException;
import com.taxi.cargo.dao.LogisticianDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LogisticianDAOImpl implements LogisticianDAO {
    
    @Override
    public List<Logistician> getAllEntity() throws DAOException {
        final String SELECT_ALL_LOGISTICIANS = "SELECT * FROM logisticians";

        List<Logistician> list = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_LOGISTICIANS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Logistician logistician = new Logistician();

                logistician.setLogisticianId(resultSet.getInt("logisticianId"));
                logistician.setName(resultSet.getString("name"));
                logistician.setSurname(resultSet.getString("surname"));
                logistician.setLogin(resultSet.getString("login"));
                logistician.setPassword(resultSet.getString("password"));
                logistician.setMobilePhone(resultSet.getString("mobilePhone"));
                logistician.setEmail(resultSet.getString("email"));
                logistician.setLocation(resultSet.getString("location"));

                list.add(logistician);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    @Override
    public Optional<Logistician> getEntityById(Long id) throws DAOException {
        final String FIND_BY_ID = "SELECT * FROM logisticians WHERE id='"
                + id + "'";

        Logistician logistician;
        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet;
            preparedStatement = getPrepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            logistician = new Logistician();

            logistician.setLogisticianId(resultSet.getInt("logisticianId"));
            logistician.setName(resultSet.getString("name"));
            logistician.setSurname(resultSet.getString("surname"));
            logistician.setLogin(resultSet.getString("login"));
            logistician.setPassword(resultSet.getString("password"));
            logistician.setMobilePhone(resultSet.getString("mobilePhone"));
            logistician.setEmail(resultSet.getString("email"));
            logistician.setLocation(resultSet.getString("location"));

            resultSet.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return Optional.ofNullable(logistician);
    }

    @Override
    public void getUpdate(Logistician entity) throws DAOException {
        final String UPDATE_LOGISTICIAN = "UPDATE logisticians SET name = '" +
                entity.getName()
                + "', surname = '" + entity.getSurname()
                + "', login = '" + entity.getLogin()
                + "', password =  '" + entity.getPassword()
                + "', mobilePhone =  '" + entity.getMobilePhone()
                + "', email =  '" + entity.getEmail()
                + "', location =  '" + entity.getLocation()
                + "' WHERE id = " + entity.getLogisticianId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_LOGISTICIAN);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getDelete(Long id) throws DAOException {
        final String DELETE_LOGISTICIAN = "DELETE FROM logisticians WHERE id = "
                + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_LOGISTICIAN);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getCreate(Logistician entity) throws DAOException {
        final String INSERT_LOGISTICIAN =
                "INSERT INTO logisticians " +
                        "(name, surname, login, password, mobilePhone, " +
                        "email, location) values ('"
                        + entity.getName()
                        + "', '" + entity.getSurname()
                        + "', '" + entity.getLogin()
                        + "', '" + entity.getPassword()
                        + "', '" + entity.getMobilePhone()
                        + "', '" + entity.getEmail()
                        + "', '" + entity.getLocation() + "')";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_LOGISTICIAN);
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
