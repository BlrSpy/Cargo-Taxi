package com.taxi.cargo.dao.impl;

import com.taxi.cargo.bean.impl.Administrator;
import com.taxi.cargo.dao.AdministratorDAO;
import com.taxi.cargo.dao.ConnectionPool;
import com.taxi.cargo.dao.DAOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdministratorDAOImpl implements AdministratorDAO {

    @Override
    public List<Administrator> getAllEntity() throws DAOException {
        final String SELECT_ALL_ADMINS = "SELECT * FROM admins";

        List<Administrator> list = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_ADMINS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Administrator admin = new Administrator();

                admin.setAdminId(resultSet.getInt("adminId"));
                admin.setName(resultSet.getString("name"));
                admin.setSurname(resultSet.getString("surname"));
                admin.setLogin(resultSet.getString("login"));
                admin.setPassword(resultSet.getString("password"));


                list.add(admin);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    @Override
    public Optional<Administrator> getEntityById(Long id) throws DAOException {
        final String FIND_BY_ID = "SELECT * FROM admins WHERE id='"
                + id + "'";

        Administrator admin;
        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet;
            preparedStatement = getPrepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            admin = new Administrator();

            admin.setAdminId(resultSet.getInt("adminId"));
            admin.setName(resultSet.getString("name"));
            admin.setSurname(resultSet.getString("surname"));
            admin.setLogin(resultSet.getString("login"));
            admin.setPassword(resultSet.getString("password"));

            resultSet.close();
        } catch(SQLException e){
            throw new DAOException(e);
        }
        return Optional.ofNullable(admin);
    }

    @Override
    public void getUpdate(Administrator entity) throws DAOException {
        final String UPDATE_ADMIN = "UPDATE admins SET name = '" +
                entity.getName()
                + "', surname = '" + entity.getSurname()
                + "', login = '" + entity.getLogin()
                + "', password =  '" + entity.getPassword()
                + "' WHERE id = " + entity.getAdminId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_ADMIN);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getDelete(Long id) throws DAOException {
        final String DELETE_ADMIN = "DELETE FROM admins WHERE id = "
                + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_ADMIN);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getCreate(Administrator entity) throws DAOException {
        final String INSERT_ADMIN =
                "INSERT INTO admins " +
                        "(name, surname, login, password) values ('"
                        + entity.getName()
                        + "', '" + entity.getSurname()
                        + "', '" + entity.getLogin()
                        + "', '" + entity.getPassword() + "')";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_ADMIN);
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
