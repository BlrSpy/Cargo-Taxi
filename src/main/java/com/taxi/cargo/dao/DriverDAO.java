package com.taxi.cargo.dao;

import com.taxi.cargo.bean.impl.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverDAO {

    List<Driver> getAllEntity() throws DAOException;
    Optional<Driver> getEntityById(Long id) throws DAOException;
    void getUpdate(Driver entity) throws DAOException;
    void getDelete(Long id) throws DAOException;
    void getCreate(Driver entity) throws DAOException;
    void returnConnectionInPool() throws DAOException;
    java.sql.PreparedStatement getPrepareStatement(String sql) throws DAOException;
    void closePrepareStatement(java.sql.PreparedStatement ps) throws DAOException;

}
