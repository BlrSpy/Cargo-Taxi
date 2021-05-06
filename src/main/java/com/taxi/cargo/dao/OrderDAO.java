package com.taxi.cargo.dao;

import com.taxi.cargo.bean.impl.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    List<Order> getAllEntity() throws DAOException;
    Optional<Order> getEntityById(Long id) throws DAOException;
    void getUpdate(Order entity) throws DAOException;
    void getDelete(Long id) throws DAOException;
    void getCreate(Order entity) throws DAOException;
    void returnConnectionInPool() throws DAOException;
    java.sql.PreparedStatement getPrepareStatement(String sql) throws DAOException;
    void closePrepareStatement(java.sql.PreparedStatement ps) throws DAOException;

}
