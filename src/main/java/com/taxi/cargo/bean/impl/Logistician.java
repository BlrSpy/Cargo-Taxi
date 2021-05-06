package com.taxi.cargo.bean.impl;

import com.taxi.cargo.bean.Entity;

import java.util.Objects;

public class Logistician extends Entity {

    private long logisticianId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String mobilePhone;
    private String email;
    private String location;

    public Logistician() {
        long currentId = getId();
        setId(++currentId);
    }

    public Logistician(String name, String surname, String login, String password, String mobilePhone,
                       String email, String location) {
        long currentId = getLogisticianId();
        setLogisticianId(++currentId);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.location = location;
    }

    public Logistician(long logisticianId, String name, String surname, String login, String password,
                       String mobilePhone, String email, String location) {
        this.logisticianId = logisticianId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.location = location;
    }

    public long getLogisticianId() {
        return logisticianId;
    }

    public void setLogisticianId (long logisticianId) {
        this.logisticianId = logisticianId;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Logistician that = (Logistician) o;
        return getLogisticianId() == that.getLogisticianId() && getName().equals(that.getName()) && getSurname().equals(that.getSurname()) && getLogin().equals(that.getLogin()) && getPassword().equals(that.getPassword()) && getMobilePhone().equals(that.getMobilePhone()) && getEmail().equals(that.getEmail()) && getLocation().equals(that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogisticianId(), getName(), getSurname(), getLogin(), getPassword(), getMobilePhone(), getEmail(), getLocation());
    }

    @Override
    public String toString() {
        return "Logistician{" +
                "logisticianId=" + logisticianId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
