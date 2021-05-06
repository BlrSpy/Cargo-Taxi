package com.taxi.cargo.dao.impl;

import com.taxi.cargo.bean.impl.Order;
import com.taxi.cargo.dao.ConnectionPool;
import com.taxi.cargo.dao.DAOException;
import com.taxi.cargo.dao.OrderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public List<Order> getAllEntity() throws DAOException {
        final String SELECT_ALL_ORDERS = "SELECT * FROM orders";

        List<Order> list = new ArrayList<>();
        PreparedStatement preparedStatement = getPrepareStatement(SELECT_ALL_ORDERS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();

                order.setOrderId(resultSet.getInt("id"));
                order.setTripType(resultSet.getString("tripType"));
                order.setCarType(resultSet.getString("carType"));
                order.setLoaderQuantity(resultSet.getInt("loaderQuantity"));
                order.setHourQuantity(resultSet.getDouble("hourQuantity"));
                order.setKmQuantity(resultSet.getDouble("kmQuantity"));
                order.setMobilePhone(resultSet.getString("mobilePhone"));
                if (!resultSet.getString("email").isEmpty()) {
                    order.setEmail(resultSet.getString("email"));
                }
                if (!resultSet.getString("loadingPoint").isEmpty()) {
                    order.setLoadingPoint(resultSet.getString("loadingPoint"));
                }
                if (!resultSet.getString("unloadingPoint").isEmpty()) {
                    order.setUnloadingPoint(resultSet.getString("unloadingPoint"));
                }
                if (!resultSet.getString("logistcianInfo").isEmpty()) {
                    order.setLogistcianInfo(resultSet.getString("logistcianInfo"));
                }
                if (!resultSet.getString("driverInfo").isEmpty()) {
                    order.setDriverInfo(resultSet.getString("driverInfo"));
                }
                order.setCompleted(resultSet.getBoolean("isCompleted"));
                order.setDate(resultSet.getString("date"));

                list.add(order);
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }

        return list;
    }

    @Override
    public Optional<Order> getEntityById(Long id) throws DAOException {
        final String FIND_BY_ID = "SELECT * FROM orders WHERE id='"
                + id + "'";

        Order order;
        PreparedStatement preparedStatement;
        try {
            ResultSet resultSet;
            preparedStatement = getPrepareStatement(FIND_BY_ID);
            resultSet = preparedStatement.executeQuery();

            order = new Order();

            order.setOrderId(resultSet.getInt("id"));
            order.setTripType(resultSet.getString("tripType"));
            order.setCarType(resultSet.getString("carType"));
            order.setLoaderQuantity(resultSet.getInt("loaderQuantity"));
            order.setHourQuantity(resultSet.getDouble("hourQuantity"));
            order.setKmQuantity(resultSet.getDouble("kmQuantity"));
            order.setMobilePhone(resultSet.getString("mobilePhone"));
            if (!resultSet.getString("email").isEmpty()) {
                order.setEmail(resultSet.getString("email"));
            }
            if (!resultSet.getString("loadingPoint").isEmpty()) {
                order.setLoadingPoint(resultSet.getString("loadingPoint"));
            }
            if (!resultSet.getString("unloadingPoint").isEmpty()) {
                order.setUnloadingPoint(resultSet.getString("unloadingPoint"));
            }
            if (!resultSet.getString("logistcianInfo").isEmpty()) {
                order.setLogistcianInfo(resultSet.getString("logistcianInfo"));
            }
            if (!resultSet.getString("driverInfo").isEmpty()) {
                order.setDriverInfo(resultSet.getString("driverInfo"));
            }
            order.setCompleted(resultSet.getBoolean("isCompleted"));
            order.setDate(resultSet.getString("date"));

            resultSet.close();
        } catch(SQLException e){
                throw new DAOException(e);
        }
        return Optional.ofNullable(order);
    }

    @Override
    public void getUpdate(Order entity) throws DAOException {
        final String UPDATE_ORDER = "UPDATE orders SET tripType = '" +
                entity.getTripType()
                + "', carType = '" + entity.getCarType()
                + "', loaderQuantity = '" + entity.getLoaderQuantity()
                + "', hourQuantity =  '" + entity.getHourQuantity()
                + "', kmQuantity =  '" + entity.getKmQuantity()
                + "', mobilePhone =  '" + entity.getMobilePhone()
                + "', email =  '" + entity.getEmail()
                + "', loadingPoint =  '" + entity.getLoadingPoint()
                + "', unloadingPoint =  '" + entity.getUnloadingPoint()
                + "', logistcianInfo =  '" + entity.getLogistcianInfo()
                + "', driverInfo =  '" + entity.getDriverInfo()
                + "', isCompleted =  '" + entity.isCompleted()
                + "', date =  '" + entity.getDate()
                + "' WHERE id = " + entity.getOrderId();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(UPDATE_ORDER);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getDelete(Long id) throws DAOException {
        final String DELETE_ORDER = "DELETE FROM orders WHERE id = "
                + id;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(DELETE_ORDER);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            closePrepareStatement(preparedStatement);
        }
    }

    @Override
    public void getCreate(Order entity) throws DAOException {
        final String INSERT_ORDER =
                "INSERT INTO orders " +
                        "(tripType, carType, loaderQuantity, hourQuantity, kmQuantity, " +
                        "mobilePhone, email, loadingPoint, unloadingPoint, logisticianInfo," +
                        "driverInfo, isCompleted, date) values ('"
                + entity.getTripType()
                + "', '" + entity.getLoaderQuantity()
                + "', '" + entity.getHourQuantity()
                + "', '" + entity.getKmQuantity()
                + "', '" + entity.getMobilePhone()
                + "', '" + entity.getEmail()
                + "', '" + entity.getLoadingPoint()
                + "', '" + entity.getUnloadingPoint()
                + "', '" + entity.getLogistcianInfo()
                + "', '" + entity.getDriverInfo()
                + "', '" + entity.isCompleted()
                + "', '" + entity.getDate() + "')";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getPrepareStatement(INSERT_ORDER);
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
