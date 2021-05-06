package com.taxi.cargo.dao;

import com.taxi.cargo.bean.impl.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdministratorDAO {

    List<Administrator> getAllEntity() throws DAOException;
    Optional<Administrator> getEntityById(Long id) throws DAOException;
    void getUpdate(Administrator entity) throws DAOException;
    void getDelete(Long id) throws DAOException;
    void getCreate(Administrator entity) throws DAOException;
    void returnConnectionInPool() throws DAOException;
    java.sql.PreparedStatement getPrepareStatement(String sql) throws DAOException;
    void closePrepareStatement(java.sql.PreparedStatement ps) throws DAOException;

}
