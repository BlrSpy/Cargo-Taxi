package com.taxi.cargo.bean.impl;

import com.taxi.cargo.bean.Entity;

import java.util.Objects;

public class Driver extends Entity {

    private long driverId;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String mobilePhone;
    private String email;
    private String car;
    private int carMaxWeightKg;
    private double carBodyLengthM;
    private double carBodyWidthM;
    private double carBodyHeightM;

    public Driver() {
        long currentId = getId();
        setId(++currentId);
    }

    public Driver(String name, String surname, String login, String password,
                  String mobilePhone, String email, String car, int carMaxWeightKg,
                  double carBodyLengthM, double carBodyWidthM, double carBodyHeightM) {
        long currentId = getDriverId();
        setDriverId(++currentId);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.car = car;
        this.carMaxWeightKg = carMaxWeightKg;
        this.carBodyLengthM = carBodyLengthM;
        this.carBodyWidthM = carBodyWidthM;
        this.carBodyHeightM = carBodyHeightM;
    }

    public Driver(long driverId, String name, String surname, String login, String password,
                  String mobilePhone, String email, String car, int carMaxWeightKg,
                  double carBodyLengthM, double carBodyWidthM, double carBodyHeightM) {
        this.driverId = driverId;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.car = car;
        this.carMaxWeightKg = carMaxWeightKg;
        this.carBodyLengthM = carBodyLengthM;
        this.carBodyWidthM = carBodyWidthM;
        this.carBodyHeightM = carBodyHeightM;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId (long driverId) {
        this.driverId = driverId;
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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getCarMaxWeightKg() {
        return carMaxWeightKg;
    }

    public void setCarMaxWeightKg(int carMaxWeightKg) {
        this.carMaxWeightKg = carMaxWeightKg;
    }

    public double getCarBodyLengthM() {
        return carBodyLengthM;
    }

    public void setCarBodyLengthM(double carBodyLengthM) {
        this.carBodyLengthM = carBodyLengthM;
    }

    public double getCarBodyWidthM() {
        return carBodyWidthM;
    }

    public void setCarBodyWidthM(double carBodyWidthM) {
        this.carBodyWidthM = carBodyWidthM;
    }

    public double getCarBodyHeightM() {
        return carBodyHeightM;
    }

    public void setCarBodyHeightM(double carBodyHeightM) {
        this.carBodyHeightM = carBodyHeightM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return getDriverId() == driver.getDriverId() && getCarMaxWeightKg() == driver.getCarMaxWeightKg() && Double.compare(driver.getCarBodyLengthM(), getCarBodyLengthM()) == 0 && Double.compare(driver.getCarBodyWidthM(), getCarBodyWidthM()) == 0 && Double.compare(driver.getCarBodyHeightM(), getCarBodyHeightM()) == 0 && getName().equals(driver.getName()) && getSurname().equals(driver.getSurname()) && getLogin().equals(driver.getLogin()) && getPassword().equals(driver.getPassword()) && getMobilePhone().equals(driver.getMobilePhone()) && getEmail().equals(driver.getEmail()) && getCar().equals(driver.getCar());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriverId(), getName(), getSurname(), getLogin(), getPassword(), getMobilePhone(), getEmail(), getCar(), getCarMaxWeightKg(), getCarBodyLengthM(), getCarBodyWidthM(), getCarBodyHeightM());
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", car='" + car + '\'' +
                ", carMaxWeightKg=" + carMaxWeightKg +
                ", carBodyLengthM=" + carBodyLengthM +
                ", carBodyWidthM=" + carBodyWidthM +
                ", carBodyHeightM=" + carBodyHeightM +
                '}';
    }
}
