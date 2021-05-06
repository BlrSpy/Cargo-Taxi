package com.taxi.cargo.dao;

import com.taxi.cargo.bean.impl.Logistician;

import java.util.List;
import java.util.Optional;

public interface LogisticianDAO {

    List<Logistician> getAllEntity() throws DAOException;
    Optional<Logistician> getEntityById(Long id) throws DAOException;
    void getUpdate(Logistician entity) throws DAOException;
    void getDelete(Long id) throws DAOException;
    void getCreate(Logistician entity) throws DAOException;
    void returnConnectionInPool() throws DAOException;
    java.sql.PreparedStatement getPrepareStatement(String sql) throws DAOException;
    void closePrepareStatement(java.sql.PreparedStatement ps) throws DAOException;

}
