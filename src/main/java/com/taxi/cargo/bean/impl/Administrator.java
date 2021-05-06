package com.taxi.cargo.bean.impl;

import com.taxi.cargo.bean.Entity;

import java.util.Objects;

public class Administrator extends Entity {

    private long adminId;
    private String name;
    private String surname;
    private String login;
    private String password;

    public Administrator() {
        long currentId = getId();
        setId(++currentId);
    }

    public Administrator(String name, String surname, String login, String password) {
        long currentId = getAdminId();
        setAdminId(++currentId);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public Administrator(long adminId, String name, String surname, String login, String password) {
        this.adminId = adminId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId (long adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrator that = (Administrator) o;
        return getAdminId() == that.getAdminId() && getName().equals(that.getName()) && getSurname().equals(that.getSurname()) && getLogin().equals(that.getLogin()) && getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAdminId(), getName(), getSurname(), getLogin(), getPassword());
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
